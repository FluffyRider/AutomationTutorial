package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.io.File;
import java.util.List;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "firstName")
    private WebElement firstNameElement;

    @FindBy(id = "lastName")
    private WebElement lastNameElement;

    @FindBy(id = "userEmail")
    private WebElement emailElement;

    @FindBy(xpath = "//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']")
    private List<WebElement> genderElements;

    @FindBy(id = "userNumber")
    private WebElement mobileElement;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthElement;

    @FindBy(className = "react-datepicker__month-select")
    private WebElement dateOfBirthMonthElement;

    @FindBy(className = "react-datepicker__year-select")
    private WebElement dateOfBirthYearElement;

    @FindBy(xpath = "//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and @role='option']")
    private List<WebElement> dateOfBirthDaysElements;

    @FindBy(id = "subjectsInput")
    private WebElement subjectElement;

    @FindBy(xpath = "//div[@id = 'hobbiesWrapper']/div/div/label[@class='custom-control-label']")
    private List<WebElement> hobbiesElements;

    @FindBy(id = "uploadPicture")
    private WebElement fileUploadElement;

    @FindBy(id = "currentAddress")
    private WebElement addressElement;

    @FindBy(id = "state")
    private WebElement stateElement;

    @FindBy(id = "react-select-3-input")
    private WebElement stateInputElement;

    @FindBy(id = "city")
    private WebElement cityElement;

    @FindBy(id = "react-select-4-input")
    private WebElement cityInputElement;

    @FindBy(id = "submit")
    private WebElement submitElement;

    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement thankYouMessageElement;

    @FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr")
    private List<WebElement> tableValues;

    @FindBy(id = "closeLargeModal")
    private WebElement closeButton;


    public void fillEntireForm(String firstNameValue, String lastNameValue, String emailValue, String genderValue, String mobileValue,
                               String dateofBirthDayValue, String subjectValue, List<String> hobbiesValues, String picturePathValue, String addressValue, String stateInputValue,
                               String cityInputValue) {

        elementMethods.fillElement(firstNameElement, firstNameValue);


        elementMethods.fillElement(lastNameElement, lastNameValue);


        elementMethods.fillElement(emailElement, emailValue);


        switch (genderValue) {
            case "Male":
                elementMethods.clickElement(genderElements.get(0));
                break;
            case "Female":
                elementMethods.clickElement(genderElements.get(1));
                break;
            case "Other":
                genderElements.get(2).click();
                elementMethods.clickElement(genderElements.get(2));
                break;
        }


        elementMethods.fillElement(mobileElement, mobileValue);

        elementMethods.clickElement(dateOfBirthElement);

        elementMethods.selectByTextElement(dateOfBirthMonthElement, "January");

        elementMethods.selectByValueElement(dateOfBirthYearElement, "1990");


        for (Integer index = 0; index < dateOfBirthDaysElements.size(); index++) {
            if (dateOfBirthDaysElements.get(index).getText().equals(dateofBirthDayValue)) {
                elementMethods.clickElement(dateOfBirthDaysElements.get(index));
                break;
            }
        }


        elementMethods.fillElement(subjectElement, subjectValue);
        elementMethods.pressElement(subjectElement, Keys.ENTER);


        pageMethods.scrollPage(0, 350);
        for (Integer index = 0; index < hobbiesElements.size(); index++) {
            String hobbyText = hobbiesElements.get(index).getText();
            if (hobbiesValues.contains(hobbyText)) {
                elementMethods.clickElement(hobbiesElements.get(index));
            }
        }


        File file = new File("src/test/resources/" + picturePathValue);
        elementMethods.fillElement(fileUploadElement, file.getAbsolutePath());


        elementMethods.fillElement(addressElement, addressValue);

        elementMethods.clickElement(stateElement);


        elementMethods.fillElement(stateInputElement, stateInputValue);
        elementMethods.pressElement(stateInputElement, Keys.ENTER);

        elementMethods.clickElement(cityElement);


        elementMethods.fillElement(cityInputElement, cityInputValue);
        elementMethods.pressElement(cityInputElement, Keys.ENTER);
        elementMethods.clickElement(submitElement);

    }


    public void validateEntireForm(String firstNameValue, String lastNameValue, String emailValue, String genderValue, String mobileValue, String dateofBirthDayValue,
                                   String subjectValue, List<String> hobbiesValues, String picturePathValue, String addressValue, String stateInputValue,
                                   String cityInputValue) {
        Assert.assertEquals(thankYouMessageElement.getText(), "Thanks for submitting the form");

        Assert.assertEquals(tableValues.get(0).getText(), "Student Name " + firstNameValue + " " + lastNameValue);
        Assert.assertEquals(tableValues.get(1).getText(), "Student Email " + emailValue);
        Assert.assertEquals(tableValues.get(2).getText(), "Gender " + genderValue);
        Assert.assertEquals(tableValues.get(3).getText(), "Mobile " + mobileValue);
        Assert.assertEquals(tableValues.get(4).getText(), "Date of Birth 15 January,1990");
        Assert.assertEquals(tableValues.get(5).getText(), "Subjects " + subjectValue);
        String listStringHobbiesValues = String.join(", ", hobbiesValues);
        Assert.assertEquals(tableValues.get(6).getText(), "Hobbies " + listStringHobbiesValues);
        Assert.assertEquals(tableValues.get(7).getText(), "Picture " + picturePathValue);
        Assert.assertEquals(tableValues.get(8).getText(), "Address " + addressValue);
        Assert.assertEquals(tableValues.get(9).getText(), "State and City " + stateInputValue + " " + cityInputValue);

        elementMethods.clickElement(closeButton);

        }
    }