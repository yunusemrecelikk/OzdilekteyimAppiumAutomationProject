package com.ozdilek.ozdilekteyim.pages;

import com.ozdilek.ozdilekteyim.driver.BaseTest;
import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class HomePage extends BaseTest {

    @Step("Checks if application did open successfully")
    public void checkHomePage() {
        try {
            waitUntilElementToBeClickable(By.id(Locators.HOMEPAGE_CHECK.getLocator()));
            boolean isDisplayed = appiumDriver.findElement(By.id(Locators.HOMEPAGE_CHECK.getLocator())).isDisplayed();
            if (isDisplayed) {
                String text = appiumDriver.findElement(By.id(Locators.ALISVERISE_BASLA.getLocator())).getText();
                Assertions.assertEquals("ALIŞVERİŞE BAŞLA", text, "Homepage did not opened successfully");
                logger.info("Homepage opened successfully");
            }
        } catch (Exception e) {
            logger.info("Failed at checking if application did open successfully");
            e.printStackTrace();
        }
    }

    @Step("Click Alisverise Basla")
    public void clickAlisveriseBasla() {
        try {
            appiumDriver.findElement(By.id(Locators.ALISVERISE_BASLA.getLocator())).click();
            logger.info("Clicked Alisverise Basla");
        } catch (Exception e) {
            logger.info("Failed to click Alisverise Basla");
            e.printStackTrace();
        }
    }

    @Step("Check is shopping page visible")
    public void checkShoppingPage() {
        try {
            waitUntilElementToBeClickable(By.xpath(Locators.SHOPPINGPAGE_CHECK.getLocator()));
            String text = appiumDriver.findElement(By.xpath(Locators.SHOPPINGPAGE_CHECK.getLocator())).getText();
            Assertions.assertEquals("Ev Tekstili",text,"Shopping page failed to open");
            logger.info("Shopping page is visible");
        } catch (Exception e) {
            logger.info("Failed to check if shopping page is visible");
            e.printStackTrace();
        }
    }

}
