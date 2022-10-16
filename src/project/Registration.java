package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration {
    private WebDriver driver;
    @FindBy(xpath = "//header/div[1]/div[1]/ul[1]/li[2]/div[1]/ul[1]/li[3]/a[1]")
    private  WebElement signOutButton;
    @FindBy(xpath = "//header/div[1]/div[1]/ul[1]/li[2]/span[1]/button[1]")
    private WebElement arrowButtonDropdown;
    @FindBy(xpath = "//header/div[1]/div[1]/ul[1]/li[3]/a[1]")
    private WebElement signInLink;
    @FindBy(id = "firstname")
    private WebElement firstName;
    @FindBy(id = "lastname")
    private WebElement lastName;
    @FindBy(id = "email_address")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "password-confirmation")
    private WebElement confrmPass;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]")
    private WebElement createAccountButton;
    public void getSinUpLink () {
        this.signInLink.click();
    }
    public void enterFirstName(String firstName){
        this.firstName.sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        this.lastName.sendKeys(lastName);
    }
    public void enterEmail(String email){
        this.email.sendKeys(email);
    }
    public String inputPassword(String password){
        this.password.sendKeys(password);
        return password;
    }
    public void enterConfPassword(String confPass){
        this.confrmPass.sendKeys(confPass);
    }
    public void enterCreateAccountButton (){
        this.createAccountButton.click();
    }
    public void signOut(){
        this.arrowButtonDropdown.click();
        this.signOutButton.click();


    }
    public Registration(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

}

