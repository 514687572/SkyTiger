package com.skytiger.net.service;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.List;

import javax.annotation.Resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import com.skytiger.net.entity.Dictionary;

@Service
public class BusinessService {
	private WebDriver driver;
	@Resource
	private SysService sysService;
	String baseUrl = "http://sso.tyfo.com/authcode?appkey=65734592&redirecturl=http%3A%2F%2Fportal.tyfo.com%2Ftyfo%2Fuser%2FgoTyfoHome";
	public void CollectGoods(String postNum, String password, String name,String orderNum) throws Exception {
		System.setProperty("sun.net.client.defaultReadTimeout", "95000");
		List<Dictionary> dicList=sysService.getDictoryByType("chrome");
		
		for(Dictionary dic:dicList) {
			if("fx_path".equals(dic.getDicKey())) {
				System.setProperty("webdriver.chrome.bin",dic.getDicValue());
			}else {
				System.setProperty("webdriver.chrome.driver",dic.getDicValue());
			}
		}
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.id("loginName")).sendKeys(name);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("sureButton")).click();
		driver.navigate().to("http://portal.tyfo.com/tyfo/trade/toSellerOrders?module=order&action=orderlist&orderStatus=3");
		Thread.sleep(3000);
		String s1 = driver.findElement(By.xpath("//*[@id=\"order3\"]/span[2]")).getText();
		if (s1.equals("(0)")) {
			System.out.println("没有要发货的订单");
			driver.close();
		} else {
			Thread.sleep(3000);
			while (!ElementExist(By.id("orderCode"))) {

			}
			driver.findElement(By.id("orderCode")).sendKeys(orderNum);
			driver.findElement(By.xpath("/html/body/div[3]/div[5]/div[3]/div/div[3]/div/div/input[2]")).click();
			driver.findElement(By.xpath("//*[@id=\"cjTime3\"]/div/ul/li[3]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"btnSearch\"]/span")).click();
			int i=0;
			while(!ElementExist(By.xpath("//*[contains(@id,'logicticsno')]"))) {
				i++;
				if(i==10) {
					break;
				}
			}
			
			if(i==10) {
				driver.quit();
			}
			try {
				if(ElementExist(By.xpath("//*[contains(@id,'logicticsno')]")) == true) {
					driver.findElement(By.xpath("//*[contains(@id,'logicticsno')]")).clear();
					driver.findElement(By.xpath("//*[contains(@id,'logicticsno')]")).sendKeys(postNum.replaceAll(" ", "").replaceAll(" ", ""));
					driver.findElement(By.xpath("//*[@id=\"valueUl\"]/li[1]/div[2]/div[2]/div/div[5]/div/a[1]")).click();
					/*Thread.sleep(3000);
					if(ElementExist(By.xpath("//*[contains(@id,'layui-layer-iframe')]")) == true) {
						WebElement frame = driver.findElement(By.xpath("//*[contains(@id,'layui-layer-iframe')]"));
						driver.switchTo().frame(frame);
						driver.findElement(By.xpath("/html/body/form/div/div/div/div/input")).click();
						driver.findElement(By.xpath("/html/body/form/div/div/div/dl/dd[2]")).click();
						driver.switchTo().defaultContent();
						try {
							driver.findElement(By.xpath("//*[@id=\"layui-layer100001\"]/div[3]/a[1]")).click();
						} catch (Exception e) {
							driver.findElement(By.xpath("//*[@id=\"layui-layer1\"]/div[3]/a[1]")).click();
						}
						System.out.println("发货成功");
						driver.quit();
					}else {
						driver.quit();
					}*/
					
				}else {
					driver.quit();
					System.out.println("该订单未找到对应发货信息");
				}
			} catch (Exception e) {
				driver.quit();
			}
			}
			
		
		if (driver != null) {
			try {
				driver.quit();
			} catch (Exception e) {

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
	
	   /**
     * 把文本设置到剪贴板（复制）
     */
    public static void setClipboardString(String text) {
        // 获取系统剪贴板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 封装文本内容
        Transferable trans = new StringSelection(text);
        // 把文本内容设置到系统剪贴板
        clipboard.setContents(trans, null);
    }

    /**
     * 从剪贴板中获取文本（粘贴）
     */
    public static String getClipboardString() {
        // 获取系统剪贴板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        // 获取剪贴板中的内容
        Transferable trans = clipboard.getContents(null);

        if (trans != null) {
            // 判断剪贴板中的内容是否支持文本
            if (trans.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                try {
                    // 获取剪贴板中的文本内容
                    String text = (String) trans.getTransferData(DataFlavor.stringFlavor);
                    return text;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

}
