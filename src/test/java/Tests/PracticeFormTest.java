package Tests;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;
import sharedData.SharedData;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {
    public WebDriver driver;

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(driver);
        homePage.navigateToFormsMenu();

        FormsPage formsPage = new FormsPage(driver);
        formsPage.navigateToPracticeForm();

        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        String firstNameValue = "Larisa";
        String lastNameValue = "Buleu";
        String emailValue = "larisa@yahoo.com";
        String genderValue = "Male";
        String mobileValue = "1234567890";
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
