import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void metodaTest() {

        //Deschidem un browser
        driver = new ChromeDriver();

        //Accesam un anumit URL
        driver.get("https://demoqa.com");

        //Maximize browser
        driver.manage().window().maximize();

        //Obiecte
        PageMethods pageMethods = new PageMethods(driver);
        ElementMethods elementMethods = new ElementMethods(driver);


        //scroll
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)");
        pageMethods.scrollPage(0, 350);

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        //elementsMenu.click();
        elementMethods.clickElement(elementsMenu);

        WebElement webTables = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        // webTables.click();
        elementMethods.clickJSElement(webTables);

        //Definim un element dupa Id
        //test1: adaug un entry nou
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        //addElement.click();
        elementMethods.clickElement(addElement);

        WebElement firstName = driver.findElement(By.id("firstName"));
        String firstNameValue = "Andrei";
        //firstName.sendKeys(firstNameValue);
        elementMethods.fillelement(firstName, firstNameValue);

        WebElement lastName = driver.findElement(By.id("lastName"));
        String lastNameValue = "Popescu";
        //lastName.sendKeys(lastNameValue);
        elementMethods.fillelement(lastName, lastNameValue);

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        String userEmailValue = "andrei@gmail.com";
        //userEmail.sendKeys(userEmailValue);
        elementMethods.fillelement(userEmail, userEmailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "32";
        // ageElement.sendKeys(ageValue);
        elementMethods.fillelement(ageElement, ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "1000";
        //salaryElement.sendKeys(salaryValue);
        elementMethods.fillelement(salaryElement, salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "IT";
        //departmentElement.sendKeys(departmentValue);
        elementMethods.fillelement(departmentElement, departmentValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        //submitElement.click();
        elementMethods.clickElement(submitElement);

        //test2: modific un entry existent
        WebElement updateEntry = driver.findElement(By.id("edit-record-4"));
        //updateEntry.click();
        elementMethods.clickElement(updateEntry);

        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "2300";
        //editSalaryElement.clear();
        elementMethods.fillelement(editSalaryElement, editSalaryValue);
        //editSalaryElement.sendKeys(editSalaryValue);
        elementMethods.fillelement(editSalaryElement, editSalaryValue);

        WebElement editSubmitElement = driver.findElement(By.id("submit"));
        //editSubmitElement.click();
        elementMethods.clickElement(editSubmitElement);

        //test 3: sterg un entry existent
        WebElement deleteEntry = driver.findElement(By.id("edit-record-4"));
        //deleteEntry.click();
        elementMethods.clickElement(deleteEntry);

        driver.quit();
    }

}
