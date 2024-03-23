package PageData;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EthicsCompliancePage extends BasePage
{
	public EthicsCompliancePage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[@name='Ethics and Compliance']/div/span")
	public WebElement ethics;
	@FindBy(xpath="//div[@class='ms-List-cell']//div[@data-automation-id='quick-links-item-title']")
	public List<WebElement> resource;
	
	
	public String getEthicsCompliance()
	{
		return ethics.getText();
	}
	
	public void navigateforward()
	{
		ethics.click();
	}
	
	public List<WebElement> getResources()
	{
		return resource;
	}
	
}
