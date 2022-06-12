package ComTrade.base.page;

import ComTrade.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FilterGorenjePage extends BaseTest {

    public FilterGorenjePage () {
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//label[text()='Gorenje']")
    WebElement gorenjeFilter;
    @FindBy (xpath = "//a[starts-with(@title, 'K5111SG')]")
    WebElement K5111SGSporet;
    @FindBy (linkText = "Poništi sve filtere")
    WebElement ponistiSveFiltere;
    @FindBy (xpath = "//label[text()='Beko']")
    WebElement bekoFilter;
    @FindBy (xpath = "//a[starts-with(@title,'FSS54010DW')]")
    WebElement sporetBekoFSS54010DW;

    public void filterGorenjeHover () {
        wdWait.until(ExpectedConditions.visibilityOf(gorenjeFilter));
        actions.moveToElement(gorenjeFilter).perform();
    }
    public void filterGorenjeClick () {
        wdWait.until(ExpectedConditions.elementToBeClickable(gorenjeFilter)).click();
    }
    public void K5111SGSporetHover(){
        wdWait.until(ExpectedConditions.visibilityOf(K5111SGSporet));
        actions.moveToElement(K5111SGSporet).perform();
    }
    public void K5111SGSporetClick() {
        wdWait.until(ExpectedConditions.visibilityOf(K5111SGSporet)).click();
    }
    public void ponistiSveFiltereClick(){
        wdWait.until(ExpectedConditions.visibilityOf(ponistiSveFiltere)).click();
    }
    public void bekoFilterHover(){
        wdWait.until(ExpectedConditions.visibilityOf(bekoFilter));
        actions.moveToElement(bekoFilter).perform();
    }
    public void bekoFilterClick(){
        wdWait.until(ExpectedConditions.visibilityOf(bekoFilter)).click();
    }

    public void sporetBekoFSS54010DWHover(){
        wdWait.until(ExpectedConditions.visibilityOf(sporetBekoFSS54010DW));
        actions.moveToElement(sporetBekoFSS54010DW).perform();
    }
    public void sporetBekoFSS54010DWClick(){
        wdWait.until(ExpectedConditions.visibilityOf(sporetBekoFSS54010DW)).click();
    }
}
