package Pack1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class AmazonDrop

{

//		format , ctrl+shift+F
	// import , ctrl+shift+0
	WebDriver driver;

	@BeforeMethod
	public void launchapplication() throws IOException

	{

		File f1 = new File("C:\\Users\\Jemal\\Jamel_selenium_project\\Selenium_setup\\src\\app.properties");
		FileReader ff = new FileReader(f1);
		Properties pp = new Properties();////////// cell sheet , xsswoehssg
		pp.load(ff);///
		System.setProperty("webdriver.chrome.driver", pp.getProperty("driverpath")); // Setproperty have two attributes
																						// propertyName and Value.
																						// sysytem.setProperty("name";"value");
		driver = new ChromeDriver();
		driver.navigate().to(pp.getProperty("URL"));// QA , UAT , Productio ,need to
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Integer.parseInt(pp.getProperty("waittime")), TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void dropdownvalidation() {
		WebElement drop = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

		Select ss = new Select(drop); // predefined class ,, accepts webelemnt as inut
		// ss.selectByIndex(11);
		// ss.selectByVisibleText("Baby");
		String input = "Baby";
		ss.selectByValue("search-alias=baby-products");

		WebElement selected = ss.getFirstSelectedOption();
		String actual = selected.getText();// Baby
		Assert.assertEquals(actual.trim(), input.trim(),
				"both are not equal meaning selected dropdown is not dispayed");// pass //fail
		// Assert.assertEquals(actual.trim(), input.trim());
		System.out.println(" line number 62 after assertion ");
		System.out.println(" last line ");
		Assert.assertEquals("Jamel", "Jamel"); //

		///
	}//

	@Test(priority = 2, enabled = false)
	public void searchsomething_dontrun() {
		WebElement searchinputbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

		if (searchinputbox.isEnabled()) {
			searchinputbox.sendKeys("mobile");

			// searchinputbox.clear();
		}
		WebElement SearchBox = driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));

		if (SearchBox.isDisplayed()) {
			SearchBox.click();
			// we will getting the results
			// we need to pass the testcases
		} else {
			Assert.assertTrue(false, "searcbox is not displayed");
		}

	}

	@Test(priority = 3, groups = { "search" }, dependsOnMethods = { "dropdownvalidation" })
	public void searchsomething_3() {
		WebElement searchinputbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

		if (searchinputbox.isEnabled()) {
			searchinputbox.sendKeys("mobile");

			// searchinputbox.clear();
		}
		WebElement SearchBox = driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));

		if (SearchBox.isDisplayed()) {
			SearchBox.click();
			// we will getting the results
			// we need to pass the testcases
		} else {
			Assert.assertTrue(false, "searcbox is not displayed");
		}

	}

	@Test(priority = 3, groups = { "search" })
	public void searchsomething_order() {
		WebElement searchinputbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

		if (searchinputbox.isEnabled()) {
			searchinputbox.sendKeys("mobile");

			// searchinputbox.clear();
		}
		WebElement SearchBox = driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));

		if (SearchBox.isDisplayed()) {
			SearchBox.click();
			// we will getting the results
			// we need to pass the testcases
		} else {
			Assert.assertTrue(false, "searcbox is not displayed");
		}

	}
	
	//new testcase here 
	@Test(priority = 12, groups = { "orders" })
	public void Validatecancelorder()
	{
		
		System.out.println(" order cancelltion code here ");
		
		//weblement 
		
		// webelemnt 
		// assertion 
	}

	@AfterMethod
	public void closebrowser()

	{

		driver.close();

	}

}
