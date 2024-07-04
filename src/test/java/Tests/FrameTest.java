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
    public void metodaTest() {

        //Deschidem un browser
        driver = new ChromeDriver();

        //Accesam un anumit URL
        driver.get("https://demoqa.com");

        //Maximize browser
        driver.manage().window().maximize();

        //Wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        AlertMethods alertMethods = new AlertMethods(driver);
        ElementMethods elementMethods = new ElementMethods(driver);
        PageMethods pageMethods = new PageMethods(driver);
        FrameMethods frameMethods = new FrameMethods(driver);

        HomePage homePage = new HomePage(driver);
        homePage.navigateToAlertsMenu();


        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(driver);
        alertsWindowsPage.navigateToFramePage();

        FramePage framePage = new FramePage(driver);
        framePage.interectWithBigIFrame();
        framePage.interectWithSmallIFame();
        framePage.navigateToNastedFrame();

        NestedFramePage nestedFramePage = new NestedFramePage(driver);
        nestedFramePage.interectWithNestedFrame();


        //driver.quit();

    }
}
