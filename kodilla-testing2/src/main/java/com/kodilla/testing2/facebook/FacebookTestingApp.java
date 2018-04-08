package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_SELECT_DAY = "//div[contains(@class,\"_5k_5\")]/span/span/select[1]";
    public static final String XPATH_SELECT_MONTH = "//div[contains(@class,\"_5k_5\")]/span/span/select[2]";
    public static final String XPATH_SELECT_YEAR = "//div[contains(@class,\"_5k_5\")]/span/span/select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.gerDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement selectCombo_DAY = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select selectDAY = new Select(selectCombo_DAY);
        selectDAY.selectByValue("26");

        WebElement selectCombo_MONTH = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select selectMONTH = new Select(selectCombo_MONTH);
        selectMONTH.selectByIndex(2);

        WebElement selectCombo_YEAR = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select selectYEAR = new Select(selectCombo_YEAR);
        selectYEAR.selectByValue("1973");
    }
}