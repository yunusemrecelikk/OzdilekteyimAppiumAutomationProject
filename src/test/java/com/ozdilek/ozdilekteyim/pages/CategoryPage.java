package com.ozdilek.ozdilekteyim.pages;

import com.ozdilek.ozdilekteyim.driver.BaseTest;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class CategoryPage extends BaseTest {

    @Step("Click category page")
    public void openCategoryPage() {
        try {
            waitUntilElementToBeClickable(By.id(Locators.CATEGORYPAGE.getLocator()));
            if (appiumDriver.findElement(By.id(Locators.CATEGORYPAGE.getLocator())).isDisplayed()) {
                String text = appiumDriver.findElement(By.xpath(Locators.CATEGORY_CHECK.getLocator())).getAttribute("content-desc");
                Assertions.assertEquals("Kategoriler", text, "Category did not open successfully");
                logger.info("Category page did open successfully");
                appiumDriver.findElement(By.id(Locators.CATEGORYPAGE.getLocator())).click();
                logger.info("Clicked category button");
                waitUntilElementToBeClickable(By.xpath(Locators.KADIN_CATEGORY_SELECT.getLocator()));
                appiumDriver.findElement(By.xpath(Locators.KADIN_CATEGORY_SELECT.getLocator())).click();
                logger.info("Clicked Kadin category");
            }
        } catch (Exception e) {
            logger.info("Failed to open category page and choose Kadin category");
            e.printStackTrace();
        }
    }

    @Step("Choose Pantolon Category")
    public void choosePantolon() {
        try {
            waitUntilElementToBeClickable(By.xpath(Locators.PANTOLON_SELECT.getLocator()));
            if (appiumDriver.findElement(By.xpath(Locators.PANTOLON_SELECT.getLocator())).isDisplayed()) {
                appiumDriver.findElement(By.xpath(Locators.PANTOLON_SELECT.getLocator())).click();
                logger.info("Clicked Pantolon category");
            }
        } catch (Exception e) {
            logger.info("Failed to click Pantolon category");
            e.printStackTrace();
        }

    }

    @Step("Swipe two times up")
    public void swipeInCategory() {
        try {
            waitUntilElementToBeClickable(By.id(Locators.PANTOLON_CHECK.getLocator()));
            if (appiumDriver.findElement(By.id(Locators.PANTOLON_CHECK.getLocator())).isDisplayed()) {
                for (int i = 1; i < 3; i++) {
                    Dimension dimension = appiumDriver
                            .manage()
                            .window()
                            .getSize();

                    int startedWidth = (int) (dimension.width * 0.5);
                    int startedHeight  = (int) (dimension.height * 0.8);

                    int endedWidth = (int) (dimension.width * 0.2);
                    int endedHeight  = (int) (dimension.height * 0.2);

                    TouchAction touchHold = new TouchAction(appiumDriver);

                    touchHold.press(PointOption.point(startedWidth, startedHeight))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                            .moveTo(PointOption.point(endedWidth, endedHeight))
                            .release()
                            .perform();
                }
                logger.info("Did swipe up two times successfully");
            }
        } catch (Exception e) {
            logger.info("Failed to swipe up two times");
            e.printStackTrace();
        }
    }

    @Step("Choose random product")
    public void chooseRandomProduct() {
        try {
            waitUntilElementToBeClickable(By.id(Locators.PRODUCTS_CHECK.getLocator()));
            List<MobileElement> productList = appiumDriver.findElementsByXPath(Locators.PRDUCTSLIST.getLocator());
            int size = productList.size();
            Random rnd = new Random();
            int selectedProduct = rnd.nextInt(size);
            productList.get(selectedProduct).click();
            logger.info("Selected random product successfully");
        } catch (Exception e) {
            logger.info("Failed to select random product");
            e.printStackTrace();
        }
    }
}
