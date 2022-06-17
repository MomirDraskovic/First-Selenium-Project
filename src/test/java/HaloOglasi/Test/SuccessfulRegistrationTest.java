package HaloOglasi.Test;

import HaloOglasi.Page.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;

import java.util.Random;

public class SuccessfulRegistrationTest extends HaloOglasi.BaseTest {

    HomePageHaloOglasi homePageHaloOglasi;
    LoginPageHaloOglasi loginPageHaloOglasi;
    RegistrationPageHaloOglasi registrationPageHaloOglasi;
    SuccessfulRegistrationPageHaloOglasi successfulRegistrationPageHaloOglasi;
    HomePageMailinator homePageMailinator;
    InboxPageMailinator inboxPageMailinator;
    HaloOglasiEmailPageMailinator haloOglasiEmailPageMailinator;
    UserPageHaloOglasi userPageHaloOglasi;


    Random random = new Random();
    String testIme = "TestTest" + random.nextInt(999999);
    String testEmail = testIme + "@mailinator.com";
    String successfulRegistrationMessage = "Registracija je uspela!\n" +
            "Kako bi Vaš nalog postao aktivan, neophodno je da kliknite na link u mejlu koji Vam je poslat na : ";
    String successfulActivationMessage = "Vaš nalog je uspešno aktiviran!\n" +
            "Produžite na stranicu za logovanje kako biste pristupili našem portalu. Prijava";
    String mailnatorUrl = "https://www.mailinator.com/";
    String email = "email: ";
    String exclamationPoint = " !";

    @Before
    public void setUpTest(){
        homePageHaloOglasi = new HomePageHaloOglasi();
        loginPageHaloOglasi = new LoginPageHaloOglasi();
        registrationPageHaloOglasi = new RegistrationPageHaloOglasi();
        successfulRegistrationPageHaloOglasi = new SuccessfulRegistrationPageHaloOglasi();
        homePageMailinator = new HomePageMailinator();
        inboxPageMailinator = new InboxPageMailinator();
        haloOglasiEmailPageMailinator = new HaloOglasiEmailPageMailinator();
        userPageHaloOglasi= new UserPageHaloOglasi();
    }

    @Test
    public void successfulRegistrationTest(){
        // Otvaramo halo oglasi stranicu
        // -> Otisli smo na halo oglasi stranicu u BaseTest klasi
        //klikcemo na uloguj se dugme
        homePageHaloOglasi.setUlogujSeButton();
        //idemo na registruj se link
        loginPageHaloOglasi.registrujSeLinkClick();
        // proveravamo da li je fizicko lice stiklirano, ako nije stikliramo ga, ako jeste ne radimo nista
        registrationPageHaloOglasi.radioButtonFizickoLiceAlwaysSelected();
        //Popunjavamo celu formu
        registrationPageHaloOglasi.userNameInputFieldSendKeys(testIme);        //promena korisnickog imena prilikom pokretanja
        registrationPageHaloOglasi.emailAddressSendKeys(testEmail);     //promena maila prilikom pokretanja na 30oj i 37 liniji!
        registrationPageHaloOglasi.passwordInputFieldSendKeys(testIme);
        registrationPageHaloOglasi.confirmationPassSendKeys(testIme);
        registrationPageHaloOglasi.subscriptionForFiscalReceiptByEmailClick();
        //Klikcemo na registruj me dugme
        registrationPageHaloOglasi.registrationButtonClick();
        //proveravamo poruku (asertujemo)
        Assert.assertTrue(successfulRegistrationPageHaloOglasi.successfullRegistrationMessageIsDisplayed ());
        Assert.assertEquals( successfulRegistrationMessage + testEmail + exclamationPoint,
                successfulRegistrationPageHaloOglasi.successfullRegistrationMessageGetText());
       //odlazimo na mailinator stranicu
        driver.get(mailnatorUrl);
        //upisujemo u public inbox mail adresu koju smo iskoristili u halo oglasima stranici
        homePageMailinator.mailinatorEmailInputFieldSendKeys(testIme);
        homePageMailinator.mailinatorEmailInputFieldSendKeyboardKeys(Keys.ENTER);
        //otvaramo taj mail ,klikcemo aktiviraj nalog
        inboxPageMailinator.haloOglasiAktivirajNalogEmailClick();
        haloOglasiEmailPageMailinator.driverSwitchFocusToIframeBody();
        haloOglasiEmailPageMailinator.aktivirajNalogButtonClick();
        //provaravamo poruku koja nam se pojavila
        successfulRegistrationPageHaloOglasi.switchToNewTab(2,1); //koliko tabova da ocekujemo,i na koji tab da ode.
        Assert.assertTrue(successfulRegistrationPageHaloOglasi.successfullRegistrationMessageIsDisplayed());
       Assert.assertEquals(successfulActivationMessage,successfulRegistrationPageHaloOglasi.successfullRegistrationMessageGetText());
        //klikcemo na prijava link koji se nalazi u samoj poruci
        successfulRegistrationPageHaloOglasi.prijavaLinkClick();
        //popunjavanje mail koji ste koristili za registraciju i password
        loginPageHaloOglasi.emailIliKorisnickoImeInputFieldSendKeys(testIme);
        registrationPageHaloOglasi.passwordInputFieldSendKeys(testIme);
       //klikcemo na uloguj me dugme
        loginPageHaloOglasi.logInButtonClick();
        // proberimo da li gore stoji nase ime i email adresa kada se ulogujemo
        userPageHaloOglasi.myProfileDropdownHover();
        Assert.assertTrue(userPageHaloOglasi.userNameIsDisplayed());
        Assert.assertEquals(testIme,userPageHaloOglasi.userNameGetText());
        Assert.assertTrue(userPageHaloOglasi.userEmailIsDisplayed());
        Assert.assertEquals(email + testEmail, userPageHaloOglasi.userEmailGetText());

    }
}
