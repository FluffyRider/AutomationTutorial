package pages;

import helperMethods.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected ElementMethods elementMethods;
    protected PageMethods pageMethods;
    protected AlertMethods alertMethods;
    protected FrameMethods frameMethods;
    protected WindowsMethods windowsMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        alertMethods = new AlertMethods(driver);
        frameMethods = new FrameMethods(driver);
        windowsMethods = new WindowsMethods(driver);
        PageFactory.initElements(driver, this);
    }

}

