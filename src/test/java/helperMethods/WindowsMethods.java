package helperMethods;
import org.openqa.selenium.WebDriver;
import sharedData.SharedData;
import java.util.ArrayList;
import java.util.List;

public class WindowsMethods extends SharedData {

    public WebDriver driver;

    public WindowsMethods(WebDriver driver) {
        this.driver = driver;
    }

    //metode generale pt interactiunea cu tab/window
    public void switchSpecificTab(Integer index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());   //gaseste cate taburi/windows sunt deschise

        //ne mutam cu focusul pe un anumit tab
        driver.switchTo().window(tabs.get(index));
    }

    public void closeCurrentTab() {
        driver.close();

    }
}