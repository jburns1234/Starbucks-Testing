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

/**
 *
 * @author Daivat Pandya
 */
public class LoginTest {

    private WebDriver driver;
    private String baseUrl;

    public LoginTest() {
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
    public void testLogin() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c://data//chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.starbucks.com/");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.xpath("//main[@id='content']/div[2]/div/div/form/div[2]/div/label")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("josephburns60173@gmail.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("JosephBurns60173@");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Error:'])[2]/following::*[name()='svg'][1]")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//div[@id='137-77815']/div/div/div[2]/div/h1")).click();
        assertEquals("Sign up for Starbucks® Rewards", driver.findElement(By.xpath("//div[@id='137-77815']/div/div/div[2]/div/h1/span/strong")).getText());
    }
}
