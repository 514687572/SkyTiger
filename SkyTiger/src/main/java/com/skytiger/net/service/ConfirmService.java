package com.skytiger.net.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import com.skytiger.net.entity.Dictionary;
import com.skytiger.net.entity.StUser;
import com.skytiger.net.entity.SysBusiness;
import com.skytiger.net.entity.SysPost;

@Service
public class ConfirmService {
	private WebDriver driver;
	private String baseUrl;
	@Resource
	private SysService sysService;
	@Resource
	private BusinessService businessService;

	public void orderConfirm(List<StUser> us) throws Exception {
		StUser user = null;
		System.setProperty("sun.net.client.defaultReadTimeout", "95000");
		List<Dictionary> dicList=sysService.getDictoryByType("chrome");
		
		for(Dictionary dic:dicList) {
			if("fx_path".equals(dic.getDicKey())) {
				System.setProperty("webdriver.chrome.bin",dic.getDicValue());
			}else {
				System.setProperty("webdriver.chrome.driver",dic.getDicValue());
			}
		}

		List<SysPost> postList=sysService.getPostNumList();
		
		for (int i = 0; i < us.size(); i++) {
			user = us.get(i);
			SysPost post=null;
			
			if(postList!=null&&postList.size()>0) {
				post=postList.get(new Random().nextInt(postList.size()-1));
				SysBusiness business=sysService.getBusinessById(user.getBusinessId()+"");
				//先发货
				try {
					businessService.CollectGoods(post.getPostNum(),business.getSbPassword(), business.getSbName(),user.getOrderNum());
				} catch (Exception e) {
					continue;
				}
			}
			
			try {
				driver = new ChromeDriver();
				baseUrl = "http://sso.tyfo.com/authcode?appkey=65734592&redirecturl=http%3A%2F%2Fportal.tyfo.com%2Ftyfo%2Fuser%2FgoTyfoHome";
				driver.get(baseUrl);
				driver.manage().window().maximize();
				String Url = driver.getCurrentUrl();
				if (Url.equals(baseUrl)) {
					WebElement LoginName = driver.findElement(By.id("loginName"));
					if (LoginName != null) {
						driver.findElement(By.id("loginName")).sendKeys(user.getUserMobile());
						WebElement Password = driver.findElement(By.id("password"));
						if (Password != null) {
							driver.findElement(By.id("password")).sendKeys("123123aa");
							WebElement Sure = driver.findElement(By.id("sureButton"));
							if (Sure != null) {
								driver.findElement(By.id("sureButton")).click();
								Thread.sleep(1000);
								String s = "http://portal.tyfo.com/tyfo/user/lostpass?type=1&loginFlag=1";
								String ss = driver.getCurrentUrl();
								if (ss.equals(s)) {
									driver.get("http://portal.tyfo.com/tyfo/trade/toBuyerOrder?orderStatus=4");
									Thread.sleep(2000);
									
									if(ElementExist(By.xpath("/html/body/div[3]/div[4]/div[8]/div[1]/ul/li[1]/div[2]/div[2]/div/div[3]/div/a[1]"))) {
										WebElement Ok = driver.findElement(By.xpath("/html/body/div[3]/div[4]/div[8]/div[1]/ul/li[1]/div[2]/div[2]/div/div[3]/div/a[1]"));
										String ass = Ok.getText();
										if (Ok != null && ass.equals("确认收货")) {
											Ok.click();
											while(!ElementExist(By.xpath("/html/body/div[5]/div/div[3]/a[1]"))) {
												
											}
											driver.findElement(By.xpath("/html/body/div[5]/div/div[3]/a[1]")).click();
											Thread.sleep(1000);
											
											user.setUpdateTime(new Date());
											user.setUserStatus("e");
											sysService.updateByPrimaryKey(user);
											driver.quit();
										}else {
											driver.quit();
										}
									}else {
										driver.quit();
									}
								} else {
									driver.quit();
									System.out.println("未找到该元素！");
									continue;
								}
							} else {
								driver.quit();
								System.out.println("未找到该元素");
								continue;
							}
						} else {
							driver.quit();
							System.out.println("未找到该元素");
							continue;
						}
					} else {
						driver.quit();
						System.out.println("未找到该元素！");
						continue;
					}
				} else {
					driver.quit();
					continue;
				}
			} catch (Exception e) {
				driver.quit();
				continue;
			}

			if (driver != null) {
				try {
					driver.quit();
				} catch (Exception e) {

				}
			}
		}

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
