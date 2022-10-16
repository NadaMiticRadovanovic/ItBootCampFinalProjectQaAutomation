package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Homepage {
    private WebDriver driver;
    public void url() {
        System.out.println("Ovo se izvrsava pre pokretanja test metode");
        System.setProperty("webdriver.chrome.driver",
                PropertiesReader.getInstance().getValue("WEBDRIVER.CHROMEDRIVER"));
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
    }

    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }





}
