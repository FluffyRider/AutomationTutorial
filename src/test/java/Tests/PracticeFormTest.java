package Tests;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest {
    public WebDriver driver;
    @Test
    public void metodaTest() {

        //deschidem un browser
        driver = new ChromeDriver();

        //accesam un anumit url
        driver.get("https://demoqa.com");

        //Facem browserul in modul maximize
        driver.manage().window().maximize();

        //Close Browser
        //driver quit();

        //Obiecte
        ElementMethods elementMethods = new ElementMethods(driver);
        PageMethods pageMethods = new PageMethods(driver);

        //facem un scroll la pagina pentru vizibiliate
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy (0,350)", "");
        pageMethods.scrollPage(0,400);

        //interactionam cu meniul/submeniul de pe site
        WebElement formmenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementMethods.clickElement(formmenu);

        WebElement practiceFormSubmenu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        //practiceFormSubmenu.click();
        elementMethods.clickElement(practiceFormSubmenu);

        //Maximizam browserul:
        driver.manage().window().maximize();
        //first name
        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNamevalue="Dascalu";
        //firstNameElement.sendKeys(firstNamevalue);
        elementMethods.fillElement(firstNameElement, firstNamevalue);

        //lastname
        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNamevalue ="Marius";
        //lastNameElement.sendKeys(lastNamevalue);
        elementMethods.fillElement(lastNameElement, lastNamevalue);

        //user email
        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailvalue ="dsadsakjb@outlook.com";
        //emailElement.sendKeys(emailvalue);
        elementMethods.fillElement(emailElement, emailvalue);

        //input[@name='gender']

        //definim o logica generala de a selecta un element dintr-o lista:
        //div[@id='genterWrapper']/div/div/label[@class='custom-control-label']

        List<WebElement> genderElements = driver.findElements(By.xpath("//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']"));
        String genderValue= "Male";
        switch (genderValue){
            case "Male":
                //genderElements.get(0).click();
                elementMethods.clickElement(genderElements.get(0));
                break;
            case "Female":
                //genderElements.get(1).click();
                elementMethods.clickElement(genderElements.get(1));
                break;
            case  "Other":
                //genderElements.get(2).click();
                elementMethods.clickElement(genderElements.get(2));
                break;
        }
        //userNumber
        WebElement mobileNumberElement = driver.findElement(By.id("userNumber"));
        String mobileNumbervalue ="0123456789";
        //mobileNumberElement.sendKeys(mobileNumbervalue);
        elementMethods.fillElement(mobileNumberElement,mobileNumbervalue);

        // Date of birth
        WebElement dateOfbirthElement = driver.findElement(By.id("dateOfBirthInput"));
        //dateOfbirthElement.click();
        elementMethods.clickElement(dateOfbirthElement);

        WebElement dateOfBirthMonthElement = driver.findElement(By.className("react-datepicker__month-select"));
        //Select monthSelect = new Select(dateOfBirthMonthElement);
        //monthSelect.selectByVisibleText("September");
        elementMethods.selectByTextElement(dateOfBirthMonthElement,"September");

        WebElement dateOfBirthYearElement = driver.findElement(By.className("react-datepicker__year-select"));
        //Select yearSelect = new Select(dateOfBirthYearElement);
        //yearSelect.selectByValue("2026");
        elementMethods.selectByTextElement(dateOfBirthYearElement, "2026");

        //subjectinput
        WebElement subjectinputElement = driver.findElement(By.id("subjectsInput"));
        String subjectinputValue ="Maths";
        //subjectinputElement.sendKeys(subjectinputValue);
        elementMethods.fillElement(subjectinputElement, subjectinputValue);
        //subjectinputElement.sendKeys(Keys.ENTER);
        elementMethods.pressElement(subjectinputElement, Keys.ENTER);


        List<WebElement>dateOfBirthDaysElement = driver.findElements(By.xpath("//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and @ role='option']"));
        String dateOfBirthDaysValue = "10";
        for (Integer index = 0; index<dateOfBirthDaysElement.size(); index++){
            if (dateOfBirthDaysElement.get(index).getText().equals(dateOfBirthDaysValue)){
                //dateOfBirthDaysElement.get(index).click();
                elementMethods.clickElement(dateOfBirthDaysElement.get(index));
                break;
            }
        }

        //Hobies - alegem mai multe valori
        //div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']
        List<WebElement>hobbiesElemnts = driver.findElements(By.xpath( "//div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']"));
        List<String> hobbiesvalues = Arrays.asList("Sports", "Reading", "Music");
        pageMethods.scrollPage(0,150);
        //JavascriptExecutor jsclick = (JavascriptExecutor)driver;
        // jsclick.executeScript( "window.scrollBy(0,500)","");
        for(Integer index=0; index<hobbiesElemnts.size();index++){
            String hobbiesText= hobbiesElemnts.get(index).getText();
            if (hobbiesvalues.contains(hobbiesText)){
                elementMethods.clickJSElement(hobbiesElemnts.get(index));
               //JavascriptExecutor jsclick = (JavascriptExecutor) driver;
               //jsclick.executeScript("arguments[0].click();", hobbiesElemnts.get(index));
            }
        }
        //Interactionam cu un fisier: upload picture

        WebElement upladpictureElement = driver.findElement(By.id("uploadPicture"));
        String picturePathValue = "Screenshot 2024-05-02 134639.png";
        File file = new File("src/test/resources/Screenshot 2024-05-02 134639.png");
        upladpictureElement.sendKeys(file.getAbsolutePath());

        //curent adress
        WebElement addressElement = driver.findElement(By.id("currentAddress"));
        String addressValue = "adresa";
        addressElement.sendKeys(addressValue);

        WebElement stateElement = driver.findElement(By.id("state"));
        //stateElement.click();
        elementMethods.clickElement(stateElement);
        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateInputvalue = "Uttar Pradesh";
        stateInputElement.sendKeys(stateInputvalue);
        stateInputElement.sendKeys(Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("city"));
        //cityElement.click();
        elementMethods.clickElement(cityElement);
        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityInputValue = "Agra";
        cityInputElement.sendKeys(cityInputValue);
        cityInputElement.sendKeys(Keys.ENTER);

        WebElement submitForm = driver.findElement(By.id("submit"));
        //submitForm.click();
        elementMethods.clickElement(submitForm);

        // validam tabelul cu valorile introduse

        WebElement thankYouMessageElement = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(thankYouMessageElement.getText(), "Thanks for submitting the form");

        List<WebElement>tableValues = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr"));
        Assert.assertEquals(tableValues.get(0).getText(), "Student Name " + firstNamevalue + " " + lastNamevalue);
        Assert.assertEquals(tableValues.get(1).getText(), "Student Email " + emailvalue);
        Assert.assertEquals(tableValues.get(2).getText(), "Gender " + genderValue);
        Assert.assertEquals(tableValues.get(3).getText(), "Mobile " + mobileNumbervalue);
        Assert.assertEquals(tableValues.get(5).getText(), "Subjects " + subjectinputValue);
        String expectedHobbiesText = "Hobbies " + String.join(", ", hobbiesvalues);
        Assert.assertEquals(tableValues.get(6).getText(), expectedHobbiesText);

        Assert.assertEquals(tableValues.get(7).getText(), "Picture " + picturePathValue);
        Assert.assertEquals(tableValues.get(8).getText(), "Address " + addressValue);
        Assert.assertEquals(tableValues.get(9).getText(), "State and City " + stateInputvalue + " "+ cityInputValue);

        WebElement closeElement = driver.findElement(By.id("closeLargeModal"));

       // closeElement.click();
        elementMethods.clickElement(closeElement);

    }
}
