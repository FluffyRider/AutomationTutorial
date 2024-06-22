package helperMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowMethods {

    public WebDriver driver;
    //Constructor
    public WindowMethods(WebDriver driver) {
        this.driver = driver;
    }


    //Metode generale pentru interactiunea cu tab/window

    public void swittchSpecifictab(Integer index){

        List<String> window = new ArrayList<>(driver.getWindowHandles());//gaseste cate taburi/window gaseste deschise in mom definirii
        driver.switchTo().window(window.get(index));
    }
    public void closeCurentTab(){
        driver.close();
    }
}
