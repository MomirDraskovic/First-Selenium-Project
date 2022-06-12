package Page;

import HaloOglasi.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPageHaloOglasi extends BaseTest {
    public RegistrationPageHaloOglasi(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@value='person']")
    WebElement radioButtonFizickoLice;
    @FindBy (id="UserName")
    WebElement userNameInputField;
    @FindBy (id="Email")
    WebElement emailAddressInputField;
    @FindBy (id="Password")
    WebElement passwordInputField;
    @FindBy (id="ConfirmPassword")
    WebElement confirmationPassInputField;
    @FindBy (id="HasAgreedToGetFiscalReceiptByEmail")
    WebElement subscriptionByEmailCheckbox;
    @FindBy (css = ".buttons-wrapper>button:first-child")
    WebElement registrationButton;
    @FindBy (xpath = "//div[@class='regsitration-success']")
    WebElement successfulRegistrationText;

    public void radioButtonFizickoLiceAlwaysSelected() {
        wdWait.until(ExpectedConditions.elementToBeClickable(radioButtonFizickoLice));
        if (!radioButtonFizickoLice.isSelected())
            radioButtonFizickoLice.click();
       // Assert.assertTrue(this.radioButtonFizickoLice.isSelected()); - asertovi idu u test
    }

    public void userNameInputFieldSendKeys(String userName){
        wdWait.until(ExpectedConditions.visibilityOf(userNameInputField)).clear();
        userNameInputField.sendKeys(userName);
    }
    public void emailAddressSendKeys (String email) {
        wdWait.until(ExpectedConditions.visibilityOf(emailAddressInputField)).clear();
        emailAddressInputField.sendKeys(email);
    }

    public void passwordInputFieldSendKeys (String password) {
        wdWait.until(ExpectedConditions.visibilityOf(passwordInputField)).clear();
        passwordInputField.sendKeys(password);
    }
    public void confirmationPassSendKeys (String passwordConfirmation){
        wdWait.until(ExpectedConditions.visibilityOf(confirmationPassInputField)).clear();
        confirmationPassInputField.sendKeys(passwordConfirmation);
    }
    public void subscriptionForFiscalReceiptByEmailClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(subscriptionByEmailCheckbox)).click();
    }
    public void registrationButtonClick () {
        wdWait.until(ExpectedConditions.elementToBeClickable(registrationButton)).click();
    }

    public boolean SuccessfulRegistrationTextDisplay(){
        wdWait.until(ExpectedConditions.visibilityOf(successfulRegistrationText));
        return  successfulRegistrationText.isDisplayed();
    }
    public String SuccessfulRegistrationTextAssert(){
        wdWait.until(ExpectedConditions.visibilityOf(successfulRegistrationText));
        return  successfulRegistrationText.getText();
    }

    //momirtest@mailinator.com
}
