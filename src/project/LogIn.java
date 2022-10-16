package project;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class LogIn {
    private WebDriver driver;
    private Registration registration;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    private WebElement signInButton;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "pass")
    private WebElement password;
    @FindBy(id = "send2")
    private WebElement signUpButton;


    public LogIn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this); // ucitaj sve elemente na web stranici
    }

    public void inputEmail(String email) {
        this.email.sendKeys(email);
    }

    public void inputPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickSignUpButton() {
        this.signUpButton.click();

    }
    public void clickOnSignInButton(){
        this.signInButton.click();
    }
    public void accountCreated() {
        registration = new Registration(driver);
        registration.getSinUpLink();
        Faker faker = new Faker();
        String conformationPassword = faker.funnyName().name();
        registration.getSinUpLink();
        registration.enterFirstName(Faker.instance().bothify("????????"));
        registration.enterLastName(Faker.instance().bothify("???????"));
        Actions at = new Actions(driver);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        registration.enterEmail(Faker.instance().bothify("?????####@gmail.com"));

        registration.enterConfPassword(registration.inputPassword(conformationPassword));
        registration.enterCreateAccountButton();

    }


    public void acountCreatedIncorrectData(){
        registration = new Registration(driver);
        registration.getSinUpLink();


    }

    public void existingAccount(String email, String password) {
        this.signInButton.click();
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.signUpButton.click();

    }

    public void LogIn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }







}
