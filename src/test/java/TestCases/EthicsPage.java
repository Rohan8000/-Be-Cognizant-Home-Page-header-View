package TestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PageData.EthicsCompliancePage;

public class EthicsPage extends BaseClass
{
	@Test(dependsOnMethods="Ethics",priority=3)
	public void Navigate()
	{
		
		EthicsCompliancePage ec = new EthicsCompliancePage(driver);
		
		//Navigate to Ethics & Compliance page
        ec.navigateforward();
        
	}
	
	@Test(dependsOnMethods="Ethics",priority=4)
	public void resources()
	{
		
		EthicsCompliancePage ec = new EthicsCompliancePage(driver);
		
		//Validate Resources/Link in Ethics & Compliance page and print all information
		List<WebElement> actualResult = ec.getResources();
    	for (WebElement resource : actualResult) 
          {
    		Assert.assertTrue(resource.isDisplayed());
            System.out.println(resource.getText());
          }
		
	}
	
	@Test(dependsOnMethods="Ethics",priority=5)
	public void pageInformation()
	{
		
		//Get Page Title 
		String pageTitle = driver.getTitle();
	    System.out.println("Page Title = " + pageTitle);
	    
	    //Get Page URL
	    String currentURL = driver.getCurrentUrl();
	    System.out.println("Current URL = " + currentURL);
		
	}
}
