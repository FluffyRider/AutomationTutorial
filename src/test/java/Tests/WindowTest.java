package Tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.AlertsWindowsPage;
import pages.HomePage;
import pages.WindowsPage;
import sharedData.SharedData;

public class WindowTest extends SharedData {


    @Test
    public void windowTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToAlertsMenu();

        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(getDriver());
        alertsWindowsPage.navigateToWindowPage();

        WindowsPage windowsPage = new WindowsPage(getDriver());
        windowsPage.interactWithNewTab();
        windowsPage.interactWithNewWindow();
    }
}
