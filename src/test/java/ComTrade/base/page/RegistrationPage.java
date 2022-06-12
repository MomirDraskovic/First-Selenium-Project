package ComTrade.base.page;

import ComTrade.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BaseTest {

    public RegistrationPage() {
        PageFactory.initElements(driver, this);  //ova metoda Page.Factory.initElements, ona trazi @FindBy anotacije  i od njih pravi web elemente
    }

    //ovo se zove repozitorijum svih nasih WebElemenata, jer au ro wlwmwnri koji nam trebaju

    @FindBy(id = "firstname")
    WebElement imeInputField; //bitno je da bude deskriptivno, ako je input polje,stavimo prvo ime pa sta je, znaci ime pa input field
    @FindBy (id = "lastname")
    WebElement prezimeInputField;
    @FindBy(id="is_subscribed") //checkbox je interesantan jer je checkbox a ne input field
    WebElement newsLetterCheckbox;
    @FindBy(css = ".button.btn")
    WebElement posaljiButton;
    @FindBy(id ="email_address")
    WebElement emailInputField;
    @FindBy(id = "password")
    WebElement passswordInputField;
    @FindBy(id="confirmation")
    WebElement confirmPasswordInputField;
    @FindBy(css = ".alert-warning")
    WebElement alertMessage;
    @FindBy (css= ".am-opener")
    WebElement sviProizvodi;
    @FindBy (css = ".img-info.pos-9")
    WebElement belaTehnika;
    @FindBy (linkText = "Šporeti")
    WebElement sporeti;
    @FindBy (xpath = "//button[text() = 'Prihvatam']")
    WebElement prihvatam;
    public void imeInputFieldSendKeys(String ime) { //String ime je stavljeno u parametrima kako bi metoda zahtevala od nas da popunimo ime
        wdWait.until(ExpectedConditions.visibilityOf(imeInputField)).clear();
        imeInputField.sendKeys(ime); //da ne bi hardokodovali ,ovde smo stavili ime,jer gornji parametri (String ime) od nas to zahtevaju
    }
    public void prezimeInputFieldSendKeys(String prezime) {
        wdWait.until(ExpectedConditions.visibilityOf(prezimeInputField)).clear();
        prezimeInputField.sendKeys(prezime);
    }
    public void posaljiButtonCLick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(posaljiButton)).click(); //evo je metoda koja ce da nam klikce i upisuje
    }
    public void emailInputFieldSendKeys (String email){
        wdWait.until(ExpectedConditions.elementToBeClickable(emailInputField)).clear();
        emailInputField.sendKeys(email);
    }
    public void newsLetterCheckboxAlwaysUnchecked() {
        wdWait.until(ExpectedConditions.elementToBeClickable(newsLetterCheckbox));
        if(newsLetterCheckbox.isSelected())
            newsLetterCheckbox.click();
    }
    public void passswordInputFieldSendKeys(String password){
        wdWait.until(ExpectedConditions.elementToBeClickable(passswordInputField)).clear();
        passswordInputField.sendKeys(password);
    }
    public void confirmPasswordInputFieldSendKeys (String password){
        wdWait.until(ExpectedConditions.elementToBeClickable(confirmPasswordInputField)).clear();
        confirmPasswordInputField.sendKeys(password);
    }

    public boolean alertMessageIsDisplayed(){  //metoda koja proverava da li je prikazana poruka, mora da ima boolean
        wdWait.until(ExpectedConditions.visibilityOf(alertMessage));
       return alertMessage.isDisplayed();          //metoda isDisplayed vraca true ili false, medjutim,
                                                    // ispred mora da ima return
                                                    //ovaj je uvek isti, dok metoda ispod nije
    }

    public String AlertMessageGetText() { //Metoda mora da ima String ispred zbog teksta
        wdWait.until(ExpectedConditions.visibilityOf(alertMessage));
        return alertMessage.getText(); //Metoda alertMessage.getText() mora da ima return
    }
    public void SviProizvodiHover(){
        wdWait.until(ExpectedConditions.elementToBeClickable(sviProizvodi));
        actions.moveToElement(sviProizvodi).perform();
    }
    public void clickToSviProizvodi(){
        wdWait.until(ExpectedConditions.elementToBeClickable(sviProizvodi));
        actions.moveToElement(sviProizvodi).click();
    }
    public void ButtonPrihvatamClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(prihvatam)).click();
    }
    public void belaTehnikaHover(){
        wdWait.until(ExpectedConditions.elementToBeClickable(belaTehnika));
        actions.moveToElement((belaTehnika)).perform();
    }
    public void sporetiClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(sporeti)).click();
    }
}
