import com.codingRound.pageobjects.HotelsBookingObjects;
import com.sun.javafx.PlatformUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {	
    WebDriver driver;
	public HotelBookingTest() {
		driver = new ChromeDriver();
	}

    @Test
    public void shouldBeAbleToSearchForHotels() {
    	
        setDriverPath();
        HotelsBookingObjects hotelObjs = new HotelsBookingObjects(driver);
        
        driver.get("https://www.cleartrip.com/");
        waitFor(5000);
        
        hotelObjs.hotelLink.click();
        hotelObjs.localityTextBox.sendKeys("Indiranagar, Bangalore");

        new Select(hotelObjs.travellerSelection).selectByVisibleText("1 room, 2 adults");
        waitFor(2000);
        hotelObjs.searchButton.click();

        driver.quit();

    }

    private void waitFor(int durationInMilliSeconds) {
    	 try {
             Thread.sleep(durationInMilliSeconds);
         } catch (InterruptedException e) {
             e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
         }
		
	}

	private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

}
