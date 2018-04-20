package com.skytiger.net.controller;

import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skytiger.net.entity.StUser;
import com.skytiger.net.service.SysService;
import com.skytiger.net.utils.GrnerateUUID;

@RestController
@RequestMapping("/register")
public class Register {
	private WebDriver driver;
	private static Random rd = new Random();
	@Resource
	private SysService sysService;
	
	@RequestMapping("/register")
	public void join(HttpServletRequest request) throws Exception {
		int num=Integer.parseInt(request.getParameter("num")+"");
		String f = "178";
		System.setProperty("sun.net.client.defaultReadTimeout", "95000");
		System.setProperty("webdriver.firefox.bin", "D:\\TOOLS\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.gecko.driver", "D:\\TOOLS\\Mozilla Firefox\\geckodriver.exe");
		
		for(int i = 0;i < num;i++){
			String mobi =mobile(f);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("http://m.tyfo.com/wap/user/userFoRegisterUI.htm");
			Thread.sleep(1000);
			driver.findElement(By.id("mobile")).sendKeys(mobi);
			Thread.sleep(1000);
			driver.findElement(By.id("password")).sendKeys("123123aa");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"allLi\"]/li[3]/div")).click();
			System.out.println(i);
			Thread.sleep(3000);
			driver.close();
			String erro = driver.findElement(By.id("errorMsg")).getText();
			if(erro.equals("注册成功")) {
				StUser user=new StUser();
				user.setUserId(GrnerateUUID.getUUID());
				user.setUserMobile(mobi);
				user.setUserPassword("123123aa");
				
				sysService.addUser(user);
			}else {
				System.out.println("注册不成功："+mobi);
				continue;
			}
		}
		
	}
	
	public static String mobile(String s) {
		for(int j = 0;j < 8;j++) {
			s += rd.nextInt(9);
		}
		return s;
	}
	
}
