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

public class FramePage {

    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public FrameMethods frameMethods;

    public FramePage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        frameMethods = new FrameMethods(driver);
        PageFactory.initElements(driver, this);
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
