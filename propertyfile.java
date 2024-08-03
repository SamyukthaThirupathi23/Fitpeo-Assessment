package qsp;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class propertyfile {
	public static void main(String[] args) throws InterruptedException  {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Navigate to the FitPeo Homepage:
		driver.get("https://www.fitpeo.com/");
		Thread.sleep(4000);
		//Navigate to the Revenue Calculator Page:
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     WebElement revenueCalculatorLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Revenue Calculator")));
	     revenueCalculatorLink.click();
	     WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	     Actions actions = new Actions(driver);
	     Thread.sleep(4000);
	     //Scroll Down to the Slider section:
	     actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	     Thread.sleep(4000);
	     //Adjust the Slider
	     WebElement slider =  driver.findElement(By.xpath("//*/span[1]/span[3]"));
	     actions.dragAndDropBy(slider,93,93 ).perform();
	     for (int i = 0; i < 3; i++) { 
	         actions.sendKeys(Keys.ARROW_UP).perform();
	          }
	     Thread.sleep(4000);
	     //Update the Text Field
	     for (int i = 820; i >560 ; i--) { 
	         actions.sendKeys(Keys.ARROW_DOWN).perform();
	          } 
	     Thread.sleep(4000);
	     WebElement sliderValue =  driver.findElement(By.xpath("//input[@type = 'number']"));
	     String sliderValue1 = sliderValue.getAttribute("value");
	     Thread.sleep(2000); 
	     //Validate Slider Value
	     System.out.println("Slider Value: " + sliderValue1);
	     String expectedValue = "560"; 
	     if (sliderValue1.equals(expectedValue)) {
	         System.out.println("Validation passed: Slider value is correct.");
	     } else {
	         System.out.println("Validation failed: Expected " + expectedValue + " but got " + sliderValue);
	     }
	     JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("window.scrollBy(100,350)", "");
	     //Select CPT Codes
	     driver.findElement(By.xpath("//*/div[1]/label/span[1]/input")).click();
	     driver.findElement(By.xpath("//*/div[2]/label/span[1]/input")).click();
	     driver.findElement(By.xpath("//*/div[3]/label/span[1]/input")).click();
	     js.executeScript("window.scrollBy(350,500)", "");
	     driver.findElement(By.xpath("//*/div[8]/label/span[1]/input")).click();
	     js.executeScript("window.scrollTo(100,350)", "");
	     //Validate Total Recurring Reimbursement:
	     WebElement slider1 =  driver.findElement(By.xpath("//*/span[1]/span[3]"));
	     actions.dragAndDropBy(slider1,39,39 ).perform();
	     for (int i = 0; i < 3; i++) { 
	         actions.sendKeys(Keys.ARROW_UP).perform();
	          }
	     //Verify that the header displaying Total Recurring Reimbursement for all Patients Per Month: shows the value $110700.	
	     WebElement totalReimbursement  = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/div[3]/p[2]"));
	     String totalReimbursements = totalReimbursement.getText();
	     System.out.println("Total Recurring Reimbursement: " + totalReimbursements);
	     String expectedValue1 = "$110700"; 
	     if (totalReimbursements.equals(expectedValue1)) {
	         System.out.println("Validation passed: Total Recurring Reimbursement is correct.");
	     } else {
	         System.out.println("Validation failed: Expected " + expectedValue1 + " but got " + totalReimbursements);
	     }

	    
	     
	   


		
		

	}
	

}
