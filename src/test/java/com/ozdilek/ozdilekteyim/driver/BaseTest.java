package com.ozdilek.ozdilekteyim.driver;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected static AppiumDriver<MobileElement> appiumDriver;
    protected Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeScenario
    public void startUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.ozdilek.ozdilekteyim");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.ozdilek.ozdilekteyim.MainActivity");
        capabilities.setCapability(AndroidMobileCapabilityType.PLATFORM, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        try {
            appiumDriver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            logger.info("Driver started up successfully");
        } catch (MalformedURLException e) {
            logger.info("Failed to start up driver!");
            e.printStackTrace();
        }
    }

    @AfterScenario
    public void afterScenario() {
        if (appiumDriver != null) {
            appiumDriver.quit();
            logger.info("Driver terminated successfully!");
        }
    }

    public void waitUntilElementToBeClickable(By element) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
