/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test.com;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        baseUrl = "https://www.google.com/";
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        JavascriptExecutor js =(JavascriptExecutor) driver;
        
        driver.manage().window().maximize();
        driver.get("https://www.starbucks.com/");
        driver.findElement(By.id("truste-consent-button")).click();
        //driver.findElement(By.xpath("//*[@id=\"__next\"]/header/nav/div[1]/div/div[2]/div[1]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@class='sb-globalNav__desktopLink md-py5 lg-py6 inline-block text-noUnderline text-xxs text-upper text-bold ']")).click();
        driver.findElement(By.linkText("Hot Coffees")).click();
        js.executeScript("window.scrollTo(0,250)");
        driver.findElement(By.linkText("Caffè Americano")).click();
        WebElement Element = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div[2]/div[1]/h2"));
        js.executeScript("arguments[0].scrollIntoView();",Element);
        driver.findElement(By.xpath("//*[@class='cursor-pointer mx4 my2 venti-hot___2MA5P sizeImage___1Dy_a']")).click();
        driver.findElement(By.xpath("//*[@data-e2e='option-Flavors']")).click();
    }
}
