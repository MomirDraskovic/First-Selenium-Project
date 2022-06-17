package HaloOglasi.Page;

import HaloOglasi.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageHaloOglasi extends BaseTest {
    public LoginPageHaloOglasi(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Registrujte se →")
    WebElement linkRegistrujSeLink;

    @FindBy (id = "EMailOrUsername")
    WebElement emailIliKorisnickoImeInputField;
    @FindBy (css =".login-button")
    WebElement logInButton;

    public void registrujSeLinkClick(){
        wdWait.until(ExpectedConditions.visibilityOf(linkRegistrujSeLink)).click();
    }

    public void emailIliKorisnickoImeInputFieldSendKeys(String emailIliKorisnickoIme){
        wdWait.until(ExpectedConditions.visibilityOf(emailIliKorisnickoImeInputField)).clear();
        emailIliKorisnickoImeInputField.sendKeys(emailIliKorisnickoIme);
    }
    public void logInButtonClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(logInButton)).click();
    }
}
