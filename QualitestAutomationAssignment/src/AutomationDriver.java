import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AutomationDriver {

	public static void main(String[] args) throws InterruptedException {
		
		   System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
	       WebDriver driver=new ChromeDriver();
		   driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		   
	       AutomationDriver.exerciseOne(driver);
	       AutomationDriver.exerciseTwo(driver);
	       AutomationDriver.exerciseThree(driver);
	       AutomationDriver.exerciseFour(driver);
	       AutomationDriver.exerciseFive(driver);
	       AutomationDriver.exerciseSix(driver);
	       AutomationDriver.exerciseSeven(driver);
	       AutomationDriver.exerciseEight(driver);
	       AutomationDriver.exerciseNine(driver);
	}
	
	public static void exerciseOne(WebDriver driver) {
	       
		  // Code to Select the “Radio1” radio button and verify it’s selected.  
	       driver.findElement(By.cssSelector("input[value='radio1']")).click();
	       Assert.assertTrue(driver.findElement(By.cssSelector("input[value='radio1']")).isSelected());
	      
		  // Code to Select the “Radio2” radio button and verify it’s selected.  
	       driver.findElement(By.cssSelector("input[value='radio2']")).click();
	       Assert.assertTrue(driver.findElement(By.cssSelector("input[value='radio2']")).isSelected());

		  // Code to Select the “Radio3” radio button and verify it’s selected.  
	       driver.findElement(By.cssSelector("input[value='radio3']")).click();
	       Assert.assertTrue(driver.findElement(By.cssSelector("input[value='radio3']")).isSelected());
	     //  driver.close();
	}
	
	public static void exerciseTwo(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.id("autocomplete")).sendKeys("United states");
		Thread.sleep(3000);
		List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item']"));

		for(WebElement option :options)
		{
			if(option.getText().equalsIgnoreCase("United States Minor Outlying Islands"))
			{
			option.click();
			break;
			}
		}
	}
	
	
	public static void exerciseThree(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.id("dropdown-class-example")).click();
		driver.findElement(By.xpath("//option[@value='option1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value='option2']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value='option3']")).click();
		Thread.sleep(2000);

	}

	public static void exerciseFour(WebDriver driver) throws InterruptedException {
	
		
		driver.findElement(By.name("checkBoxOption1")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption1")).click();
		driver.findElement(By.name("checkBoxOption2")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption2")).click();
		driver.findElement(By.name("checkBoxOption3")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption3")).click();
		
		// Calling function exerciseFourPointOne
		AutomationDriver.exerciseFourPointOne(driver);
		
		// Calling function exerciseFourPointTwo
		AutomationDriver.exerciseFourPointTwo(driver);
		
	}
	
	public static void exerciseFourPointOne(WebDriver driver) throws InterruptedException {
	
		// Clicking on all check boxes and verifying them
		driver.findElement(By.name("checkBoxOption1")).click();
		driver.findElement(By.name("checkBoxOption2")).click();
		driver.findElement(By.name("checkBoxOption3")).click();
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption1")).isSelected());
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption2")).isSelected());
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption3")).isSelected());
	}
	
	public static void exerciseFourPointTwo(WebDriver driver) throws InterruptedException {
	
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption1")).isSelected());
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption2")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption2")).isSelected());
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption3")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption3")).isSelected());
		
	}
	
	public static void exerciseFive(WebDriver driver) throws InterruptedException {

		// Implicit wait
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
		 // Maximizing window
		 driver.manage().window().maximize();
		 driver.get("http://www.qaclickacademy.com/practice.php");
		 driver.findElement(By.cssSelector("button.btn-style.class1")).click();
		 
		 Set<String> Windows = driver.getWindowHandles();
		 Iterator<String> a = Windows.iterator();
		 String parentid = a.next();
		 Thread.sleep(7000);
		 
		 //Switching to parent id
		 driver.switchTo().window(parentid);
		 }
	
	public static void exerciseSix(WebDriver driver) throws InterruptedException {

		 driver.findElement(By.cssSelector("a.btn-style.class1.class2")).click();
		 Thread.sleep(2000);
		 
		 Set<String> window = driver.getWindowHandles();
		 Iterator<String> b = window.iterator();
		 String parent = b.next();
		 String daughter = b.next();
		 Thread.sleep(2000);
		 
		 //Switching to daughter window 
		 driver.switchTo().window(daughter);
		 
		 // Closing daughter window
		 driver.close();
		 
		 //Switching back to parent window
		 driver.switchTo().window(parent);
		 
		}


	 public static void exerciseSeven(WebDriver driver) throws InterruptedException {
		 
		 //Entering My name in the input field
		driver.findElement(By.cssSelector("input#name")).sendKeys("Sarvesh");
		Thread.sleep(5000);
		
		// Initiating alert window
		driver.findElement(By.cssSelector("input#alertbtn")).click();
		Thread.sleep(5000);
		
		//Accepting the alert 
		driver.switchTo().alert().accept();

		 }
	 
	 
	 public static void exerciseEight(WebDriver driver) throws InterruptedException {
		 
		 //Type casting driver to JavascriptExecutor
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 driver.manage().window().maximize();
		 js.executeScript("window.scrollBy(0,600)");
		 Thread.sleep(2000);
	    
		 js.executeScript("document.querySelector('.tableFixHead').scrollBy(0,5000)");
		 List<WebElement> tab= driver.findElements(By.xpath("//*[@class='table-display']"));
		 for(int i=0;i<tab.size();i++) 
		 System.out.println(tab.get(i).getText());


		 
	
		 }
	 
	 private static void exerciseNine(WebDriver driver) throws InterruptedException {
		 
		 // Using Actions to perform Mouse Hover
		 Actions a = new Actions(driver);

		 // Scrolling down where Mouse Hover button is present
		 a.moveToElement(driver.findElement(By.xpath("//button[@id='mousehover']"))).click().build().perform();
		 Thread.sleep(5000);
		 
		 // Clicking Top to Navigate to the top of the page
		 a.moveToElement(driver.findElement(By.linkText("Top"))).click().build().perform();

		  }
	 
	 
}
