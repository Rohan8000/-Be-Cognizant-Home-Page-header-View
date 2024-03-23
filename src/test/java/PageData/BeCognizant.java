package PageData;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BeCognizant extends BasePage
{

	public BeCognizant(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='_8ZYZKvxC8bvw1xgQGSkvvA==']")
	public WebElement userInfo;
	@FindBy(xpath="//div[@id='mectrl_currentAccount_secondary']")
	public WebElement email;
	@FindBy(xpath="//div[@id='mectrl_currentAccount_primary']")
	public WebElement name;
	@FindBy(xpath="//span[@data-automationid='splitbuttonprimary']/span/span")
	public List<WebElement> header;
	@FindBy(xpath="//li[@role='presentation']//span")
	public List<WebElement> subHeader;

	
	public void clickLogo()
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", userInfo);
	}
	
	public WebElement getEmail()
	{
		return email;
	}
	
	public WebElement getName()
	{
		return name;
	}
	
	public List<WebElement> getHeader()
	{
		return header;
	}
	
	public List<WebElement> getSubHeader()
	{
		return subHeader;
	}
}
