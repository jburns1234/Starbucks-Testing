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
public class FlavorsTest2 {

    private WebDriver driver;
    private String baseUrl;

    public FlavorsTest2() {
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
    public void testFlavors2() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.starbucks.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;

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
        driver.findElement(By.xpath("//*[@aria-label='Increase amount of Caramel Syrup to 1.']")).click();
        driver.findElement(By.xpath("//*[@aria-label='Increase amount of Brown Sugar Syrup to 1.']")).click();
        driver.findElement(By.xpath("//*[@aria-label='Increase amount of Cinnamon Dolce Syrup to 1.']")).click();
        driver.findElement(By.xpath("//*[@aria-label='Increase amount of Raspberry Syrup to 1.']")).click();
        driver.findElement(By.xpath("//*[@aria-label='Increase amount of Toasted Vanilla Syrup to 1.']")).click();
        driver.findElement(By.xpath("//*[@aria-label='Increase amount of Toffee Nut Syrup to 1.']")).click();
        driver.findElement(By.xpath("//*[@aria-label='Increase amount of Vanilla Syrup to 1.']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@data-e2e='doneFrap']")).click();
        driver.findElement(By.xpath("//*[@data-e2e='add-to-order-button']")).click();
        driver.findElement(By.xpath("//*[@data-e2e='cart-order-count']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Select Store')]")).click();
        driver.findElement(By.name("place")).click();
        driver.findElement(By.name("place")).sendKeys("60173");
        driver.findElement(By.xpath("//*[@data-e2e='submitSearchTermButton']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@data-e2e='confirmStoreButton']")).click();
        
    }
    
}
