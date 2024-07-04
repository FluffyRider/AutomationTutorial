import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void metodaTest(){

        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        homePage.navigateToElementsMenu();

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.selectWebTableSubmenu();

        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.addEntry("Marius", "D", "lfsdfwefwe@outlook.com", "41",
                "4335", "Testing");
        webTablePage.editEntry("10001", "QC");
        webTablePage.deleteEntry();

        driver.quit();

    }

}
