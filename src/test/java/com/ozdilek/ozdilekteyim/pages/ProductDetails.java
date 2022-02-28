package com.ozdilek.ozdilekteyim.pages;

import com.ozdilek.ozdilekteyim.driver.BaseTest;
import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class ProductDetails extends BaseTest {

    protected static String productName;

    @Step("Check Product Details")
    public void checkProductDetails() {
        try {
            waitUntilElementToBeClickable(By.id(Locators.PRODUCTCHECK.getLocator()));
            if (appiumDriver.findElement(By.id(Locators.PRODUCTCHECK.getLocator())).isDisplayed()) {
                String text = appiumDriver.findElement(By.id(Locators.PRODUCTCHECK.getLocator())).getText();
                Assertions.assertEquals("Beden:", text, "Product details did not open successfully");
                logger.info("Product details did open successfully");
            }
        } catch (Exception e) {
            logger.info("Failed to open Product Details");
            e.printStackTrace();
        }
    }

    @Step("Save Product Name")
    public void saveProductName() {
        try {
            String text = appiumDriver.findElement(By.id(Locators.PRODUCTNAME.getLocator())).getText();
            productName = text;
            logger.info("Successfully saved product name! ["+ productName);
        } catch (Exception e) {
            logger.info("Failed to save product name");
            e.printStackTrace();
        }
    }

    @Step("Choose Size of Product")
    public void chooseSize() {
        try {
            waitUntilElementToBeClickable(By.xpath(Locators.PRODUCTCHOOSESIZE.getLocator()));
            appiumDriver.findElementByXPath(Locators.PRODUCTCHOOSESIZE.getLocator()).click();
            logger.info("Successfully choose product size");
        } catch (Exception e) {
            logger.info("Failed to choose product size");
            e.printStackTrace();
        }
    }

    @Step("Add to Favorites")
    public void addToFavorites() {
        try {
            appiumDriver.findElement(By.id(Locators.PRODUCTADDFAVORITES.getLocator())).click();
            logger.info("Successfully click add to favorites");
        } catch (Exception e) {
            logger.info("Failed to add to favorites");
            e.printStackTrace();
        }
    }

    @Step("Add to Basket")
    public void addToBasket() {
        try {
            appiumDriver.findElement(By.id(Locators.ADDTOBASKET.getLocator())).click();
            logger.info("Successfully click add to basket");
        } catch (Exception e) {
            logger.info("Failed to click add to basket");
            e.printStackTrace();
        }
    }
}
