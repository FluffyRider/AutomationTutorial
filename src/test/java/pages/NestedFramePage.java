package pages;
import helperMethods.ElementMethods;
import helperMethods.FrameMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramePage extends BasePage{
    public NestedFramePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    WebElement childFrame;

    @FindBy(xpath = "//p")
    WebElement text;

    public void interactWithNestedFrames(){
        frameMethods.switchToFrame("frame1");
        frameMethods.switchToFrame(childFrame);
        System.out.println(text.getText());
        frameMethods.switchToDefault();
    }

}
