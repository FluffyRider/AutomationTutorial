package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.AlertsWindowsPage;
import pages.HomePage;
import pages.WindowsPage;

public class WindowTest {
    public WebDriver driver;

    @Test
    public void windowTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        homePage.navigateToAlertsMenu();

        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(driver);
        alertsWindowsPage.navigateToWindowPage();

        WindowsPage windowsPage = new WindowsPage(driver);
        windowsPage.interactWithNewTab();
        windowsPage.interactWithNewWindow();

        driver.quit();

    }
}
