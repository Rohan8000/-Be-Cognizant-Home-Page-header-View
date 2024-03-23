package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import BasePackage.BaseClass;
import PageData.EthicsCompliancePage;

public class EthicsCompliance extends BaseClass
{
	
	@Test(priority=2)
	public void Ethics()
	{
		EthicsCompliancePage ec = new EthicsCompliancePage(driver);
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Validate Ethics & Compliance is visible in Corporate Function ̶̶> Legal & Corporate affairs header		
        driver.findElement(By.xpath("(//span[@data-automationid='splitbuttonprimary'])[6]/span/span")).click();
        
        
        WebElement legal = driver.findElement(By.xpath("(//li[@role='presentation'])[3]//span"));
        Actions ac = new Actions(driver);
        ac.moveToElement(legal).perform();
        
        String actualEthics = ec.getEthicsCompliance();
        String expectedEthics = "Ethics and Compliance";
        
        
	    //If Element is Found
        Assert.assertEquals(actualEthics,expectedEthics);
        
        System.out.println("-------------------------------");
         
    }
}
