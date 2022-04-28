/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
    private static ArrayList<Login> loginList = new ArrayList<Login>();
    private static Login logininfo;

    public LoginTest() {
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
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
        FileInputStream inputStream = new FileInputStream(new File("C:\\data\\LoginData.xlsx"));
        Workbook workbook = new XSSFWorkbook(inputStream);
        //getting first worksheet 
        Sheet firstSheet = workbook.getSheetAt(0);
        //get first row 

        for (int i = 1; i < 5; i++) {
            Row r = firstSheet.getRow(i);
            Cell c = r.getCell(0);
            //email value 
            String email = c.getStringCellValue();
            c = r.getCell(1);
            //pass value 
            String password = c.getStringCellValue();

            logininfo = new Login(email, password);
            loginList.add(logininfo);
        }
        inputStream.close();
        
        System.setProperty("webdriver.chrome.driver", "c://data//chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
        driver.get("https://www.starbucks.com/");
        driver.findElement(By.id("truste-consent-button")).click();
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.xpath("//*[@class='valign-middle block option__labelIcon']")).click();
            
        for (int i = 0; i < 4; i++) {
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("username")).sendKeys(loginList.get(i).getEmail());
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys(loginList.get(i).getPassword());
            driver.findElement(By.xpath("//*[@type='submit']")).click();
            Thread.sleep(5000);
        }
        
        driver.findElement(By.xpath("//div[@id='137-77815']/div/div/div[2]/div/h1")).click();
        assertEquals("Sign up for Starbucks® Rewards", driver.findElement(By.xpath("//div[@id='137-77815']/div/div/div[2]/div/h1/span/strong")).getText());
        Thread.sleep(5000);
        driver.close();
    }
}
