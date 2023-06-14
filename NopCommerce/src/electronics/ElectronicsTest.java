package electronics;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Utility;

import java.time.Duration;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void verified(){
        WebElement electronics=driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/a"));
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(electronics).perform();
        // mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a[@href='/computers']"));
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]/a[@href='/cell-phones']"));

        //verify text
        WebElement cellphone=driver.findElement(By.xpath("//h1"));
        System.out.println(cellphone.getText());

    }
    @Test
    public void  verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() {
        WebElement electronics = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/a"));
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(electronics).perform();
        // mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a[@href='/computers']"));
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]/a[@href='/cell-phones']"));

        //verify text
        WebElement cellphone = driver.findElement(By.xpath("//h1"));
        System.out.println(cellphone.getText());

        //click on list view
        WebElement e = driver.findElement(By.xpath("//a[@class='viewmode-icon list']"));
        e.click();

        //click on nokia lumia link
        driver.navigate().refresh();
        driver.findElement(By.xpath("//div/h2/a[contains(text(),'Nokia Lumia 1020')]")).click();


        //click on add to cart

        clickOnElement(By.xpath("//div/button[@class='button-1 add-to-cart-button']"));

        //verify item added msg
        WebElement txt=driver.findElement(By.xpath("//p[@class='content']"));
        System.out.println(txt.getText());

        //close msg tab
        clickOnElement(By.xpath("//span[@class='close']"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

        WebElement gotoc=driver.findElement(By.xpath("//a[@class='ico-cart']"));
        Actions action1 = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action1.moveToElement(gotoc).perform();
        // mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a[@href='/computers']"));

        //2 Click on gotocart
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));

        //verify shopping cart msg
        WebElement msg2=driver.findElement(By.xpath("//h1"));
        System.out.println(msg2.getText());

        //change qty=2
        WebElement qty=driver.findElement(By.xpath("//input[@class='qty-input']"));
        qty.sendKeys(Keys.CONTROL+"A");
        qty.sendKeys(Keys.DELETE);
        qty.sendKeys("2");


        //verify total price
        WebElement totl=driver.findElement(By.xpath("//span[@class='product-subtotal']"));
        System.out.println(totl.getText());



        //click update
        driver.findElement(By.id("updatecart")).click();


       //click on checkbox
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //click on checkout
        clickOnElement(By.xpath("//button[@class='button-1 checkout-button']"));

        //get title of navigated sign in page
        WebElement cl=driver.findElement(By.xpath("//h1"));
        System.out.println(cl.getText());

        //click on register button
        clickOnElement(By.xpath("//button[@class='button-1 register-button']"));

        //fill register form
        WebElement fname=driver.findElement(By.id("FirstName"));
        fname.sendKeys("jj");

        WebElement lname=driver.findElement(By.id("LastName"));
        lname.sendKeys("kk");

        WebElement em=driver.findElement(By.id("Email"));
        em.sendKeys("nal@gmail.com");

        WebElement pwd=driver.findElement(By.id("Password"));
        pwd.sendKeys("HH@123");

        WebElement cpwd=driver.findElement(By.id("ConfirmPassword"));
       cpwd.sendKeys("HH@123");

       //click on register

        clickOnElement(By.xpath("//button[@class='button-1 register-next-step-button']"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

        //successfull register
        WebElement reg=driver.findElement(By.xpath("//div[@class='result']"));
        System.out.println(reg.getText());

        //continue
        clickOnElement(By.xpath("//a[@class='button-1 register-continue-button']"));



    }
//    @After
//    public void close(){
//        closeBrowser();
//    }
}



