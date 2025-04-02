package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {

	 static WebDriver driver;
     static Properties p;
  	     
public static WebDriver initilizeBrowser() throws IOException
{
	p = getProperties();
	String executionEnv = p.getProperty("execution_env");
    String browser = p.getProperty("browser").toLowerCase();
	
	if(executionEnv.equalsIgnoreCase("local"))
		{
			switch(browser.toLowerCase()) 
			{
			case "chrome":
				ChromeOptions options = new ChromeOptions();
		        options.addArguments("--disable-notifications");
		        driver=new ChromeDriver(options);
		        break;
		    case "edge":
		    	//WebDriverManager.edgedriver().setup(); //webmanager installs the compatible version of browser with driver and runs
		    	driver=new EdgeDriver();
		        break;
		    case "firefox":
		    	//WebDriverManager.firefoxdriver().setup();
		    	driver=new FirefoxDriver();
		        break;
		    default:
		        System.out.println("No matching browser");
		        driver=null;
			}
		}
	 driver.manage().deleteAllCookies(); 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	 
	 return driver;
	 
}

public static WebDriver getDriver() {
		return driver;
	}

public static Properties getProperties() throws IOException
{		 
    FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
   	p=new Properties();
	p.load(file);
	return p;
}
}
