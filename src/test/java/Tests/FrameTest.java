package Tests;
import helperMethods.AlertMethods;
import helperMethods.ElementMethods;
import helperMethods.FrameMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.AlertsWindowsPage;
import pages.FramePage;
import pages.HomePage;
import pages.NestedFramePage;
import java.time.Duration;

public class FrameTest {
    public WebDriver driver;

    @Test
    public void alertTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        HomePage homePage = new HomePage(driver);
        homePage.navigateToAlertsMenu();

        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(driver);
        alertsWindowsPage.navigateToFramePage();

        FramePage framePage = new FramePage(driver);
        framePage.interactWithBigIFrame();
        framePage.interactWithSmallIFrame();
        framePage.navigateToNestedFrames();

        NestedFramePage nestedFramePage = new NestedFramePage(driver);
        nestedFramePage.interactWithNestedFrames();

        //driver.quit();

    }
}
