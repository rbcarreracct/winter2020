package seleniumConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WindowHandle {

	WebDriver driver;

	@Before
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.yahoo.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void search() {

		WebElement SEARCH_BAR = driver.findElement(By.xpath("//input[@id='ybar-sbq']"));

		SEARCH_BAR.sendKeys("xpath");

		WebElement SEARCH_BUTTON = driver.findElement(By.xpath("//input[@id='ybar-search']"));

		SEARCH_BUTTON.click();

		driver.findElement(By.xpath("//a[contains(text(), 'XPath Tutorial - W3Schools')]")).click();

		String handle = driver.getWindowHandle();

		System.out.println(handle);

	}

}
