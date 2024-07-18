package pages;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsMenu;
    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsMenu;
    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formMenu;

    public void navigateToAlertsMenu(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(alertsMenu);
    }

    public void navigateToFormsMenu(){
        pageMethods.scrollPage(0, 350);
        elementMethods.clickElement(formMenu);
    }

    public void navigateToElementsMenu(){
        pageMethods.scrollPage(0, 350);
        elementMethods.clickElement(elementsMenu);
    }

}
