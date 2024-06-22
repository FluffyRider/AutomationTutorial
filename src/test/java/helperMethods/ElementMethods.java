package helperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementMethods {
    public WebDriver driver;

    //Constructor

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
    }
    //Metode generale penru interactiunea cu elemente

    public void waitForElementVisible(WebElement element){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //asteapta maxim 10 secunde
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void clickElement(WebElement element){
        waitForElementVisible(element);
        element.click();

    }
    public void fillElement (WebElement element, String text){
        waitForElementVisible(element);
        element.sendKeys(text);
    }

    public void pressElement(WebElement element, Keys key){
        waitForElementVisible(element);
        element.sendKeys(key);
    }

    public void clickJSElement(WebElement element){
        waitForElementVisible(element);
        JavascriptExecutor jsclick = (JavascriptExecutor) driver;
        jsclick.executeScript("arguments[0].click();", element);
    }
    public void selectByTextElement(WebElement element, String text){
        waitForElementVisible(element);
        Select monthSelect = new Select(element);
        monthSelect.selectByVisibleText(text);
    }
    public void selectByValue(WebElement element, String text) {
        waitForElementVisible(element);
        Select yearSelect = new Select(element);
        yearSelect.selectByValue(text);
    }



}

