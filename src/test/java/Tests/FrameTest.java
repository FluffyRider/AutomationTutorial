package Tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.AlertsWindowsPage;
import pages.FramePage;
import pages.HomePage;
import pages.NestedFramePage;
import sharedData.SharedData;

public class FrameTest extends SharedData{
    public WebDriver driver;

        @Test
        public void alertTest() {

            HomePage homePage = new HomePage(getDriver());
            homePage.navigateToAlertsMenu();

            AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(getDriver());
            alertsWindowsPage.navigateToFramePage();

            FramePage framePage = new FramePage(getDriver());
            framePage.interactWithBigIFrame();
            framePage.interactWithSmallIFrame();
            framePage.navigateToNestedFrames();

            NestedFramePage nestedFramePage = new NestedFramePage(getDriver());
            nestedFramePage.interactWithNestedFrames();

            //driver.quit();

        }
    }
