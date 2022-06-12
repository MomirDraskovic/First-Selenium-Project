package Page;

import HaloOglasi.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HaloOglasiEmailPageMailinator extends BaseTest {
    public HaloOglasiEmailPageMailinator() {
        PageFactory.initElements(driver,this);
    }
    @FindBy (linkText = "Aktiviraj nalog")
    WebElement aktivirajNalogButton;
    @FindBy (id = "html_msg_body")
    WebElement iframeBody;

    public void aktivirajNalogButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(aktivirajNalogButton)).click();
    }

    //najelegantniji nacin menjanja sa HTML na neki drugi format (iframe u ovom slucaju)
    public void switchFocusToIframeBody(){
        wdWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeBody));
    }
    //drugi nacin switchovanja
    public void driverSwitchFocusToIframeBody(){
        wdWait.until(ExpectedConditions.visibilityOf(iframeBody));
        driver.switchTo().frame(iframeBody);
    }
    //u cilju vracanja iframe-a na defaultni (HTML) content
    public void switchFocusToDefaultContent(){
        driver.switchTo().defaultContent();
    }
}
