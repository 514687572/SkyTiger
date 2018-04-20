package com.skytiger.net.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skytiger.net.entity.StUser;
import com.skytiger.net.service.SysService;

@RestController
@RequestMapping("/order")
public class OrderConfirm {
	private WebDriver driver;
	private String baseUrl;
	@Resource
	private SysService sysService;

	@RequestMapping("/confirm")
	public void A_login() throws Exception {

		List<StUser> us = sysService.getUserListHasInfo();
		StUser user = null;
		for (int i = 0; i < us.size(); i++) {
			user = us.get(i);
			driver = new FirefoxDriver();
			baseUrl = "http://sso.tyfo.com/authcode?appkey=65734592&redirecturl=http%3A%2F%2Fportal.tyfo.com%2Ftyfo%2Fuser%2FgoTyfoHome";
			driver.get(baseUrl);
			driver.manage().window().maximize();
			driver.findElement(By.id("loginName")).sendKeys(user.getUserMobile());
			driver.findElement(By.id("password")).sendKeys("123123aa");
			driver.findElement(By.id("sureButton")).click();
			Thread.sleep(1000);
			driver.get("http://portal.tyfo.com/tyfo/trade/toBuyerOrder");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"showOrder\"]/div[1]/ul/li[1]/div[2]/div[2]/div/div[3]/div/a[1]"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/div[5]/div/div[3]/a[1]")).click();
			driver.close();
			Thread.sleep(1000);
			System.out.println(i);

			sysService.updateByPrimaryKey(user);
		}
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
}
