package Page;

import HaloOglasi.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserPageHaloOglasi extends BaseTest {

    public  UserPageHaloOglasi() {
        PageFactory.initElements(driver, this );
    }
   @FindBy (className = "header-label")
   WebElement myProfileDropdown;

    @FindBy  (xpath= "(//p[@class='user-display-name'])[1]")
    WebElement userName;
    @FindBy(xpath = "(//p[@class='user-email'])[1]")
    WebElement userEmail;

    public void myProfileDropdownHover(){
        wdWait.until(ExpectedConditions.elementToBeClickable(myProfileDropdown));
        actions.moveToElement(myProfileDropdown).perform();
    }

    public boolean userNameIsDisplayed(){
        wdWait.until(ExpectedConditions.visibilityOf(userName));
        return userName.isDisplayed();
    }

    public String userNameGetText(){
        wdWait.until(ExpectedConditions.visibilityOf(userName));
        return userName.getText();
    }
    public boolean userEmailIsDisplayed(){
        wdWait.until(ExpectedConditions.visibilityOf(userEmail));
        return userEmail.isDisplayed();
    }
    public String userEmailGetText(){
        wdWait.until(ExpectedConditions.visibilityOf(userEmail));
        return userEmail.getText();
    }

}
