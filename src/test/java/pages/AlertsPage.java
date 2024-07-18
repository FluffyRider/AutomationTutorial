package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    private WebElement firstAlert;
    @FindBy(id = "confirmButton")
    private WebElement confirmAlertButton;
    @FindBy(id = "promtButton")
    private WebElement promptAlertButton;
    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButton;

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
