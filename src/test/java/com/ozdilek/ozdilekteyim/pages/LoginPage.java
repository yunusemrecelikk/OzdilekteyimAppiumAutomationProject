package com.ozdilek.ozdilekteyim.pages;

import com.ozdilek.ozdilekteyim.driver.BaseTest;
import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest {


    @Step("Insert <email> and <password> to login information")
    public void insertLoginInformation(String email, String password) {
        try {
            waitUntilElementToBeClickable(By.id(Locators.LOGINPAGE.getLocator()));
            appiumDriver.findElement(By.id(Locators.INSERT_EMAIL.getLocator())).sendKeys(email);
            appiumDriver.findElement(By.id(Locators.INSERT_PASSWORD.getLocator())).sendKeys(password);
            logger.info("Successfully inserted login information");
        } catch (Exception e) {
            logger.info("Failed to insert login information");
            e.printStackTrace();
        }
    }

    @Step("Go Back Twice")
    public void goBackTwice() {
        try {
            appiumDriver.navigate().back();
            logger.info("Successfully clicked navigate back button");
            waitUntilElementToBeClickable(By.id(Locators.PRODUCTNAME.getLocator()));
            String text = appiumDriver.findElement(By.id(Locators.PRODUCTNAME.getLocator())).getText();
            Assertions.assertEquals(ProductDetails.productName, text, "Product name is not same as the one chosen for add to favorites");
            logger.info("Successfully checked product name to click navigate back button again");
            appiumDriver.navigate().back();
            logger.info("Successfully clicked navigate back button");
        } catch (Exception e) {
            logger.info("Failed to click navigate back button twice");
            e.printStackTrace();
        }
    }
}
