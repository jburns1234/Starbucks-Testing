/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itexps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Daivat Pandya
 */
public class LoginPage {
     WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = ".//*[@type='submit']")
    private WebElement submitBtn;

    public void loginToStarbucks(String uName, String pWord)
            throws Exception {
        try {
            username.clear();
            username.sendKeys(uName);
            password.clear();
            password.sendKeys(pWord);
            submitBtn.click();
            //   LoginPage login = new LoginPage(driver);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
