package HaloOglasi.Page;

import HaloOglasi.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageMailinator extends BaseTest {

    public HomePageMailinator() {
        PageFactory.initElements(driver,this);
        }

        @FindBy (id = "search")
    WebElement mailinatorEmailInputField;

    public void mailinatorEmailInputFieldSendKeys (String email) {
        wdWait.until(ExpectedConditions.visibilityOf(mailinatorEmailInputField)).clear();
        mailinatorEmailInputField.sendKeys(email);
    }
    public void mailinatorEmailInputFieldSendKeyboardKeys (Keys keyboardButton) {
        wdWait.until( ExpectedConditions.visibilityOf(mailinatorEmailInputField)).sendKeys(keyboardButton);
    }           //ovo nam je nezavisna metoda koja lupa enter

}
