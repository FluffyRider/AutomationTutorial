package pages;
import helperMethods.ElementMethods;
import helperMethods.FrameMethods;
import helperMethods.PageMethods;
import helperMethods.WindowsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage extends BasePage {
    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sampleHeading")
    WebElement iframeText;
    @FindBy(id = "sampleHeading")
    WebElement iframeText2;
    @FindBy(xpath = "//span[text()='Nested Frames']")
    WebElement nestedFramesFromSubmenu;


    public void interactWithBigIFrame(){
        frameMethods.switchToFrame("frame1");
        System.out.println(iframeText.getText());
        driver.switchTo().defaultContent();
    }

    public void interactWithSmallIFrame(){
        frameMethods.switchToFrame("frame2");
        System.out.println(iframeText2.getText());
        frameMethods.switchToDefault();
    }

    public void navigateToNestedFrames(){
        elementMethods.clickElement(nestedFramesFromSubmenu);
    }


}
