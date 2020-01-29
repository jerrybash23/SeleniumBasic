import java.util.concurrent.TimeUnit;

import javax.sql.rowset.WebRowSet;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements AutoConstant
{
static
{
	System.setProperty(chrome_key, chrome_value);
	System.setProperty(firefox_key, firefox_value);
}

 public WebDriver driver;
 @BeforeMethod
 public void precondition()
 {
	 driver.manage().deleteAllCookies();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.get("https://maven.apache.org/surefire/maven-surefire-plugin/examples/testng.html");
	 
 }
 @AfterMethod
 public void postcondition(ITestResult res)
 {
	 int status = res.getStatus();
	 if(status ==2)
	 {
		 String name = res.getMethod().getMethodName();
	 }
	 driver.close();
 }
 
 
 
}
