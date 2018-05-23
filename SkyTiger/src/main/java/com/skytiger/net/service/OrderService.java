package com.skytiger.net.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.skytiger.net.controller.TaskScheduledController;
import com.skytiger.net.entity.Dictionary;
import com.skytiger.net.entity.StUser;
import com.skytiger.net.entity.SysTask;

@Service
public class OrderService {
	private WebDriver driver;
	static String baseUrl;
	static int a = 0;
	static Random rd = new Random();
	static int x = rd.nextInt(100) + 999;
	@Resource
	private SysService sysService;
	@Resource
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	public void placeAnOrder(final String address, final String adminid, final String taskId) throws Exception {
		threadPoolTaskExecutor.execute(new Runnable() {
			public void run() {
				try {
					doPlaceAnOrder(address, adminid,taskId);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void doPlaceAnOrder(String address, String adminid,String taskId) throws Exception {
		System.setProperty("sun.net.client.defaultReadTimeout", "95000");
		List<StUser> al = sysService.getUsersByTaskId(taskId);

		StUser user = null;
		for (int i = 0; i < al.size(); i++) {
			user = al.get(i);
			try {
				createOrder(user,address,i);
			} catch (Exception e) {
				System.out.println(e);
				continue;
			}
		} 

		int userCount = sysService.getUserCreateOrder(taskId);
		SysTask task=sysService.getTaskById(taskId);

		if (userCount==task.getTaskCount()) {
			task.setTaskStatus("4");
			sysService.updateTaskStatus(task);
		}
		
		TaskScheduledController.isRunning=false;

	}
	
	public void createOrder(StUser user,String address,int i) throws Exception {
		if (i%2 == 0) {
			try {
				Map<String, String> mobileEmulation = new HashMap<String, String>();    
				   mobileEmulation.put("deviceName", "iPhone 6");    
				   Map<String, Object> chromeOptions = new HashMap<String, Object>();       
				   chromeOptions.put("mobileEmulation", mobileEmulation);       
				   DesiredCapabilities capabilities = DesiredCapabilities.chrome();         
				   capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				WebDriver drivers;
				System.setProperty("sun.net.client.defaultReadTimeout", "95000");
				List<Dictionary> dicList = sysService.getDictoryByType("chrome");

				for (Dictionary dic : dicList) {
					if ("fx_path".equals(dic.getDicKey())) {
						System.setProperty("webdriver.chrome.bin", dic.getDicValue());
					} else {
						System.setProperty("webdriver.chrome.driver", dic.getDicValue());
					}
				}
				
				drivers = new ChromeDriver(capabilities);
				drivers.manage().window().maximize();
				drivers.get("http://m.tyfo.com/wap/user/userLoginUI.htm?encodeURI=E521024F8A650F392D960B8F3B3A5BCCD0DD3A9541D05AF0CFD58DC50C8D2007");
				drivers.findElement(By.id("mobile")).sendKeys(user.getUserMobile());
				drivers.findElement(By.xpath("//*[@id=\"form1\"]/div[2]/input")).sendKeys("123123aa");
				drivers.findElement(By.xpath("//*[@id=\"bronwerDiv\"]/div/div[1]/p[1]")).click();
				drivers.get(address);
				drivers.findElement(By.xpath("/html/body/div[3]/div/footer/div[5]")).click();
				drivers.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/p")).click();
				Thread.sleep(1000);
				String MPrice = drivers.findElement(By.id("totalGoodPriceSpan")).getText();
				drivers.findElement(By.id("submitImg")).click();
				String MOrderId = drivers.findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/span")).getText();
				user.setOrderPrice(MPrice.split("￥")[1].trim());
				user.setUserStatus("p");
				drivers.findElement(By.xpath("/html/body/div[3]/div[4]/img")).click();
				user.setOrderNum(MOrderId.trim());
				sysService.updateByPrimaryKey(user);
				drivers.quit();
			} catch (Exception e) {
				driver.quit();
			}
		} else {
			WebDriver driver;
			List<Dictionary> dicList = sysService.getDictoryByType("chrome");

			for (Dictionary dic : dicList) {
				if ("fx_path".equals(dic.getDicKey())) {
					System.setProperty("webdriver.chrome.bin", dic.getDicValue());
				} else {
					System.setProperty("webdriver.chrome.driver", dic.getDicValue());
				}
			}
			driver = new ChromeDriver();
			String baseUrl = "http://sso.tyfo.com/authcode?appkey=65734592&redirecturl=http%3A%2F%2Fportal.tyfo.com%2Ftyfo%2Fuser%2FgoTyfoHome";
			driver.get(baseUrl);
			driver.manage().window().maximize();
			String yy = driver.getCurrentUrl();
			
				if (yy.equals(baseUrl)) {
					driver.findElement(By.id("loginName")).sendKeys(user.getUserMobile());
					driver.findElement(By.id("password")).sendKeys("123123aa");
					driver.findElement(By.id("sureButton")).click();
				}else {
					driver.quit();
					return;
				}
			
				Thread.sleep(2000);
				driver.get("http://portal.tyfo.com/tyfo/address/addressList");
				driver.get(address);
				String oraddress = driver.getCurrentUrl();
				if (oraddress.equals(address)) {
					/*while(!ElementExist(By.id("goods_price"))) {
					
					}*/
					String price = driver.findElement(By.id("goods_price")).getText();
					if (driver.findElement(By.id("buy_now")) != null) {
						driver.findElement(By.id("buy_now")).click();
						
						Thread.sleep(2000);
						int m=0;
						while(!ElementExist(By.id("submit_pay1"))) {
							System.out.println("______________________________________________________________9870987098709");
							m++;
							if(m==5) {
								break;
							}
						}
						
						if(m==5) {
							driver.getCurrentUrl();
						}
						
						if (driver.findElement(By.id("submit_pay1")) != null) {
							driver.findElement(By.id("submit_pay1")).click();
							Thread.sleep(2000);
							if (ElementExist(By.id("simplePopBtnSure")) == true) {
								driver.findElement(By.id("simplePopBtnSure")).click();
								Thread.sleep(1000);
								try {
									driver.findElement(By.id("submit_pay1")).click();
								} catch (Exception e) {
									driver.quit();
								}
								if (driver.findElement(By.xpath("/html/body/div[3]/div[3]/input[1]")) != null) {
									driver.findElement(By.xpath("/html/body/div[3]/div[3]/input[1]")).click();
									Thread.sleep(2000);
									driver.getWindowHandles();
									
									if (driver.findElement(By.id("submit_pay")) != null) {
										driver.findElement(By.id("submit_pay")).click();
										driver.get("http://portal.tyfo.com/tyfo/trade/toBuyerOrder?orderStatus=1");
										
										String orderId = driver.findElement(By.xpath("//*[@id=\"showOrder\"]/div[1]/ul/li/div[1]/div[2]/span")).getText();
										user.setOrderPrice(price);
										user.setUserStatus("p");
										user.setOrderNum(orderId.split("订单号:")[1].trim());
										sysService.updateByPrimaryKey(user);
										driver.quit();
									}else {
										driver.quit();
									}
								}
							} else {
								if (driver.findElement(By.xpath("/html/body/div[3]/div[3]/input[1]")) != null) {
									driver.findElement(By.xpath("/html/body/div[3]/div[3]/input[1]")).click();
									Thread.sleep(2000);
									driver.getWindowHandles();
									if (driver.findElement(By.id("submit_pay")) != null) {
										driver.findElement(By.id("submit_pay")).click();
										driver.get("http://portal.tyfo.com/tyfo/trade/toBuyerOrder?orderStatus=1");
										Thread.sleep(2000);
										String orderId = driver.findElement(By.xpath("//*[@id=\"showOrder\"]/div[1]/ul/li/div[1]/div[2]/span")).getText();
										user.setOrderPrice(price);
										user.setUserStatus("p");
										user.setOrderNum(orderId.split("订单号:")[1].trim());
										sysService.updateByPrimaryKey(user);
										driver.quit();
									}else {
										driver.quit();
									}
								}
							}
						} 
					}else {
						driver.quit();
					} 

				} 
		 } // ------判断pc
	}

	public static List<String> getUserMail(String path) throws Exception {
		List<String> mailList = new ArrayList<String>();
		int row = 0;
		String line;

		File file = new File(path);
		BufferedReader br = new BufferedReader(new FileReader(file));
		while ((line = br.readLine()) != null) {
			mailList.add(line);
			row++;
		}
		br.close();

		return mailList;
	}

	public boolean ElementExist(By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
