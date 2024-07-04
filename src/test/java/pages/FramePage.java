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

public class FramePage {public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public FrameMethods frameMethods;

    public FramePage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        pageMethods  = new PageMethods(driver);
        frameMethods = new FrameMethods(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "sampleHeading")
    public WebElement iframeText;

    @FindBy(id = "sampleHeading")
    public WebElement iframeText2;

    @FindBy(xpath = "//span[text()='Nested Frames']")
    public WebElement nestedButton;


    public void interectWithBigIFrame(){
        frameMethods.switchtoFrame("frame1");
        System.out.println(iframeText.getText());
        frameMethods.defaultContent();
    }

    public void interectWithSmallIFame(){
        frameMethods.switchtoFrame("frame2");
        System.out.println(iframeText2.getText());
        frameMethods.defaultContent();
    }

    public void navigateToNastedFrame() {
        pageMethods.scrollPage(0, 350);
        elementMethods.clickElement(nestedButton);

    }
}
