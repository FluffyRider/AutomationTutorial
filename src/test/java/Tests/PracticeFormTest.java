package Tests;
import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;
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

        //Deschidem un browser
        driver = new ChromeDriver();

        //Accesam un anumit URL
        driver.get("https://demoqa.com");

        //Maximize browser
        driver.manage().window().maximize();

        //Obiecte
        ElementMethods elementMethods = new ElementMethods(driver);
        PageMethods pageMethods = new PageMethods(driver);

        //scroll
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("window.scrollBy(0,350)");
        pageMethods.scrollPage(0, 350);

        WebElement formMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        // formMenu.click();
        elementMethods.clickElement(formMenu);

        WebElement practiceForm = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        // practiceForm.click();
        elementMethods.clickElement(practiceForm);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Mircea";
        //firstNameElement.sendKeys(firstNameValue);
        elementMethods.fillelement(firstNameElement, firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Andreea";
        //lastNameElement.sendKeys(lastNameValue);
        elementMethods.fillelement(lastNameElement, lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailNameValue = "absct@yahoo.com";
        // emailElement.sendKeys(emailNameValue);
        elementMethods.fillelement(emailElement, emailNameValue);

        //js.executeScript("window.scrollBy(0,350)");
        pageMethods.scrollPage(0, 350);

        //Definim o logica generala de a selecta un element dintr-o lista

        List<WebElement> genderElements = driver.findElements(By.xpath("//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']"));
        String genderValue= "Male";
        switch (genderValue){
            case "Male":
                // genderElements.get(0).click();
                elementMethods.clickElement(genderElements.get(0));
                break;
            case "Female":
                // genderElements.get(1).click();
                elementMethods.clickElement(genderElements.get(1));
                break;
            case  "Other":
                //genderElements.get(2).click();
                elementMethods.clickElement(genderElements.get(2));
                break;
        }
        //div[@id='genderWrapper']/div/div/label[@class='custom-control-label']

        WebElement mobileNumberElement = driver.findElement(By.id("userNumber"));
        String mobileNumberValue = "0723423451";
        //mobileNumberElement.sendKeys(mobileNumberValue);
        elementMethods.fillelement(mobileNumberElement, mobileNumberValue);

        //Date of birth
        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        // dateOfBirth.click();
        elementMethods.clickElement(dateOfBirth);

        WebElement dateOfBirthMonthElement = driver.findElement(By.className("react-datepicker__month-select"));
        //Select monthSelect = new Select(dateOfBirthMonthElement);
        //monthSelect.selectByVisibleText("September");
        elementMethods.selectByTextElement(dateOfBirthMonthElement, "September");

        WebElement yearOfBirth = driver.findElement(By.className("react-datepicker__year-select"));
        // Select yearSelect = new Select(yearOfBirth);
        // yearSelect.selectByValue("2023");
        elementMethods.selectByValueElement(yearOfBirth, "2023");

        List<WebElement> daysOfBirthElements = driver.findElements(By.xpath("//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and @role='option']"));
        String daysOfBirthValue = "15";
        for (Integer index = 0; index<daysOfBirthElements.size(); index++){
            if(daysOfBirthElements.get(index).getText().equals(daysOfBirthValue)){
                // daysOfBirthElements.get(index).click();
                elementMethods.clickElement(daysOfBirthElements.get(index));
                break;
            }
        }

        //subjectInput
        WebElement subjectInputElement = driver.findElement(By.id("subjectsInput"));
        String subjectInputValue = "Accounting";
        //subjectInputElement.sendKeys(subjectInputValue);
        elementMethods.fillelement(subjectInputElement, subjectInputValue);
        //subjectInputElement.sendKeys(Keys.ENTER);
        elementMethods.pressElement(subjectInputElement, Keys.ENTER);

        List<WebElement> hobbiesElements = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']"));
        List<String> hobbiesValues = Arrays.asList("Sports", "Reading", "Music");

        //js.executeScript("window.scrollBy(0,360)", "");
        pageMethods.scrollPage(0, 350);
        for(Integer index = 0; index<hobbiesElements.size(); index++) {
            String hobbieText = hobbiesElements.get(index).getText();
            if(hobbiesValues.contains(hobbieText)){
                // JavascriptExecutor jsclick = (JavascriptExecutor)driver;
                //jsclick.executeScript("arguments[0].click();", hobbiesElements.get(index));
                elementMethods.clickJSElement(hobbiesElements.get(index));
            }
        }
        //Interactionam cu un fisier
        WebElement uploadPictureElement = driver.findElement(By.id("uploadPicture"));
        String picturePathValue = "Screenshot 2023-09-14 194516.png";
        File file = new File("src/test/resources/" + picturePathValue);
        uploadPictureElement.sendKeys(file.getAbsolutePath());

        WebElement addressElement = driver.findElement(By.id("currentAddress"));
        String addressElementValue = "adresa";
        addressElement.sendKeys(addressElementValue);

        WebElement stateElement = driver.findElement(By.id("state"));
        //stateElement.click();
        elementMethods.clickElement(stateElement);

        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateInputValue = "Uttar Pradesh";
        stateInputElement.sendKeys(stateInputValue);
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

        List<WebElement> tableValue = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr"));
        Assert.assertEquals(tableValue.get(0).getText(), "Student Name " + firstNameValue + " " + lastNameValue);
        Assert.assertEquals(tableValue.get(1).getText(), "Student Email " + emailNameValue);
        Assert.assertEquals(tableValue.get(2).getText(), "Gender " + genderValue);
        Assert.assertEquals(tableValue.get(3).getText(), "Mobile " + mobileNumberValue);
        Assert.assertEquals(tableValue.get(5).getText(), "Subjects " + subjectInputValue);
        String exceptedHobbiesText = "Hobbies " + String.join(", ", hobbiesValues);
        Assert.assertEquals(tableValue.get(6).getText(), exceptedHobbiesText);
        Assert.assertEquals(tableValue.get(7).getText(), "Picture " + picturePathValue);
        Assert.assertEquals(tableValue.get(8).getText(), "Address " + addressElementValue);
        Assert.assertEquals(tableValue.get(9).getText(), "State and City " + stateInputValue + " " + cityInputValue);

        WebElement closeElement = driver.findElement(By.id("closeLargeModal"));
        //js.executeScript("arguments[0].click;", closeElement);
        elementMethods.clickJSElement(closeElement);

    }
}
