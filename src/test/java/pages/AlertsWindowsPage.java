package pages;
import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsWindowsPage extends BasePage {
    public AlertsWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserWindowsSubmenu;
    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement framesFromSubmenu;
    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertsFromSubmenu;



    public void navigateToWindowPage(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(browserWindowsSubmenu);
    }

    public void navigateToFramePage(){
        pageMethods.scrollPage(0, 350);
        elementMethods.clickElement(framesFromSubmenu);

    }

    public void navigateToAlertsPage(){
        elementMethods.clickElement(alertsFromSubmenu);
    }
}
