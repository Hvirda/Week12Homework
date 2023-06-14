package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.Utility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void sort() {
        WebElement ele = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a[@href='/computers']"));
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();
        // mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a[@href='/computers']"));
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/ul/li/a[contains(text(),'Desktops')]"));

        //beforeFilter
        driver.navigate().refresh();
        List<WebElement> bSort = driver.findElements(By.xpath("//h2"));
        ArrayList a1 = new ArrayList();
        for (WebElement element : bSort) {
            System.out.println(element.getText());
            a1.add(element.getText());
        }
        System.out.println(a1);
        Collections.sort(a1);
        Collections.reverse(a1);
        System.out.println("Expexted: " + a1);

        //click on z to a
        WebElement sel = driver.findElement(By.id("products-orderby"));
        Select s = new Select(sel);
        s.selectByVisibleText("Name: Z to A");

        List<WebElement> afterSort = driver.findElements(By.xpath("//h2"));
        ArrayList a2 = new ArrayList();
        for (WebElement element : afterSort) {
            System.out.println(element.getText());
            a2.add(element.getText());
        }

        //verify z to a sorting
        Collections.reverse(a2);
        Assert.assertEquals("sort", a1, a2);
        System.out.println("Actual:" + a2);


    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        //1 Click on Computer Menu.
        WebElement ele = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a[@href='/computers']"));
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();
        // mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a[@href='/computers']"));

        //2 Click on Desktop
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/ul/li/a[contains(text(),'Desktops')]"));

        //3 Select Sort By position "Name: A to Z"
        WebElement sel = driver.findElement(By.id("products-orderby"));
        Select s = new Select(sel);
        s.selectByVisibleText("Name: A to Z");

        //click add to cart
        driver.navigate().refresh();
        List<WebElement> products = driver.findElements(By.cssSelector("h2.product-title"));

        for (int i = 0; i < products.size(); i++) {
            String pName = products.get(i).getText();
            System.out.println(pName);
            if (pName.contains("Build your own computer")) {

                driver.findElements(By.xpath("//button[contains(text(),'Add to cart')]")).get(i).click();

            }

        }

        //verify build your computer message
        WebElement msg = driver.findElement(By.xpath("//h1"));
        System.out.println(msg.getText());

        //select
        WebElement pr = driver.findElement(By.id("product_attribute_1"));
        Select s1 = new Select(pr);
        s1.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");

        //select gb ram
        WebElement pr2 = driver.findElement(By.id("product_attribute_2"));
        Select s2 = new Select(pr2);
        s2.selectByVisibleText("8GB [+$60.00]");

        //select radiobutton
        WebElement pr3 = driver.findElement(By.id("product_attribute_3_7"));
        pr3.click();


        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        //[+$5.00]"
        WebElement checkbox = driver.findElement(By.id("product_attribute_5_12"));
        checkbox.click();

        WebElement price1 = driver.findElement(By.xpath("//span[@id='price-value-1']"));
        System.out.println("price=" + price1.getText());


//click on add to cart

        WebElement add = driver.findElement(By.id("add-to-cart-button-1"));
        add.click();

//verify msg product added
        WebElement sddmsg = driver.findElement(By.xpath("//p[contains(text(),'The product has been added to your ')]"));
        System.out.println(sddmsg.getText());

        //close msg tab
        clickOnElement(By.xpath("//span[@class='close']"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        //go to shopping cart link and clock on go to cart
        WebElement gotoc = driver.findElement(By.xpath("//li[@id='topcartlink']/a"));
        Actions action1 = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action1.moveToElement(gotoc).perform();
        // mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a[@href='/computers']"));

        //2 Click on gotocart
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));

        //verify shopping cart msg
        WebElement msg2 = driver.findElement(By.xpath("//h1"));
        System.out.println(msg2.getText());

        //change quantity
        WebElement qty = driver.findElement(By.xpath("//input[@class='qty-input']"));
        qty.sendKeys(Keys.CONTROL + "A");
        qty.sendKeys(Keys.DELETE);
        qty.sendKeys("2");
//
        //click update
        WebElement update = driver.findElement(By.xpath("//button[@class='button-2 update-cart-button']"));
        update.click();

        // verify total price
        WebElement total = driver.findElement(By.xpath("//span[@class='product-subtotal']"));
        System.out.println(total.getText());

        //click on checkbox
        clickOnElement(By.id("termsofservice"));

        //click on checkout
        clickOnElement(By.xpath("//button[@class='button-1 checkout-button']"));

        //get title of navigated sign in page
        WebElement cl = driver.findElement(By.xpath("//h1"));
        System.out.println(cl.getText());

        //click on guest checkout
        clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));

        //fill mandetory fields
        WebElement fname = driver.findElement(By.id("BillingNewAddress_FirstName"));
        fname.sendKeys("jj");

        WebElement lname = driver.findElement(By.id("BillingNewAddress_LastName"));
        lname.sendKeys("kk");

        WebElement em = driver.findElement(By.id("BillingNewAddress_Email"));
        em.sendKeys("kk@gmail.com");

        WebElement cn = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select ss = new Select(cn);
        ss.selectByVisibleText("Canada");

        WebElement st = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
        Select stat = new Select(st);
        stat.selectByVisibleText("Ontario");

        WebElement city = driver.findElement(By.id("BillingNewAddress_City"));
        city.sendKeys("London");


        WebElement adrs = driver.findElement(By.id("BillingNewAddress_Address1"));
        adrs.sendKeys("ghjd");

        WebElement zip = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        zip.sendKeys("ha45fg");

        WebElement phon = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        phon.sendKeys("7789653412");

        //click on continue button
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[@class='button-1 new-address-next-step-button']"));

        //click on next day air radio
        clickOnElement(By.id("shippingoption_1"));

        //click on continue
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //click on credit card option
        clickOnElement(By.id("paymentmethod_1"));

        //click on continue
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //enter card holder name
        WebElement card = driver.findElement(By.id("CardholderName"));
        card.sendKeys("abcd");

        WebElement cardno = driver.findElement(By.id("CardNumber"));
        cardno.sendKeys("374245455400126");

        WebElement exmnth = driver.findElement(By.id("ExpireMonth"));
        Select mn = new Select(exmnth);
        mn.selectByVisibleText("09");

        WebElement exyr = driver.findElement(By.id("ExpireYear"));
        Select yr = new Select(exyr);
        yr.selectByVisibleText("2024");

        WebElement code = driver.findElement(By.id("CardCode"));
        code.sendKeys("4321");

        //click on continue
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));


        //verify total amount in payment
        WebElement tamnt = driver.findElement(By.xpath("//span[@class='value-summary']/strong"));
        System.out.println("total payment =" + tamnt.getText());

        //click on continue
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));

        //get successfull order msg
        WebElement ms = driver.findElement(By.xpath("//div[@class='title']/strong[contains(text(),'Your order has been successfully processed!')]"));
        System.out.println(ms.getText());

        //click on continue
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));

        //print welcome msg
        WebElement welcmmsg = driver.findElement(By.xpath("//h2"));
        System.out.println(welcmmsg.getText());


    }

    @After
    public void close() {
        closeBrowser();
    }

}
