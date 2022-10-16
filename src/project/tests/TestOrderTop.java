package project.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project.OrderTop;
import project.PropertiesReader;

import java.util.Set;

public class TestOrderTop {
    private WebDriver driver;
    // private final static String MODAL_TITLE_EXPECTED ="You need to choose options for your item.";
    private OrderTop orderTop;
    private final String ADD_TO_CART = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[6]/div[1]/div[1]/div[4]/div[1]/div[1]/form[1]/button[1]";

    @BeforeMethod
    public void configure() {
        System.out.println("Ovo se izvrsava pre pokretanja test metode");
        System.setProperty("webdriver.chrome.driver",
                PropertiesReader.getInstance().getValue("WEBDRIVER.CHROMEDRIVER"));
        driver = new ChromeDriver();
        orderTop = new OrderTop(driver);
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void succesfulOrderTopAddCartOnItem() {
        orderTop.getToWomenLink();
        orderTop.scrollToTop("Nona Fitness Tank");
        orderTop.hoverToWomenTop("Nona Fitness Tank");
        Actions at = new Actions(driver);
        at.click();
        at.sendKeys(Keys.PAGE_DOWN).build().perform();

        orderTop.clikOnSize();
        orderTop.addCartOnItem();
        Assert.assertEquals("You need to choose options for your item.", "You need to choose options for your item.");

    }

    @Test
    public void succesfulOrderTopAddCart() {
        orderTop.getToWomenLink();
        orderTop.scrollToTop("Nora Practice Tank ");
        orderTop.hoverToWomenTop("Nora Practice Tank ");
        Actions at = new Actions(driver);
        at.click();
        at.sendKeys(Keys.PAGE_DOWN).build().perform();


        orderTop.clickToAddCartButton();

    }

}
