package trainingprogram;

import java.awt.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Makemytrip {

	

		
		public static void main(String[] args) throws InterruptedException {
			
			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver.manage().deleteAllCookies();
			
			driver.navigate().to("https://www.makemytrip.com/");
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElementByXPath("//div[contains(@class,'loginModal displayBlock')]").click();
			
			driver.findElementByXPath("//span[text()='Hotels']").click();
			driver.findElementByXPath("//span[@data-cy='hotelCityLabel']").click();
			driver.findElementByXPath("//div[@role='combobox']//input[1]").sendKeys("goa",Keys.DOWN,Keys.ENTER);
			driver.findElementById("checkin").click();
			driver.findElementByXPath("(//div[text()='15'])[2]").click();
			driver.findElementById("checkout").click();
			driver.findElementByXPath("(//div[text()='22'])[2]").click();
			
			driver.findElementById("guest").click();
			driver.findElementByXPath("//li[@data-cy='adults-3']").click();
			driver.findElementByXPath("//li[@data-cy='children-1']").click();
			
			WebElement childage = driver.findElementByTagName("select");
			
			Select agedropdown = new Select(childage);
			agedropdown.selectByVisibleText("11");
			driver.findElementByXPath("(//button[@type='button'])[2]").click();
			driver.findElementById("hsw_search_button").click();
			
			driver.manage().deleteAllCookies();
			
			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);
			driver.get(currentUrl);
			
			//other method to avoid access denied error
			
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();
			
			
			
		
			
			driver.findElementByClassName("mapCont").click();
			//xpath = //span[@class='mapClose']
			driver.findElementByClassName("mapClose").click();
			
			/*//anothe method we can use double click
			Actions click = new Actions(driver);
			Thread.sleep(3000);
			click.moveToElement(room).doubleClick().perform();*/
			
		
			driver.findElementByXPath("//span[text()='Karol bagh']").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//label[text()='3 & above (Good)']").click();
			
			driver.findElementByXPath("//span[text()='Popularity']").click();
			driver.findElementByXPath("//li[contains(text(),'Price - Low to High')]").click();
			Thread.sleep(3000);
			
		driver.findElementByXPath("//span[text()='The Gold Inn, Near Karol Bagh Metro']").click();
		
				
	
		
		
		
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(windowHandles);
		
		// Getting the second window
		String secondWindow = list.get(1);
		
		// moving the control to second Window
		driver.switchTo().window(secondWindow);
		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		
		Thread.sleep(3000);
		
		driver.findElementByXPath("//span[@class='fcTooltip__outer']//a[1]").click();
		WebElement hotelname = driver.findElementByXPath("//p[text()='The Gold Inn, Near Karol Bagh Metro']");
		
		System.out.println(hotelname.getText());
		String text = driver.findElementById("revpg_total_payable_amt").getText();
		System.out.println(text);
		
		
		
		
		
		
			
			
		}

	}

