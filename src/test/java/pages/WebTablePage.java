package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablePage extends BasePage{

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "addNewRecordButton")
    public WebElement addElement;
    @FindBy(id = "firstName")
    public WebElement firstNameElement;
    @FindBy(id = "lastName")
    public WebElement lastNameElement;
    @FindBy(id = "userEmail")
    public WebElement emailElement;
    @FindBy(id = "age")
    public WebElement ageElement;
    @FindBy(id = "salary")
    public WebElement salaryElement;
    @FindBy(id = "department")
    public WebElement departamentElement;
    @FindBy(id = "submit")
    public WebElement submitElement;
    @FindBy(id = "edit-record-4")
    public WebElement updateElement;
    @FindBy(id = "salary")
    public WebElement editSalaryElement;
    @FindBy(id = "department")
    public WebElement editDepartamentElement;
    @FindBy(id = "submit")
    public WebElement editSubmitElement;
    @FindBy(id = "delete-record-4")
    public WebElement deleteElement;

    public void addEntry(String firstNameValue, String lastNameValue, String emailValue, String ageValue, String salaryValue,
                         String departamentValue){
        elementMethods.clickElement(addElement);
        elementMethods.fillElement(firstNameElement, firstNameValue);
        elementMethods.fillElement(lastNameElement, lastNameValue);
        elementMethods.fillElement(emailElement, emailValue);
        elementMethods.fillElement(ageElement, ageValue);
        elementMethods.fillElement(salaryElement, salaryValue);
        elementMethods.fillElement(departamentElement, departamentValue);
        elementMethods.clickElement(submitElement);
    }

    public void editEntry(String editSalaryValue, String editDepartamentValue){
        elementMethods.clickElement(updateElement);
        elementMethods.clearFillElement(editSalaryElement, editSalaryValue);
        elementMethods.clearFillElement(editDepartamentElement, editDepartamentValue);
        elementMethods.clickElement(editSubmitElement);
    }

    public void deleteEntry(){
        elementMethods.clickElement(deleteElement);
    }
}
