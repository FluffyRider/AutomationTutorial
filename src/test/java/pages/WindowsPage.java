package pages;
import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import helperMethods.WindowsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowsPage extends BasePage {
    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    public WebElement newTab;

    @FindBy(id = "windowButton")
    public WebElement newWindow;




    public void interactWithNewTab(){
        pageMethods.scrollPage(0, 150);
        elementMethods.clickElement(newTab);

        System.out.println(driver.getCurrentUrl()); //url-ul paginii curente pe care ne aflam
        windowsMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());
        windowsMethods.closeCurrentTab();
        windowsMethods.switchSpecificTab(0);
    }

    public void interactWithNewWindow() {
        pageMethods.scrollPage(0, 150);
        newWindow.click();

        System.out.println(driver.getCurrentUrl());
        windowsMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());
        windowsMethods.closeCurrentTab();
    }

}
