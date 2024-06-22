package Tests;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import helperMethods.WindowMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {

        //deschidem un browser
        driver = new ChromeDriver();

        //accesam un anumit url
        driver.get("https://demoqa.com");

        //Facem browserul in modul maximize

        driver.manage().window().maximize();

        //Definim un obiect de tipul window methods
        WindowMethods windowMethods=new WindowMethods(driver);
        ElementMethods elementMethods=new ElementMethods(driver);
        PageMethods pageMethods=new PageMethods(driver);

        //facem un scroll la pagina pentru vizibiliate
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy (0,350)", "");
        pageMethods.scrollPage(0,350);

        //interactionam cu meniul/submeniul de pe site
        WebElement alertMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        //alertMenu.click();
        elementMethods.clickElement(alertMenu);

        WebElement browserWindows = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        //browserWindows.click();
        elementMethods.clickElement(browserWindows);

        WebElement newTab = driver.findElement(By.id("tabButton"));
        //newTab.click();
        elementMethods.clickElement(newTab );

        //Interactioncu un tab/window
        //System.out.println(driver.getTitle());  //titlul paginii curente pe care ne aflam
        System.out.println(driver.getCurrentUrl());
        //List<String> tabs = new ArrayList<>(driver.getWindowHandles());//gaseste cate taburi/window gaseste deschise in mom definirii
        //driver.switchTo().window(tabs.get(1));
        windowMethods.swittchSpecifictab(1);
        System.out.println(driver.getCurrentUrl());

        //inchidem tabul curent
        //driver.close();

        windowMethods.closeCurentTab();
        //driver.switchTo().window(tabs.get(0));
        windowMethods.swittchSpecifictab(0);

        WebElement newWindow = driver.findElement(By.id("windowButton"));
        //newWindow.click();
        elementMethods.clickElement(newWindow);
        System.out.println(driver.getCurrentUrl());

        //js.executeScript("window.scrollBy(0,150)", "");
        pageMethods.scrollPage(0,350);
       // List<String> window = new ArrayList<>(driver.getWindowHandles());//gaseste cate taburi/window gaseste deschise in mom definirii
        //driver.switchTo().window(window.get(1));
        windowMethods.swittchSpecifictab(1);
        System.out.println(driver.getCurrentUrl());
        windowMethods.closeCurentTab();
        driver.quit();




    }
}
