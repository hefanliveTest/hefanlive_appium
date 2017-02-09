package com.appium.hefanlive;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class TestCase {
	private static AndroidDriver driver;

	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Exception {
		// set up appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "apps");
		File app = new File(appDir, "hefanlive.apk");
		
		capabilities.setCapability("noReset", true);//不重置app状态
		capabilities.setCapability("autoLaunch", false);//不每次启动app
		//capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("appPackage", "com.starunion.hefantv");
		capabilities.setCapability("appActivity", "com.sagacreate.boxlunch.activity.SplashActivity");
		//capabilities.setCapability("waitActivity", ".GuideActivity");
		capabilities.setCapability("unicodeKeyboard", "True");
		capabilities.setCapability("resetKeyboard", "True");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
		//driver = new AndroidDriver(new URL("http://192.168.1.200:4723/wd/hub"),
		
				capabilities);
		driver.launchApp();
	}

	@AfterTest
	// @AfterTest(alwaysRun=true)
	public void tearDown() throws Exception {
		System.out.println("end!!!!");
		driver.removeApp("io.appium.android.ime");
		// driver.quit();
	}

	@Test(groups={"all"})
	public void start() {
		System.out.println("start!!!!");
		for (int j = 1; j <= 3; j++) {
		testcase();
		}
	}
	
	
	
	public void testcase() {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
/*	
		WebElement e = wait.until(new ExpectedCondition<WebElement>() {
			// @Override
			
			
			public WebElement apply(WebDriver d) {
				//return d.findElement(By.className("android.widget.ImageView"));
				return d.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
			}
			

		});
*/
		// WebElement nokjfs = driver.findElement(By.id("com.hefanlive.news:id/cancel"));
		// nokjfs.click();
		AppLibs a = new AppLibs();
		a.sleepThread("2000");

		// Xlsfile xlsfile=new Xlsfile();
		/*
		 * for(int i=1;i<=10;i++) { //Xlsfile.readxls("test",4,
		 * i).getType()!=CellType.EMPTY; System.out.println("for i="+i);
		 * System.out.println("isempty is "+Xlsfile.isempty("test",4, i));
		 * 
		 * if(Xlsfile.isempty("test",4, i)) {break;}
		 * System.out.println(Xlsfile.readxls("test",4,
		 * i)+"  "+Xlsfile.readxls("test",5, i)+"  "+Xlsfile.readxls("test",6,
		 * i)+"  "+Xlsfile.readxls("test",7, i)); WebElement
		 * elements=a.findElement(driver,Xlsfile.readxls("test",4,
		 * i),Xlsfile.readxls("test",5, i));
		 * a.execute(elements,Xlsfile.readxls("test",6,
		 * i),Xlsfile.readxls("test",7, i));
		 * Xlsfile.writexls("test",8,i,"success"); }
		 * 
		 * 
		 * String
		 * lastname=a.checktext(driver,"id","com.yougou:id/product_name","asics"
		 * ); System.out.println("Last Name="+lastname);
		 */
		
		for (int i = 1; i <= 30; i++) {
			
			if(testcase15(i,a)==0)
			{break;}

			/*
			System.out.println("for start i=" + i);
			if (Xlsfile.isempty("hefanlive_testcase", 1, i)) {
				i=31;
				return;
			}
			WebElement elementname = a
					.element(driver, Xlsfile.search(Xlsfile.readxls(
							"hefanlive_testcase", 1, i)));
			String execute = Xlsfile.readxls("hefanlive_testcase", 2, i);
			String value = Xlsfile.readxls("hefanlive_testcase", 3, i);
			a.execute(driver, elementname, execute, value);
			*/
			//Xlsfile.writexls("hefanlive_testcase", 6, i,"1");
			
		}

		/*
		WebElement el = driver.findElement(By.id("com.hefanlive.news:id/iv_logo"));
        el.click();
        */
		driver.pinch(200, 500);

	}
	
	@Test(groups={"step"})
	public int testcase15(int i,AppLibs a){
		System.out.println("for start i=" + i);
		if (Xlsfile.isempty("hefanlive_testcase", 1, i)) {
			return 0;
		}
		System.out.println("for start i2=" + i);
		WebElement elementname = a
				.element(driver, Xlsfile.search(Xlsfile.readxls(
						"hefanlive_testcase", 1, i)));
		String execute = Xlsfile.readxls("hefanlive_testcase", 2, i);
		String value = Xlsfile.readxls("hefanlive_testcase", 3, i);
		a.execute(driver, elementname, execute, value);
		return 1;
	}
	// public static void main(String[] args) {

	// a.findElement2();

	// }
	

}
