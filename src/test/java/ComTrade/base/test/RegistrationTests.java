package ComTrade.base.test;

import ComTrade.base.BaseTest;
import ComTrade.base.page.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class RegistrationTests extends BaseTest {

    RegistrationPage registrationPage;
    KombinovaniSporetiPage kombinovaniSporetiPage;
    FilterGorenjePage filterGorenjePage;
    SporetGorenjePage sporetGorenjePage;
    SporetBekoPage sporetBekoPage;
    ConfirmationPage confirmationPage;
    CommentSectionPage commentSectionPage;
//@Before metode ne smeju isto da se zovu
    @Before
    public void setUpTest()  {  //jako je bitno da se ova metoda ne zove isto kao i u Registration Page, jedan od principa OOP
                                // staticki i dinamicki - moguce je imati dve metode istog naziva koje operisu nad razlicitim tipovima promenljivih
                                 // kada imamo parametre metode u zavisnosti koji par.
                                // prosledjujemo nas program zna koju metodu treba da uzme.- Stat. polimorfizam
                                //da smo ostavili setUp(), to bi bio dinamicki polimorfizam,jer bismo onda pregazili metodu.
                                //posledica - radice @Before iz RegistrationPageTests umesto iz BaseTest sto nije dobro
                                //samim tim nece znati sta je Driver,Driver.Wait itd zato ne smeju isto da se zovu.
        registrationPage = new RegistrationPage();
        kombinovaniSporetiPage = new KombinovaniSporetiPage();
        filterGorenjePage = new FilterGorenjePage();
        sporetGorenjePage = new SporetGorenjePage();
        sporetBekoPage = new SporetBekoPage();
        confirmationPage = new ConfirmationPage();
        commentSectionPage = new CommentSectionPage();
    }
    @Test
    public void successfulTestRegistrationTest() throws InterruptedException {
//          Thread.sleep(4000);
//          WebElement popUpButton = (WebElement) js.executeScript("return document.querySelector('#popup-smart-root-35743').shadowRoot.querySelector('#PsCloseButton')");
        registrationPage.imeInputFieldSendKeys("Momo");
        registrationPage.prezimeInputFieldSendKeys("Draskovic");
        registrationPage.emailInputFieldSendKeys("m111@m12321.com");
        registrationPage.newsLetterCheckboxAlwaysUnchecked();
        registrationPage.passswordInputFieldSendKeys("123456789");
        registrationPage.confirmPasswordInputFieldSendKeys("1234567890");
        registrationPage.posaljiButtonCLick();
        Assert.assertTrue(registrationPage.alertMessageIsDisplayed());
        Assert.assertEquals("Razlikuju se lozinka i potvrda lozinke!",registrationPage.AlertMessageGetText());   //ocekujem da mi to prosledis i proveris sa alertMessage.getTexxt()
    }

    @Test
    public  void unSuccessfulTestRegistrationTest(){
        registrationPage.imeInputFieldSendKeys("Momir");
        registrationPage.prezimeInputFieldSendKeys("Draskovic");
        registrationPage.emailInputFieldSendKeys("m@m12321.com");
        registrationPage.newsLetterCheckboxAlwaysUnchecked();
        registrationPage.passswordInputFieldSendKeys("123456789");
        registrationPage.confirmPasswordInputFieldSendKeys("123456789");
        registrationPage.posaljiButtonCLick();
    }

    @Test
    public void testPredavanje8(){
        driver.get("https://www.ctshop.rs/customer/account/create");
        registrationPage.ButtonPrihvatamClick();
        registrationPage.SviProizvodiHover();
        registrationPage.belaTehnikaHover();
        registrationPage.sporetiClick();
        registrationPage.ButtonPrihvatamClick();
        kombinovaniSporetiPage.kombinovaniSporetiFocus();
        kombinovaniSporetiPage.kombinovaniSporetiClick();
        filterGorenjePage.filterGorenjeHover();
        filterGorenjePage.filterGorenjeClick();
        filterGorenjePage.K5111SGSporetHover();
        filterGorenjePage.K5111SGSporetClick();
        Assert.assertTrue(sporetGorenjePage.bojaAparataDisplayed());
        String bojaAparata = sporetGorenjePage.bojaAparataAssert();
        Assert.assertEquals("Boja aparata: Siva metalik", bojaAparata);
        driver.navigate().back();
        filterGorenjePage.ponistiSveFiltereClick();
        filterGorenjePage.bekoFilterHover();
        filterGorenjePage.bekoFilterClick();
        filterGorenjePage.sporetBekoFSS54010DWHover();
        filterGorenjePage.sporetBekoFSS54010DWClick();
        Assert.assertTrue(sporetBekoPage.cenaPopustDisplay());
        String cenaSaPopustom = sporetBekoPage.cenaPopustAssert();
        Assert.assertEquals("25.579", cenaSaPopustom);
        commentSectionPage.oceneFocus();
        commentSectionPage.oceneClick();
        Assert.assertTrue(commentSectionPage.ekonomicanNaslovDisplay());
        Assert.assertEquals("EKONOMICAN", commentSectionPage.ekonomicanNaslovAssert());
        Assert.assertTrue(commentSectionPage.datumKomentaraDisplay());
        Assert.assertEquals("(28.11.2018)",commentSectionPage.datumKomentaraAssert());
        Assert.assertTrue(commentSectionPage.tekstKomentaraDisplay());
        Assert.assertEquals("Odluka o kupovini ovog sporeta je izmedju ostalog doneta zbog nase velike potrosnje struje, " +
                "sada nam plinske ringle u tome mnogo pomazu. Rerna je dovoljno velika i za gostinsko spremanje a gril koristim u " +
                "kombinaciji sa konvencionalnim pecenjem. Ciscenje rerne je prava pesma obzirom da ima Steam Shine program. " +
                "Sve u svemu PUN POGODAK!",commentSectionPage.tekstKomentaraAssert());
        Assert.assertTrue(commentSectionPage.zoricaKomentarDisplay());
        Assert.assertEquals("Zorica",commentSectionPage.zoricaKomentarAssert());
    }

}




