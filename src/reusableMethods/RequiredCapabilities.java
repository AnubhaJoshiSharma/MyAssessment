package reusableMethods;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RequiredCapabilities {
	static WebDriver driver;
	static String url = "http://ec2-52-91-203-95.compute-1.amazonaws.com:8080/admin/dashboard";
	public static WebDriver setCapabilities(String browsername) {
		File file = new File("src");	
		if (browsername.equals("InternetExplorer")) {
		File ieserver = new File(file, "IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", ieserver.getAbsolutePath());
			DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
			dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(dc);
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		}
		else if (browsername.equals("Chrome")) {
			File chromeserver = new File(file, "chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", chromeserver.getAbsolutePath());
			DesiredCapabilities dc = DesiredCapabilities.chrome();
			driver = new ChromeDriver(dc);
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		}
		else {
			System.out.println("Please enter valid browser name");
		}
		return driver;
	}

}
