import java.util.Collection;
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
		   
	       AutomationDriver Ad=new AutomationDriver();
	       //Ad.exerciseOne(driver);
	      // Ad.exerciseTwo(driver);
	      // Ad.exerciseThree(driver);
	       //  Ad.exerciseFour(driver);
	        // Ad.exerciseFive(driver);
	         //Ad.exerciseSix(driver);
	      // Ad.exerciseSeven(driver);
	       Ad.exerciseEight(driver);
	       Ad.exerciseNine(driver);
	}
	
	public void exerciseOne(WebDriver driver) {
	       
		  // Code to Select the “Radio1” radio button and verify it’s selected.  
	       driver.findElement(By.cssSelector("input[value='radio1']")).click();
	       Assert.assertTrue(driver.findElement(By.cssSelector("input[value='radio1']")).isSelected());
	      
		  // Code to Select the “Radio2” radio button and verify it’s selected.  
	       driver.findElement(By.cssSelector("input[value='radio2']")).click();
	       Assert.assertTrue(driver.findElement(By.cssSelector("input[value='radio2']")).isSelected());

		  // Code to Select the “Radio3” radio button and verify it’s selected.  
	       driver.findElement(By.cssSelector("input[value='radio3']")).click();
	       Assert.assertTrue(driver.findElement(By.cssSelector("input[value='radio3']")).isSelected());
	       driver.close();
	}
	
	public void exerciseTwo(WebDriver driver) throws InterruptedException {
		
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
	
	public void exerciseThree(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.id("dropdown-class-example")).click();
		driver.findElement(By.xpath("//option[@value='option1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value='option2']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value='option3']")).click();
		Thread.sleep(2000);

	}

	public void exerciseFour(WebDriver driver) throws InterruptedException {
	
		driver.findElement(By.name("checkBoxOption1")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption1")).click();
		driver.findElement(By.name("checkBoxOption2")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption2")).click();
		driver.findElement(By.name("checkBoxOption3")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("checkBoxOption3")).click();
		AutomationDriver.exerciseFourPointOne(driver);
		AutomationDriver.exerciseFourPointTwo(driver);
		
	}
	
	public static void exerciseFourPointOne(WebDriver driver) throws InterruptedException {
	
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
	
	public void exerciseFive(WebDriver driver) throws InterruptedException {

		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get("http://www.qaclickacademy.com/practice.php");
		 driver.findElement(By.cssSelector("button.btn-style.class1")).click();
		 
		 Set<String> Windows = driver.getWindowHandles();
		 Iterator<String> a = Windows.iterator();
		 String parentid = a.next();
		 Thread.sleep(7000);
		 driver.switchTo().window(parentid);
		 }
	
	public void exerciseSix(WebDriver driver) throws InterruptedException {

		 driver.findElement(By.cssSelector("a.btn-style.class1.class2")).click();
		 Thread.sleep(2000);
		 
		 Set<String> window = driver.getWindowHandles();
		 Iterator<String> b = window.iterator();
		 String parent = b.next();
		 String daughter = b.next();
		 Thread.sleep(2000);
		 driver.switchTo().window(daughter);
		 driver.close();
		 driver.switchTo().window(parent);
		 
		}


	 public void exerciseSeven(WebDriver driver) throws InterruptedException {
		 
		driver.findElement(By.cssSelector("input#name")).sendKeys("Sarvesh");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#alertbtn")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		 }
	 
	 public void exerciseEight(WebDriver driver) throws InterruptedException {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 driver.manage().window().maximize();
		 js.executeScript("window.scrollBy(0,600)");
		 Thread.sleep(2000);
	//	 WebElement table = driver.findElement(By.xpath("//*[@id='product']"));
	//	 System.out.println(table.findElements(By.tagName("tr")).size());
	//	 System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());



		 
	
		 }
	 
	 private static void exerciseNine(WebDriver driver) throws InterruptedException {
		 Actions a = new Actions(driver);
		 Thread.sleep(3000);
		 a.moveToElement(driver.findElement(By.xpath("//button[@id='mousehover']"))).click().build().perform();
		 Thread.sleep(5000);
		 a.moveToElement(driver.findElement(By.cssSelector("a[href='#top']"))).click().build().perform();

		  }
	 
	 
}
