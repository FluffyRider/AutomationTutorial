
import helperMethods.AlertMethods;
import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {

        //Deschidem un browser
        driver = new ChromeDriver();

        //Accesam un anumit URL
        driver.get("https://demoqa.com");

        //Maximize browser
        driver.manage().window().maximize();

        //Wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Definim un obiect de tip alert methods ca sa apelam metodele generale din clasa
        AlertMethods alertMethods = new AlertMethods(driver);
        ElementMethods elementMethods = new ElementMethods(driver);
        PageMethods pageMethods=new PageMethods(driver);

        //scroll
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)");
        pageMethods.scrollPage(0,350);

        WebElement alertsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        //alertsMenu.click();
        elementMethods.clickElement(alertsMenu);

        WebElement alertsForm = driver.findElement(By.xpath("//span[text()='Alerts']"));
        //alertsForm.click();
        elementMethods.clickElement(alertsForm);

        //interactionam cu o alerta

        //js.executeScript("window.scrollBy(0,150)");
        pageMethods.scrollPage(0, 150);

        WebElement alertButtonOK = driver.findElement(By.id("alertButton"));
        //alertButtonOk.click();
        elementMethods.clickElement(alertButtonOK);

        /*
        Alert alertOK = driver.switchTo().alert();
        System.out.println(alertOK.getText());
        alertOK.accept();
        */

        alertMethods.acceptAlert();

        //js.executeScript("window.scrollBy(0,150)");
        pageMethods.scrollPage(0, 150);
        WebElement alertConfirmButton = driver.findElement(By.id("confirmButton"));
        elementMethods.clickElement(alertConfirmButton);

        alertMethods.dismisAlert();

        /*
        Alert alertConfirm = driver.switchTo().alert();
        System.out.println(alertConfirm.getText());
        alertConfirm.dismiss();
      */

        WebElement alertPromptButton = driver.findElement(By.id("promtButton"));
        elementMethods.clickElement(alertPromptButton);

        alertMethods.fillAlert("Marius");

        /*
        Alert promptConfirm = driver.switchTo().alert();
        System.out.println(promptConfirm.getText());
        String alertValue = "Marius";
        promptConfirm.sendKeys(alertValue);
        promptConfirm.accept();
        */

        //Interactionam cu o alerta pentru care trebuie sa asteptam putin
        WebElement alertWait = driver.findElement(By.id("timerAlertButton"));
        elementMethods.clickElement(alertWait);

        alertMethods.acceptAlert();

        /*
        //Definim un wait explicit
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.alertIsPresent());

        Alert waitConfirm = driver.switchTo().alert();
        System.out.println(waitConfirm.getText());
        waitConfirm.accept();

         */
    }
}

