/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
// Author Gabriel Muntean
package test.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author m_gab
 */
public class GiftCardTest {

    private WebDriver driver;
    private String baseUrl;
    private GiftCard giftCard;

    public GiftCardTest() {
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
    @Test

    public void testGiftCard() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Data\\chromedriver.exe");
        driver = new ChromeDriver();

        FileInputStream inputStream = new FileInputStream(new File("C:\\Data\\project.xlsx"));
        Workbook ourproject = new XSSFWorkbook(inputStream);
        Sheet firstSheet = ourproject.getSheetAt(0);

        Row row = firstSheet.getRow(1);
        Cell column = row.getCell(0);
        //    column = row.getCell(0);
        String RecipientName = column.getStringCellValue();

        column = row.getCell(1);
        String RecipientEmail = column.getStringCellValue();

        column = row.getCell(2);
        String SendersName = column.getStringCellValue();

        column = row.getCell(3);
        String SendersEmail = column.getStringCellValue();

        column = row.getCell(4);
        String Message = column.getStringCellValue();

        giftCard = new GiftCard(RecipientName, RecipientEmail, SendersName, SendersEmail, Message);
        System.out.println(giftCard);
        inputStream.close();

        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.starbucks.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id='truste-consent-button']")).click();
        driver.findElement(By.partialLinkText("Gift")).click();	
        //driver.findElement(By.xpath("//*[@data-e2e='dotComHamburgerNavMenuGift']")).click();

        driver.findElement(By.xpath("//*[@id=\"carousel11\"]/div[2]/div[3]/a")).click();
        WebElement mySelectElement = driver.findElement(By.name("amount"));
        Select amount = new Select(mySelectElement);
        Thread.sleep(1000);
        amount.selectByVisibleText("$100");
        Thread.sleep(1000);
        driver.findElement(By.id("recipientName")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("recipientName")).sendKeys(giftCard.getRecipientName());
        driver.findElement(By.id("recipientEmail")).clear();
        driver.findElement(By.id("recipientEmail")).sendKeys(giftCard.getRecipientEmail());
        Thread.sleep(1000);
        driver.findElement(By.id("senderName")).click();
        driver.findElement(By.id("senderName")).clear();
        driver.findElement(By.id("senderName")).sendKeys(giftCard.getSendersName());
        Thread.sleep(1000);
        driver.findElement(By.id("senderEmail")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("senderEmail")).sendKeys(giftCard.getSendersEmail());
        Thread.sleep(1000);
        driver.findElement(By.id("messageCounter")).click();
        driver.findElement(By.id("message")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("message")).sendKeys(giftCard.getMessage());
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//*[@id=\"notifications-target\"]/div[1]/div[1]/div/div[2]/div/div/div/div/p[3]/button')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(text(), 'Continue as guest')]")).click();
        driver.findElement(By.xpath("//*[@data-e2e='sendGift']")).click();
        
    }
}
