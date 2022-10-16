package project.tests;

import org.openqa.selenium.WebDriver;
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

public class TestAccountCreated {
    private Homepage homepage;
    private WebDriver driver;
    private LogIn logIn;
    private Registration registration;
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
    @DataProvider(name = "incorrectDataForNewAccount")
    public Object[][] createData() {

        return new Object[][]{
                {"Micko", "Petrovic", "sugibugi@gmail.com", "", ""},
                {"Milica", "Miskovic", "velikiGmaz@.com", "123_pPv", "123_pPv"}, //email inccorect
                {"Radomir", "Tot", "miskopepa@yahoo.com", "123_pPv", ""},
                {"Jelena", "Milutinovic", "pepaprase@gmail.com", "", "123_pPv"},
        };

    }
        @Test void accountCreatedSuccssesfully(){
        logIn.accountCreated();
        Assert.assertEquals("Thank you for registering with Fake Online Clothing Store.","Thank you for registering with Fake Online Clothing Store.");
    }
    @Test (dataProvider = "incorrectDataForNewAccount")
    void accountCreatedUNsuccssesfullyWrongMail(String name,String lastName, String email, String password, String confpass){
        logIn.acountCreatedIncorrectData();



    }


}
