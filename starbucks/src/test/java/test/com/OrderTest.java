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
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        /*driver.get("https://www.starbucks.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("truste-consent-button")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Find a store'])[1]//*[name()='svg'][1]")).click();
        driver.findElement(By.name("place")).click();
        driver.findElement(By.name("place")).clear();
        driver.findElement(By.name("place")).sendKeys("60173");
        driver.findElement(By.cssSelector(".form___KRAyD")).submit();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/section/div[1]/div/article[1]/button")).click();
        driver.findElement(By.xpath("//main[@id='content']/div[2]/section/div[2]/div/div/div/div/button")).click();
        //driver.findElement(By.xpath("//div[@id='js-content']/div/div[4]/div[3]/div/div[2]/div/div/button")).click();
        //driver.findElement(By.xpath("//section[@id='drinks']/div/div[5]/div/a")).click();
        //driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/h1")).click();
        //driver.findElement(By.xpath("//span[contains(@class,'color-textWhiteSoft text-xxs block')]")).click();
        //driver.findElement(By.xpath("//*[@id=\"drinks\"]/div/div[5]/div/a")).click();
        driver.findElement(By.linkText("Cold Coffees")).click();
        driver.findElement(By.linkText("Starbucks® Cold Brew Coffee with Milk")).click();
        driver.findElement(By.xpath("//main[@id='content']/div[3]/div/div[2]/div/form/fieldset/div[3]/label/div")).click();
        driver.findElement(By.xpath("//main[@id='content']/div[3]/div/div[2]/div[2]/div/div/div/div/button")).click();
        driver.findElement(By.id("milk-options-customization-option")).click();
        new Select(driver.findElement(By.id("milk-options-customization-option"))).selectByVisibleText("Whole Milk");
        driver.findElement(By.xpath("//div[@id='modal-target']/div/div[2]/div[2]/div/div[2]/div/div[3]/div/div/div/button")).click();
         */
        driver.get("https://www.starbucks.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("truste-consent-button")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/header/nav/div[1]/div/div[2]/div[1]/ul/li[1]/a")).click();
        //driver.findElement(By.linkText("Cold Coffees")).click();
        driver.findElement(By.linkText("Caffè Americano")).click();
        driver.findElement(By.xpath("//main[@id='content']/div[3]/div/div/div/div/div/div/button")).click();
    }
}
