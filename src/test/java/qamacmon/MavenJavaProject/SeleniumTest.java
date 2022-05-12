package qamacmon.MavenJavaProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SeleniumTest {
	
@DataProvider(name = "valid-mac")
  	public Object[][] validmac(){
        	return new Object[][]{
              	{"00:0C:29:AF:00:01"},{"000C29AF0001"},{"00.0C.29.AF.00.01"}
        	};
  	}

@DataProvider(name = "invalid-mac")
	public Object[][] invalidmac(){
    	return new Object[][]{
          	{"00-0C-29-AF-00-01"},{"00 0C 29 AF 00 01"}
    	};
	}
	
	
	
@Test(dataProvider ="valid-mac")
public void ValidMAC(String macaddress)
{
	System.setProperty("webdriver.chrome.driver", "C:\\workspace\\chromedriver_win64\\chromedriver.exe");
	
    WebDriver driver=new ChromeDriver();

    driver.get("file:///C:/Users/Shanshan%20Zhao/Desktop/Code%20Challenge/HTML-Webseite/index.html");
    
    driver.findElement(By.id("mac_address")).sendKeys(macaddress);
    driver.findElement(By.cssSelector("input.comment-input")).sendKeys("Kommentar");
    driver.findElement(By.cssSelector("button.btn")).click();
    String ActualMsg = driver.findElement(By.tagName("span")).getText();
    String ExpectedMsg = "MAC-Adresse erfolgreich gespeichert.";
    Assert.assertEquals(ExpectedMsg, ActualMsg);
    driver.close();
}

@Test(dataProvider ="invalid-mac")
public void InvalidMAC(String macaddress)
{
	System.setProperty("webdriver.chrome.driver", "C:\\workspace\\chromedriver_win64\\chromedriver.exe");
	
    WebDriver driver=new ChromeDriver();

    driver.get("file:///C:/Users/Shanshan%20Zhao/Desktop/Code%20Challenge/HTML-Webseite/index.html");
    
    driver.findElement(By.id("mac_address")).sendKeys(macaddress);
    driver.findElement(By.cssSelector("input.comment-input")).sendKeys("Kommentar");
    driver.findElement(By.cssSelector("button.btn")).click();
    String ActualMsg = driver.findElement(By.tagName("span")).getText();
    String ExpectedMsg = "Bitte prüfen Sie Ihre Eingaben.";
    Assert.assertEquals(ExpectedMsg, ActualMsg);
    Assert.assertTrue(driver.findElement(By.cssSelector(".mm-alert-item")).isDisplayed());
    driver.close();
}


}
