package pages;

import helperMethods.AlertMethods;
import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public AlertMethods alertMethods;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        alertMethods = new AlertMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "alertButton")
    public WebElement firstAlert;
    @FindBy(id = "confirmButton")
    public WebElement confirmAlertButton;
    @FindBy(id = "promtButton")
    public WebElement promptAlertButton;
    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertButton;

    public void interactAlertOk(){
        elementMethods.clickElement(firstAlert);
        alertMethods.acceptAlert();
    }

    public void interactWithConfirmationButton(){
        elementMethods.clickElement(confirmAlertButton);
        alertMethods.dismisAlert();
    }

    public void interactWithPromptButton(String text){
        elementMethods.clickElement(promptAlertButton);
        alertMethods.fillAlert(text);
    }

    public void interactWithTimerButton() {
        elementMethods.clickElement(timerAlertButton);
        alertMethods.acceptAlert();
    }
}
