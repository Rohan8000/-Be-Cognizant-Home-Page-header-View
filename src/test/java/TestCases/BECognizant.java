package TestCases;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import BasePackage.BaseClass;
import PageData.BeCognizant;


public class BECognizant extends BaseClass
{
	@Test(priority=0)
	public void userInformation() throws InterruptedException
	{
		
		BeCognizant be = new BeCognizant(driver);
		
		//Get User Information
		Thread.sleep(5000);
		WebElement e=myWait.until(ExpectedConditions.visibilityOf(be.userInfo));
		Thread.sleep(3000);
		e.click();
		e=myWait.until(ExpectedConditions.visibilityOf(be.email));
		String email = e.getText();
		WebElement name= be.getName();
		System.out.println(email+":"+name.getText());
		
		System.out.println("-------------------------------");
        
	}
	
	@Test(priority=1)
	public void header()
	{
		
		BeCognizant be = new BeCognizant(driver);
		
		//Get all headers and subheaders
		List<WebElement> actualResult1 = be.getHeader();
        for (WebElement header : actualResult1) 
        {
            System.out.println(header.getText());
            if(!(header.getText().equals("be.cognizant") || header.getText().equals("Associate Directory") || header.getText().equals("App Directory")))
            {
            	header.click();
            	List<WebElement> actualResult2 = be.getHeader();
	        	for (WebElement subheader : actualResult2) 
	              {
	                  System.out.println(subheader.getText());
	              }
	        	header.click();
            }
        }
        
        System.out.println("-------------------------------");
        
	}
}
