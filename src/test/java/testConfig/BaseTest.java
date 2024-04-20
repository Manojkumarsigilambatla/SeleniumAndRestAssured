package testConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import paje_Objects.Login_Page_Screen;

public class BaseTest {

	public WebDriver driver;
	public Properties properties;
	public Login_Page_Screen login_screen;
	public  void launch_The_Browser() throws IOException
	{
		
		FileInputStream file_Input_Stream = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\ConfigFiles\\testDetails.properties");
		properties = new Properties();
		properties.load(file_Input_Stream);
		
		String browserName = properties.getProperty("browser");
		System.out.println("browser name from the properties file is "+browserName);
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new  ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new  FirefoxDriver();
		}
		else
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
	}
	@BeforeMethod
	public Login_Page_Screen launch_The_WebSite() throws IOException
	{
		launch_The_Browser();
	    driver.get(properties.getProperty("url"));
	    login_screen = new Login_Page_Screen(driver);
	    return login_screen;
	}
	
	@AfterMethod
	public void quitTheDriver()
	{
		driver.quit();
	}
	
	
}
