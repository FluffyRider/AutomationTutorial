package Tests;
import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        homePage.navigateToFormsMenu();
        FormsPage formsPage = new FormsPage(driver);
        formsPage.navigateToPracticeForm();
        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        String firstNameValue = "Larisa";
        String lastNameValue = "Buleu";
        String emailValue = "larisa@yahoo.com";
        String genderValue = "Female";
        String mobileValue = "0766000000";
        String dateofBirthDayValue = "15";
        String subjectValue = "Accounting";
        List<String> hobbiesValues = Arrays.asList("Reading", "Music");
        String picturePathValue = "test.txt";
        String addressValue = "Str. Mihai-Bravu, nr 12";
        String stateInputValue = "Haryana";
        String cityInputValue = "Panipat";

        practiceFormPage.fillEntireForm(firstNameValue, lastNameValue, emailValue, genderValue, mobileValue, dateofBirthDayValue, subjectValue, hobbiesValues,
                picturePathValue, addressValue, stateInputValue, cityInputValue);
        practiceFormPage.validateEntireForm(firstNameValue, lastNameValue, emailValue, genderValue, mobileValue, dateofBirthDayValue, subjectValue, hobbiesValues, picturePathValue,
                addressValue, stateInputValue, cityInputValue);

    }
}
