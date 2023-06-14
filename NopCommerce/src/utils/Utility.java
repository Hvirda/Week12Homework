package utils;

import baseFactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utility extends BaseTest {
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        //   Thread.sleep(3000);
        //  waitUnitVisibilityOfElementLocated(by,3000);
        actions.moveToElement(mouseHoover).click().build().perform();
    }
}
