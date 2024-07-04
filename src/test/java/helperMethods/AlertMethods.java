package helperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods {

    public WebDriver driver;

    public AlertMethods(WebDriver driver) {
        this.driver = driver;
    }

    //Definim metode generale pentru interactiunea cu alerte

    public void waitForAler(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(){
        waitForAler();
        Alert waitConfirm = driver.switchTo().alert();
        System.out.println(waitConfirm.getText());
        waitConfirm.accept();
    }

    public void dismisAlert(){
        Alert waitConfirm = driver.switchTo().alert();
        System.out.println(waitConfirm.getText());
        waitConfirm.dismiss();
    }

    public void fillAlert(String value){
        Alert promptConfirm = driver.switchTo().alert();
        System.out.println(promptConfirm.getText());
        promptConfirm.sendKeys(value);
        promptConfirm.accept();

    }

}
