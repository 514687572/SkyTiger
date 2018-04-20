package com.skytiger.net.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skytiger.net.entity.StUser;
import com.skytiger.net.service.SysService;

@RestController
@RequestMapping("addInfo")
public class UserInfo {
	static WebDriver driver;
	static String baseUrl;
	public String address = "";
	static int a = 0;
	static Random rd = new Random();
	static int x = rd.nextInt(100) + 999;
	@Resource
	private SysService sysService;

	@RequestMapping("/placeAnOrder")
	public void placeAnOrder(HttpServletRequest request) throws Exception {
		System.setProperty("sun.net.client.defaultReadTimeout", "95000");
		List<StUser> al = sysService.getUserList();
		List<String> mo = getUserMail("C:\\doc\\tel.txt");
		List<String> name = getUserMail("C:\\doc\\name.txt");
		List<String> pr = getUserMail("C:\\doc\\province.txt");
		List<String> ci = getUserMail("C:\\doc\\city.txt");
		List<String> co = getUserMail("C:\\doc\\county.txt");
		List<String> add = getUserMail("C:\\doc\\adds.txt");
		int orderCount=Integer.parseInt(request.getParameter("count"));
		address=request.getParameter("address");
		
		StUser user=null;
		for (int i = 0; i < orderCount; i++) {
			user=al.get(i);
			System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver();
			baseUrl = "http://sso.tyfo.com/authcode?appkey=65734592&redirecturl=http%3A%2F%2Fportal.tyfo.com%2Ftyfo%2Fuser%2FgoTyfoHome";
			driver.get(baseUrl);
			driver.manage().window().maximize();
			String yy = driver.getCurrentUrl();
			if (yy.equals(baseUrl)) {
				driver.findElement(By.id("loginName")).sendKeys(user.getUserMobile());
				driver.findElement(By.id("password")).sendKeys("123123aa");
				driver.findElement(By.id("sureButton")).click();
				Thread.sleep(2000);
				String ur = driver.getCurrentUrl();
				String y = "http://portal.tyfo.com/tyfo/user/lostpass?type=1&loginFlag=1";
				if (ur.equals(y)) {
					driver.get("http://portal.tyfo.com/tyfo/address/addressList");
					Thread.sleep(3000);
					driver.findElement(By.xpath("/html/body/div[3]/div[4]/div[1]/a")).click();
					Thread.sleep(3000);
					driver.findElement(By.id("name")).clear();
					driver.findElement(By.id("name")).sendKeys(name.get(rd.nextInt(100)));
					Thread.sleep(1000);
					driver.findElement(By.id("mobile")).clear();
					driver.findElement(By.id("mobile")).sendKeys(mo.get(rd.nextInt(1000)));
					Thread.sleep(1000);
					Select se1 = new Select(driver.findElement(By.id("province")));
					se1.selectByValue(pr.get(a));
					Thread.sleep(2000);
					Select se2 = new Select(driver.findElement(By.id("city")));
					se2.selectByValue(ci.get(a));
					Select se3 = new Select(driver.findElement(By.id("county")));
					se3.selectByValue(co.get(a));
					a++;
					if (a == 8) {
						a = 0;
					}
					Thread.sleep(2000);
					driver.findElement(By.id("street")).click();
					driver.findElement(By.id("street")).clear();
					driver.findElement(By.id("street")).sendKeys(add.get(rd.nextInt(100)));
					Thread.sleep(1000);
					driver.findElement(By.name("default")).click();
					driver.findElement(By.cssSelector("input.mem_button")).click();

					Thread.sleep(5000);

					driver.get(address);
					Thread.sleep(2000);
					String price=driver.findElement(By.id("goods_price")).getText();
					driver.findElement(By.id("buy_now")).click();
					Thread.sleep(2000);
					driver.findElement(By.id("submit_pay1")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("/html/body/div[3]/div[3]/input[1]")).click();
					Thread.sleep(3000);
					driver.getWindowHandles();
					driver.findElement(By.id("submit_pay")).click();
					driver.close();
					user.setRemark("1");
					user.setOrderPrice(price);
					sysService.updateByPrimaryKey(user);
					Thread.sleep(rd.nextInt(1000) + 500);
				} else {
					System.out.println("用户名或密码错误：" + mo.get(i));
					driver.close();
					continue;
				}
			} else {
				System.out.println("未打开浏览器或浏览器版本过高");
			}

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

	public void C_zhuce(int num) throws Exception {
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("http://m.tyfo.com/wap/user/userFoRegisterUI.htm");
		driver.manage().window().maximize();
		File writename = new File("E:\\2.txt");
		writename.createNewFile();
		BufferedWriter out = new BufferedWriter(new FileWriter(writename));
		String s = "196789459" + "" + rd.nextInt(3);
		for (int i = 0; i < num; i++) {
			Thread.sleep(1000);
			driver.findElement(By.id("mobile")).sendKeys(s);
			Thread.sleep(1000);
			driver.findElement(By.id("password")).sendKeys("123123aa");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"allLi\"]/li[3]/div")).click();
			System.out.println(i);
			Thread.sleep(3000);
			driver.close();
			out.write(s);
			out.flush();
			out.close();
		}
	}
	
	@RequestMapping("/getAllUsers")
	public Map<String, Object> getAllUsers(HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		List<StUser> userList = sysService.getUserListNotSuccess();

		if(userList!=null&&userList.size()>0) {
			result.put("userList",userList);
			result.put("success", Boolean.TRUE);
		}else {
			result.put("success", Boolean.FALSE);
		}

		return result;
	}
	
	@RequestMapping("/getDatas")
	public Map<String, Object> getDatas(HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		result = sysService.getSysDatas();

		if(result!=null&&result.size()>0) {
			result.put("success", Boolean.TRUE);
		}else {
			result.put("success", Boolean.FALSE);
		}

		return result;
	}

}
