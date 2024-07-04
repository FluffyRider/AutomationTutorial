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
    public void metodaTest() {

        //Deschidem un browser
        driver = new ChromeDriver();

        //Accesam un anumit URL
        driver.get("https://demoqa.com");

        //Maximize browser
        driver.manage().window().maximize();

        //Definim un obliect de tipul Window Methods
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAlertsMenu();

        AlertsWindowsPage alertsWindows = new AlertsWindowsPage(driver);
        alertsWindows.navigateToWindowPage();

        WindowsPage windowsPage = new WindowsPage(driver);
        windowsPage.interactWithNewTab();
        windowsPage.interactWithNewWindow();

        driver.quit();


    }
}
