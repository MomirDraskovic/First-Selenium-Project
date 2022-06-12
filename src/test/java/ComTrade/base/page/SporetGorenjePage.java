package ComTrade.base.page;

import ComTrade.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SporetGorenjePage extends BaseTest {

    public SporetGorenjePage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[contains(text(), 'Boja aparata')]")
    WebElement bojaAparata;

    public boolean bojaAparataDisplayed(){
        wdWait.until(ExpectedConditions.visibilityOf(bojaAparata));
        return  bojaAparata.isDisplayed();
    }

    public String bojaAparataAssert(){
        wdWait.until(ExpectedConditions.visibilityOf(bojaAparata));
        return bojaAparata.getText();
    }
}
