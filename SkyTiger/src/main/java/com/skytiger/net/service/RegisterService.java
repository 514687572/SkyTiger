package com.skytiger.net.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.skytiger.net.dao.StUserDao;
import com.skytiger.net.entity.AddressInfo;
import com.skytiger.net.entity.Dictionary;
import com.skytiger.net.entity.StUser;
import com.skytiger.net.entity.SysTask;
import com.skytiger.net.utils.GrnerateUUID;

@Service
public class RegisterService {
	private WebDriver driver;
	private static Random rd = new Random();
	@Resource
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	@Resource
	private StUserDao stUserDao;
	@Resource
	private SysService sysService;
	
	public Map<String, Object> doRegister(final SysTask task) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		threadPoolTaskExecutor.execute(new Runnable() {  
            public void run() { 
            	try {
					register(task);
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });
		
		result.put("success", Boolean.TRUE);
		result.put("msg", "已开始注册");
		
		return result;
	}
	
	public void register(SysTask task) throws Exception {
		String baseurl = "http://m.tyfo.com/wap/user/userFoRegisterUI.htm";
		System.setProperty("sun.net.client.defaultReadTimeout", "95000");
		List<Dictionary> dicList = sysService.getDictoryByType("firefox");

		for (Dictionary dic : dicList) {
			if ("fx_path".equals(dic.getDicKey())) {
				System.setProperty("webdriver.firefox.bin",dic.getDicValue());
			} else {
				System.setProperty("webdriver.gecko.driver", dic.getDicValue());
			}
		}
		
		int num=task.getTaskCount();
		String adminId=task.getTaskRemark();
		String taskId=task.getTaskId();
		String businessId=task.getTaskBusinessName();
		
		for(int i = 0;i < num;i++){
			String f = "";
			String[] aa = {"3","5","7","8","9"};
			int r = (int) (Math.random()*aa.length);
			f = "1" + aa[r];
			String mobi =mobile(f);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(baseurl);
			String address =driver.getCurrentUrl();
			if(address.equals(baseurl)) {
				while(!ElementExist(By.id("mobile"))) {
					
				}
				if(driver.findElement(By.id("mobile")) != null) {
					driver.findElement(By.id("mobile")).sendKeys(mobi);
					if(driver.findElement(By.id("password")) != null) {
						driver.findElement(By.id("password")).sendKeys("123123aa");
						if(driver.findElement(By.xpath("//*[@id=\"allLi\"]/li[3]/div")) != null) {
							driver.findElement(By.xpath("//*[@id=\"allLi\"]/li[3]/div")).click();
							System.out.println(i);
							while(!ElementExist(By.id("errorMsg"))) {
								
							}
							String erro = driver.findElement(By.id("errorMsg")).getText();
						if(erro.equals("注册成功")) {
							StUser user=new StUser();
							user.setUserId(GrnerateUUID.getUUID());
							user.setUserMobile(mobi);
							user.setUserPassword("123123aa");
							user.setUpdateTime(new Date());
							user.setRemark(adminId);
							user.setBusinessId(Integer.parseInt(businessId));
							user.setTaskId(taskId);
							
							stUserDao.insert(user);
							driver.quit();
							
							for(int m=0;m<1;m++) {
								try {
									addAddress(mobi);
								} catch (Exception e) {
									m--;
								}
							}
							
						}else {
							num++;
							driver.quit();
							continue;
						}
					}else {
						num++;
						driver.quit();
						continue;
					}
				}else {
					num++;
					driver.quit();
					continue;
				}
			}else {
				num++;
				driver.quit();
				continue;
			}
			}else {
				num++;
				driver.quit();
				continue;
			}
			
			if(driver!=null) {
				try {
					driver.quit();
				} catch (Exception e) {
					
				}
			}
		}
		
		task.setTaskStatus("2");
		sysService.updateTaskStatus(task);
	}
	
	public static String mobile(String s) {
		for(int j = 0;j < 9;j++) {
			s += rd.nextInt(9);
		}
		return s;
	}
	
	public boolean ElementExist(By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void addAddress(String mobile) throws Exception {
		driver = new FirefoxDriver();
		String baseUrl = "http://sso.tyfo.com/authcode?appkey=65734592&redirecturl=http%3A%2F%2Fportal.tyfo.com%2Ftyfo%2Fuser%2FgoTyfoHome";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		String yy = driver.getCurrentUrl();
		
		List<AddressInfo> ai = sysService.getAddressList();
		AddressInfo info = ai.get(new Random().nextInt(ai.size() - 1));
		
		if (yy.equals(baseUrl)) {
			driver.findElement(By.id("loginName")).sendKeys(mobile);
			driver.findElement(By.id("password")).sendKeys("123123aa");
			driver.findElement(By.id("sureButton")).click();
			Thread.sleep(2000);
			String ur = driver.getCurrentUrl();
			String y = "http://portal.tyfo.com/tyfo/user/lostpass?type=1&loginFlag=1";
			if (ur.equals(y)) {
				driver.get("http://portal.tyfo.com/tyfo/address/addressList");
				Thread.sleep(2000);
				int i=0;
				while(!ElementExist(By.xpath("/html/body/div/img"))) {
					System.out.println("______________________________________________________________9870987098709");
					i++;
					if(i==5) {
						break;
					}
				}
				
				if(i!=5) {
					String src=driver.findElement(By.xpath("/html/body/div/img")).getAttribute("src");
					if(src.equals("http://portal.tyfo.com:80/tyfo//image/false.png")) {
						driver.getCurrentUrl();
					}
				}
				
				while(!ElementExist(By.xpath("/html/body/div[3]/div[4]/div[1]/a"))) {
					System.out.println("______________________________________________________________YUFOUYGIGIOUH");
				}
				if (driver.findElement(By.xpath("/html/body/div[3]/div[4]/div[1]/a")) != null) {
					driver.findElement(By.xpath("/html/body/div[3]/div[4]/div[1]/a")).click();
					
					i=0;
					while(!ElementExist(By.id("name"))) {
						i++;
						if(i==5) {
							break;
						}
					}
					
					if(i==5) {
						driver.findElement(By.xpath("/html/body/div[3]/div[4]/div[1]/a")).click();
					}
					
					driver.findElement(By.id("name")).clear();
					driver.findElement(By.id("name")).sendKeys(info.getInfoName());
					while(!ElementExist(By.id("mobile"))) {
						
					}
					if (driver.findElement(By.id("mobile")) != null) {
						driver.findElement(By.id("mobile")).clear();
						driver.findElement(By.id("mobile")).sendKeys(info.getInfoPhone());
						while(!ElementExist(By.id("province"))) {
							
						}
						try {
							if (driver.findElement(By.id("province")) != null) {
								Select se1 = new Select(driver.findElement(By.id("province")));
								se1.selectByValue(info.getInfoProvince());
								Thread.sleep(2000);
								if (driver.findElement(By.id("city")) != null) {
									Select se2 = new Select(driver.findElement(By.id("city")));
									se2.selectByValue(info.getInfoCity());
									Thread.sleep(2000);
									if (driver.findElement(By.id("county")) != null) {
										Select se3 = new Select(driver.findElement(By.id("county")));
										se3.selectByValue(info.getInfoArea());
										Thread.sleep(2000);
										if (driver.findElement(By.id("street")) != null) {
											driver.findElement(By.id("street")).click();
											driver.findElement(By.id("street")).clear();
											driver.findElement(By.id("street")).sendKeys(info.getAddressDetails());
											while(!ElementExist(By.name("default"))) {
												
											}
											if (driver.findElement(By.name("default")) != null) {
												driver.findElement(By.name("default")).click();
												if (driver.findElement(By.cssSelector("input.mem_button")) != null) {
													driver.findElement(By.cssSelector("input.mem_button")).click();
													driver.quit();
												} else {
													System.out.println("------未加载地址添加确认按钮");
													driver.quit();
												}
											} else {
												System.out.println("-----未加载地址默认框");
												driver.quit();
											}
										} else {
											System.out.println("-----未加载街道输入框");
											driver.quit();
										}
									} else {
										System.out.println("----未找到地区");
										driver.quit();
									}
								} else {
									System.out.println("----未找到城市");
									driver.quit();
								}
							} else {
								System.out.println("-----未找到省份");
								driver.quit();
							}
						} catch (Exception e) {
							driver.quit();
							e.printStackTrace();
						}
					} else {
						System.out.println("-----未找到手机");
						driver.quit();
					}
				} else {
					System.out.println("----未找到商品页面下单");
					driver.quit();
				}
			} else {
				System.out.println("---未找到商品地址");
				driver.quit();
			}
		} else {
			System.out.println("----未找到登录跳转地址");
			driver.quit();
		}
	}
	
}
