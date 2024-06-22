package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void metodaTest() {

        //deschidem un browser
        driver = new ChromeDriver();

        //accesam un anumit url
        driver.get("https://demoqa.com");


        //Facem browserul in modul maximize
        driver.manage().window().maximize();
        //Close browser
        //driver.quit();

        //Obiect

        //facem un scroll la pagina pentru vizibiliate
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy (0,350)","");

        //interactionam cu meniul/submeniul de pe site
        WebElement elementsmenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsmenu.click();

        WebElement webtablesubmenu = driver.findElement(By.xpath("//span[text]()='Web Tables']"));
        webtablesubmenu.click();

        //Definim un element dupa id
        //Test 1 adaug un entry
        WebElement addEllement = driver.findElement(By.id("addNewRecordButton"));
        addEllement.click();

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Marius";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastnameElement = driver.findElement(By.id("lastName"));
        String lastnameValue = "Dascalu";
        lastnameElement.sendKeys(lastnameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "marius.rider@mail.com";
        emailElement.sendKeys(emailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "41";
        ageElement.sendKeys(ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "10001";
        salaryElement.sendKeys(salaryValue);

        WebElement departamentElement = driver.findElement(By.id("department"));
        String departmentValue = "Testing";
        departamentElement.sendKeys(departmentValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        submitElement.click();

        //test2: modific un entry existent
        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        editElement.click();

        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "25001";
        editSalaryElement.clear();
        editSalaryElement.sendKeys(editSalaryValue);

        WebElement editDepartmentElement = driver.findElement(By.id("department"));
        String editDepartmentValue = "HR";
        editSalaryElement.clear();
        editDepartmentElement.sendKeys(editDepartmentValue);

        WebElement editSubmitelement= driver.findElement(By.id("submit"));
        editSubmitelement.click();

        //test3: sterg un entry existent (generat tot de mine)

        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        deleteElement.click();
        driver.quit();


    }

}
