package pages;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement alertsMenu;
    @FindBy(xpath = "//h5[text()='Elements']")
    public WebElement elementsMenu;
    @FindBy(xpath = "//h5[text()='Forms']")
    public WebElement formMenu;

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
