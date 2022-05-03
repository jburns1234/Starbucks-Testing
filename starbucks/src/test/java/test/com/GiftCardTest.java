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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Message;
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

    private static GiftCard giftCard;
    private static ArrayList<GiftCard> giftCardContent = new ArrayList<GiftCard>();

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

        FileInputStream inputStream = new FileInputStream(new File("C:\\Data\\project.xlsx"));
        Workbook ourproject = new XSSFWorkbook(inputStream);
        Sheet firstSheet = ourproject.getSheetAt(0);

        for (int i = 1; i < 6; i++) {
            Row r = firstSheet.getRow(i);
            Cell c = r.getCell(0);
            String RecipientName = c.getStringCellValue();
            c = r.getCell(1);
            String RecipientEmail = c.getStringCellValue();
            c = r.getCell(2);
            String SendersName = c.getStringCellValue();
            c = r.getCell(3);
            String SendersEmail = c.getStringCellValue();
            c = r.getCell(4);
            String Message = c.getStringCellValue();
            c = r.getCell(5);

            giftCard = new GiftCard(RecipientName, RecipientEmail, SendersName, SendersEmail, Message);
            giftCardContent.add(giftCard);

        }

        inputStream.close();
        System.setProperty("webdriver.chrome.driver", "C:\\Data\\chromedriver.exe");
        driver = new ChromeDriver();

        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.starbucks.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id='truste-consent-button']")).click();

        //    driver.findElement(By.xpath("//*[contains(text(),'GIFT CARDS')]"));
        //  driver.findElement(webdriver.By.xpath("//div('Gift Cards')"));
        driver.findElement(By.xpath("//*[@id=\"__next\"]/header/nav/div[1]/div/div[2]/div[1]/ul/li[3]/a")).click();
    //    driver.findElement(By.xpath("//*[@data-e2e='dotComHamburgerNavMenuGift']")).click();
        //      driver.findElement(By.xpath("//*[text()='Gift Cards']")).click();

        driver.findElement(By.xpath("//*[@id=\"carousel11\"]/div[2]/div[3]/a")).click();
      //  driver.findElement(By.xpath("//*[@class='block sb-svc-image--image sb-imageFade__imagePositioning sb-imageFade__show']")).click();
        // driver.findElement(By.xpath("//*[@id=\"carousel11\"]/div[2]/div[3]/a")).click();
        WebElement mySelectElement = driver.findElement(By.name("amount"));
        Select amount = new Select(mySelectElement);
        Thread.sleep(1000);
        amount.selectByVisibleText("$100");
        Thread.sleep(1000);
        for (int i = 0; i < 5; i++) {
            driver.findElement(By.id("recipientName")).clear();
            driver.findElement(By.id("recipientName")).sendKeys(giftCardContent.get(i).getRecipientName());
            Thread.sleep(2000);
            driver.findElement(By.id("recipientEmail")).clear();
            driver.findElement(By.id("recipientEmail")).sendKeys(giftCardContent.get(i).getRecipientEmail());
            Thread.sleep(2000);
            driver.findElement(By.id("senderName")).click();
            driver.findElement(By.id("senderName")).clear();
            driver.findElement(By.id("senderName")).sendKeys(giftCardContent.get(i).getSendersName());
            Thread.sleep(2000);
            driver.findElement(By.id("senderEmail")).clear();
            driver.findElement(By.id("senderEmail")).clear();
            Thread.sleep(1000);
            driver.findElement(By.id("senderEmail")).sendKeys(giftCardContent.get(i).getSendersEmail());
            Thread.sleep(2000);
            driver.findElement(By.id("messageCounter")).click();
            driver.findElement(By.id("message")).clear();
            driver.findElement(By.id("message")).sendKeys(giftCardContent.get(i).getMessage());
            Thread.sleep(2000);
        }
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(text(), 'Continue as guest')]")).click();
        driver.findElement(By.xpath("//*[@data-e2e='sendGift']")).click();

    }
}
