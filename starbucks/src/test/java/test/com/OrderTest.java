/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test.com;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Daivat Pandya
 */
public class OrderTest {

    private WebDriver driver;
    private String baseUrl;

    public OrderTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testIndeedSearch() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.starbucks.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        /*
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div[3]/div/div[2]/div[1]/form/fieldset/div[4]/label/div")));
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div[3]/div/div[2]/div[1]/form/fieldset/div[4]/label/div")));

        */

        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.findElement(By.id("truste-consent-button")).click();
        driver.findElement(By.xpath("//*[@class='sb-globalNav__desktopLink md-py5 lg-py6 inline-block text-noUnderline text-xxs text-upper text-bold ']")).click();
        driver.findElement(By.linkText("Hot Coffees")).click();
        js.executeScript("window.scrollTo(0,250)");
        driver.findElement(By.linkText("Caffè Americano")).click();
        WebElement element = driver.findElement(By.xpath("//*[@class='sb-heading text-md headingBorder___2qNNi px2 pb2 mb5 text-semibold']"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath("//*[@class='cursor-pointer mx4 my2 venti-hot___2MA5P sizeImage___1Dy_a']")).click();
        driver.findElement(By.xpath("//*[@data-e2e='option-Flavors']")).click();
        driver.findElement(By.xpath("//*[@aria-label='Increase amount of Hazelnut Syrup to 1.']")).click();
        for (int i = 6; i < 16; i++) {
            String s = "//*[@aria-label='Increase amount of Hazelnut Syrup to " + i + ".']";
            driver.findElement(By.xpath(s)).click();
        }
        driver.findElement(By.xpath("//*[@aria-label='Increase amount of Caramel Syrup to 1.']")).click();
        driver.findElement(By.xpath("//*[@aria-label='Increase amount of Peppermint Syrup to 1.']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@data-e2e='doneFrap']")).click();
        driver.findElement(By.xpath("//*[@data-e2e='add-to-order-button']")).click();
        driver.findElement(By.xpath("//*[@data-e2e='cart-order-count']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Select Store')]")).click();
        driver.findElement(By.name("place")).click();
        driver.findElement(By.name("place")).sendKeys("60173");
        driver.findElement(By.xpath("//*[@data-e2e='submitSearchTermButton']")).click();
        driver.findElement(By.xpath("//*[@data-e2e='confirmStoreButton']")).click();
        driver.findElement(By.xpath("//*[@data-e2e='continueFrap']")).click();
        driver.findElement(By.xpath("//*[@data-e2e='signInButton']")).click();
        driver.findElement(By.xpath("//*[@class='valign-middle block option__labelIcon']")).click();
        driver.findElement(By.id("username")).clear();
        /*driver.findElement(By.id("username")).sendKeys("josephburns60173@gmail.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("JosephBurns60173@");
        driver.findElement(By.xpath("//*[@type='submit']")).click();*/
    }
}
