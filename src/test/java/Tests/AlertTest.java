import helperMethods.AlertMethods;
import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.AlertsWindowsPage;
import pages.HomePage;

import java.time.Duration;

public class AlertTest {

    public WebDriver driver;
    @Test
    public void alertTest(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        HomePage homePage = new HomePage(driver);
        homePage.navigateToAlertsMenu();
        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(driver);
        alertsWindowsPage.navigateToAlertsPage();
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.interactAlertOk();
        alertsPage.interactWithTimerButton();
        alertsPage.interactWithPromptButton("text alerta");
        alertsPage.interactWithConfirmationButton();
    }
}

