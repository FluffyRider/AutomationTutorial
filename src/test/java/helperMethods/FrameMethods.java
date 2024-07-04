package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class FrameMethods {
    public WebDriver driver;

    public FrameMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrame(String text){
        driver.switchTo().frame(text);
    }

    public void switchToFrame(WebElement element){
        driver.switchTo().frame(element);
    }

    public void switchToDefault(){
        driver.switchTo().defaultContent();
    }
}
