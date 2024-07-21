import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;
import sharedData.SharedData;

public class WebTableTest extends SharedData {

    public WebDriver driver;

    @Test
    public void metodaTest(){

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToElementsMenu();

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.selectWebTableSubmenu();

        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.addEntry("Marius", "D", "lfsdfwefwe@outlook.com", "41",
                "4335", "Testing");
        webTablePage.editEntry("10001", "QC");
        webTablePage.deleteEntry();

        driver.quit();

    }

}
