package project.tests;

import org.bouncycastle.mail.smime.examples.SendSignedAndEncryptedMail;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import project.Homepage;
import project.LogIn;
import project.PropertiesReader;
import project.Registration;

import java.time.Duration;

public class TestLogIn {
    private Homepage homepage;
    private WebDriver driver;
    private LogIn logIn;
    private Registration registration;


    @Test
    void urlLoading() {
        homepage.url();
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites";
        Assert.assertEquals(ExpectedTitle, ActualTitle);

    }

    @BeforeMethod
    public void configure() {
        System.out.println("Ovo se izvrsava pre pokretanja test metode");
        System.setProperty("webdriver.chrome.driver",
                PropertiesReader.getInstance().getValue("WEBDRIVER.CHROMEDRIVER"));
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        homepage = new Homepage(driver);

        logIn = new LogIn(driver);
        registration = new Registration(driver);}

        @DataProvider(name = "incorrectUserEmailAndPassword")
        public Object[][] createData1() {

            return new Object[][]{
                    {"maliprinc@yahoo.com", "123_pPv"},
                    {"sugibugi@gmail.com", "123_pPv"},
                    {"miskopepa@yahoo.com", "123_pPv"},
                    {"pepaprase@gmail.com", "123_pPv"},
            };




        }

    @Test
    void successfullyLogInWithExistingCredentials() {

        logIn.existingAccount("miticnada87@yahoo.com", "Neronero123");
        Assert.assertEquals("Welcome, Nada Mitic!","Welcome, Nada Mitic!");

    }
    @Test(dataProvider = "incorrectUserEmailAndPassword")
    void unsuccessfullyLogInWithInvalidCredentials(String incorectUserEmail,String password) {
       logIn.clickOnSignInButton();
       logIn.inputEmail(incorectUserEmail);
       logIn.inputPassword(password);
       logIn.clickSignUpButton();
       Assert.assertEquals("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.","The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.", "Credentials are incorrect");
    }
    @Test
    void succesfullSignOut(){
        logIn.existingAccount("miticnada87@yahoo.com", "Neronero123");
        Assert.assertEquals("Welcome, Nada Mitic!","Welcome, Nada Mitic!");

        registration.signOut();
    }
}
