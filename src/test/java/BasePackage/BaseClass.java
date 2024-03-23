package BasePackage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.google.common.io.Files;


public class BaseClass 
{
	public static WebDriver driver;
	public WebDriverWait myWait;
	public JavascriptExecutor js;
	
	@BeforeTest
	@Parameters({"Browser"})
	public void create(String br) throws Exception
	{
		//Choosing driver
		if(br.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid Browser....");
			return;
		}
		
		//To Maximize window
		driver.manage().window().maximize();
		
		//Explicit wait
		myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//To open the Url
		driver.get("https://be.cognizant.com");
	}
	
	@AfterTest
	public void close()
	{
		
		//Close Browser
		driver.quit();
	
	}
	
	public String captureScreen(String tname) throws IOException 
	{
		 
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\ScreenShot\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		Files.copy(sourceFile, targetFile);
		return targetFilePath;
 
	}
}
