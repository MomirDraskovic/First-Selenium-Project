package HaloOglasi.Page;

import HaloOglasi.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageHaloOglasi extends BaseTest {
    public HomePageHaloOglasi(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Uloguj se")
    WebElement ulogujSeButton;

    public void setUlogujSeButton(){
        wdWait.until(ExpectedConditions.visibilityOf(ulogujSeButton)).click();
    }
}
