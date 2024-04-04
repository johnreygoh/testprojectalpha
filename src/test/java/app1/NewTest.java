package app1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NewTest {
	
	String pagetitle;
	String pageurl;
	SoftAssert softassert = new SoftAssert();
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\chromedriver-win64\\chromedriver.exe");
	}
	
	@Test
	public void test1() {

		WebDriver driver = new ChromeDriver();
		//driver usage
		driver.manage().window().maximize();
		driver.get("https://psa.gov.ph/");
		pagetitle = driver.getTitle();
		softassert.assertEquals(pagetitle, "Home | Philippine Statistics Authority | Republic of the Philippines","error title");
		pageurl = driver.getCurrentUrl();
		softassert.assertEquals(pageurl, "https://psa.gov.ph/");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//click Field Office link
		WebElement fieldofficelink = driver.findElement(By.xpath("//*[@id=\"block-mainnavigation-2\"]/div/div/ul/li[10]/a"));
		fieldofficelink.click();
		pagetitle = driver.getTitle();
		softassert.assertEquals(pagetitle, "Field Offices Directory | Philippine Statistics Authority | Republic of the Philippines","wrong title");
		pageurl = driver.getCurrentUrl();
		softassert.assertEquals(pageurl, "https://psa.gov.ph/field-offices");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		softassert.assertAll();
		driver.quit(); //exits session
		
	}

	
}
