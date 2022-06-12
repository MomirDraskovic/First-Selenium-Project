package HaloOglasi.Page;

import HaloOglasi.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SuccessfulRegistrationPageHaloOglasi extends BaseTest {

    public SuccessfulRegistrationPageHaloOglasi(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='regsitration-success']")
    WebElement successfullRegistrationMessage;

    @FindBy (linkText = "Prijava")
    WebElement prijavaLink;

    public boolean successfullRegistrationMessageIsDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(successfullRegistrationMessage));
        return successfullRegistrationMessage.isDisplayed();
    }

    public String successfullRegistrationMessageGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(successfullRegistrationMessage));
        return successfullRegistrationMessage.getText();
    }
    public void prijavaLinkClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(prijavaLink)).click();
    }
    //metoda koja switch-uje sa jedno na drugi tab
    //sacekali smo da broj tabova bude 2
    //43. red ,kod wdWait-a, nije lista u pitanju, brojanje krece od jedinice
    //44. red , napravili smo promenljivu tipa lista,u nju smo spakovali sve tabove
    //getWindowHandles je metoda koja broji tabove
    // 45. red svitchuj mi se na tab broj 2 (posto pocinje da broji od 0)
    public void switchToNewTab(int tabNumber,int tab) {
        wdWait.until(ExpectedConditions.numberOfWindowsToBe(tabNumber));
        ArrayList<String> numberOfTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(numberOfTabs.get(tab));
    }
}
