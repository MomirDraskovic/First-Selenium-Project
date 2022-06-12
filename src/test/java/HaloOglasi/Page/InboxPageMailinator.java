package HaloOglasi.Page;

import HaloOglasi.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InboxPageMailinator extends BaseTest {
    public InboxPageMailinator() {
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//td[@class=\"ng-binding\"][contains (text(),'aktivirajte Vaš Halo oglasi nalog')]")
    WebElement haloOglasiAktivirajNalogEmail;

    public void haloOglasiAktivirajNalogEmailClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(haloOglasiAktivirajNalogEmail)).click();
    }

}
