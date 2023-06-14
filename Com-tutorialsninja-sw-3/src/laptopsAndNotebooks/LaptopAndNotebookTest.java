package laptopsAndNotebooks;

import homepage.TopMenuTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopAndNotebookTest extends TopMenuTest {
    @Before
    @Override
    public void setup() {
        super.setup();
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        List<WebElement> menuList = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a"));
        for (WebElement element : menuList) {
            //  System.out.println(element.getText());
            if (element.getText().equalsIgnoreCase("Laptops & Notebooks")) {
                element.click();
                System.out.println(element.getText());
            }
        }

        //show all laptops and notebooks
        WebElement alllaptop = driver.findElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        alllaptop.click();

        //select sort by high>low
        WebElement deflt = driver.findElement(By.xpath("//select[@id='input-sort']"));
        deflt.click();
        Select s = new Select(deflt);
        s.selectByVisibleText("Price (High > Low)");

        //get all default product
        List<WebElement> allPrice = driver.findElements(By.xpath("//div[@class='caption']/p[2]"));
        List<String> beforeFilterPrices = new ArrayList<>();
        for (WebElement element : allPrice) {
           String p[]=element.getText().split("\n");
           String p1=p[0];
            System.out.println(p1);

        }

        List<String> sortedPrices = new ArrayList<String>(beforeFilterPrices);
        System.out.println(sortedPrices);
        Collections.sort(sortedPrices);

       // System.out.println(sortedPrices.equals(allPrice));
        // Assert.assertEquals(allPrice,sortedPrices);
    }




    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        List<WebElement> menuList = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a"));
        for (WebElement element : menuList) {
            //  System.out.println(element.getText());
            if (element.getText().equalsIgnoreCase("Laptops & Notebooks")) {
                element.click();
                System.out.println(element.getText());
            }
        }

        //show all laptops and notebooks
        WebElement alllaptop = driver.findElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        alllaptop.click();

        //select all default price of product
        List<WebElement> defaultPrices=driver.findElements(By.xpath("//div/div/p[@class='price']"));
        System.out.println("default price: ");
        ArrayList sort=new ArrayList();
        for (WebElement price:defaultPrices) {
            String p[]=price.getText().split("\n");
            String s1=p[0];
            System.out.println(s1);
        }

        //sort price high to low to compare with filtered price




        //select sort by high>low
        WebElement deflt = driver.findElement(By.xpath("//select[@id='input-sort']"));
        deflt.click();
        Select s = new Select(deflt);
        s.selectByVisibleText("Price (High > Low)");

        //filtered price
        System.out.println("filtered price  ");
        List<WebElement> filteredPrices=driver.findElements(By.xpath("//div/div/p[@class='price']"));
        for (WebElement price:filteredPrices){
            String p[]=price.getText().split("\n");
            String a1=p[0];
            System.out.println(a1);
        }




        //select and verify macbook
       WebElement macbook = driver.findElement(By.xpath("//div/h4/a[text()='MacBook']"));
        macbook.click();
        WebElement text = driver.findElement(By.xpath("//h1[contains(text(),'MacBook')]"));
        System.out.println(text.getText());


        //click on add to cart
        WebElement addmacbook = driver.findElement(By.xpath("//button[@id='button-cart']"));
        addmacbook.click();

        //verify success msg
        WebElement msg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        System.out.println(msg.getText());

        //click on shopping cart link
        WebElement sLink=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/a[contains(text(),'shopping cart')]"));
        sLink.click();

        //verify Macbook text
        WebElement macbookLink=driver.findElement(By.linkText("MacBook"));
        System.out.println("Product name="+macbookLink.getText());

        //change quantity to 2
        WebElement qty=driver.findElement(By.xpath("//td[4]/div/input[@class='form-control']"));
        qty.sendKeys(Keys.CONTROL+"a");
        qty.sendKeys(Keys.DELETE);
        qty.sendKeys("2");

        //click on update
        WebElement update= driver.findElement(By.xpath("//button/i[@class='fa fa-refresh']"));
        update.click();

        //verify modify msg
        WebElement updateMsg=driver.findElement(By.xpath("//div/i[@class='fa fa-check-circle']"));
        System.out.println(updateMsg.getText());

        //verify total price
        WebElement tprice=driver.findElement(By.xpath("//tbody/tr/td[6]"));
        System.out.println("Total price= "+tprice.getText());

        //click on check out
        WebElement checkout=driver.findElement(By.xpath("//div/a[@class='btn btn-primary']"));
        checkout.click();

        //verify checkout msg
        WebElement checkoutMsg=driver.findElement(By.xpath("//div[@id='content']/h1"));
        System.out.println(checkoutMsg.getText());

        //verify new user
        WebElement newUser=driver.findElement(By.xpath("//div/h2[contains(text(),'New Customer')]"));
        System.out.println(newUser.getText());

        WebElement guest=driver.findElement(By.xpath("//div[2]/label/input[@name='account']"));
      guest.click();

      //click on continue
        driver.findElement(By.id("button-account")).click();

        //personal details
       WebElement fistname= driver.findElement(By.id("input-payment-firstname"));
       fistname.sendKeys("abc");

        WebElement lastname= driver.findElement(By.id("input-payment-lastname"));
        lastname.sendKeys("mm");


        WebElement email= driver.findElement(By.id("input-payment-email"));
        email.sendKeys("ad@gmail.com");

        WebElement phoneNumber= driver.findElement(By.id("input-payment-telephone"));
        phoneNumber.sendKeys("7723546789");

        WebElement address1= driver.findElement(By.id("input-payment-address-1"));
        address1.sendKeys("helly");

        WebElement city= driver.findElement(By.id("input-payment-city"));
        city.sendKeys("London");


        WebElement postcode= driver.findElement(By.id("input-payment-postcode"));
        postcode.sendKeys("ha56sd");

        WebElement country=driver.findElement(By.id("input-payment-country"));
        Select c=new Select(country);
        c.selectByVisibleText("United States");

        WebElement state=driver.findElement(By.id("input-payment-zone"));
        Select c1=new Select(state);
        c1.selectByVisibleText("New Jersey");


        WebElement submit= driver.findElement(By.id("button-guest"));
        submit.click();

        WebElement coment= driver.findElement(By.xpath("//textarea[@class='form-control']"));
        coment.sendKeys("add comment");

        WebElement terms=driver.findElement(By.xpath("//div[@class='pull-right']/input[@name='agree']"));
        terms.click();


        WebElement conti= driver.findElement(By.id("button-payment-method"));
        conti.click();

        WebElement warning=driver.findElement(By.xpath("//div/div[@class='alert alert-danger alert-dismissible']"));
        System.out.println(warning.getText());
    }

    @After
    public void close(){
        closeBrowser();
    }


}






