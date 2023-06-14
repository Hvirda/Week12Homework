package desktops;

import homepage.TopMenuTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DesktopTest extends TopMenuTest {
    @Test
    public void verifyProductArrangeInAlphaBalticOrder() {

        List<WebElement> menuList = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li/a"));
        for (WebElement element : menuList) {
            //  System.out.println(element.getText());
            if (element.getText().equalsIgnoreCase("Desktops")) {
                element.click();
                System.out.println(element);
            }

        }

        //click on show all desktops
        WebElement allDesktops = driver.findElement(By.xpath("//div[@class='dropdown-menu']/a[contains(text(),'Show AllDesktops')]"));
        allDesktops.click();

        //default item list
        List<WebElement> beforeSort = driver.findElements(By.xpath("//div/h4/a"));
        for (WebElement element : beforeSort) {
            System.out.println(element.getText());
        }

        //click on sort
        WebElement sort = driver.findElement(By.xpath("//select[@id='input-sort']"));
        sort.click();

        Select s = new Select(sort);
        s.selectByVisibleText("Name (Z - A)");

        List<WebElement> afterSortFilter = driver.findElements(By.xpath("//div/h4/a"));
        for (WebElement element : afterSortFilter) {
            System.out.println(element.getText());
        }

          Assert.assertNotEquals("not equal", beforeSort, afterSortFilter);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        List<WebElement> menuList = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li/a"));
        for (WebElement element : menuList) {
            //  System.out.println(element.getText());
            if (element.getText().equalsIgnoreCase("Desktops")) {
                element.click();
                System.out.println(element);
            }
        }

        //click on show all desktops
        WebElement allDesktops = driver.findElement(By.xpath("//div[@class='dropdown-menu']/a[contains(text(),'Show AllDesktops')]"));
        allDesktops.click();

        //default item list
        List<WebElement> beforeSort = driver.findElements(By.xpath("//div/h4/a"));
        for (WebElement element : beforeSort) {
            System.out.println(element.getText());
        }

        //click on sort
        WebElement sort = driver.findElement(By.xpath("//select[@id='input-sort']"));
        sort.click();

        Select s = new Select(sort);
        s.selectByVisibleText("Name (A - Z)");

        WebElement product = driver.findElement(By.linkText("HP LP3065"));
        product.click();

        //verify product name navigated to another page
        WebElement pName = driver.findElement(By.xpath("//h1[contains(text(),'HP LP3065')]"));
        String name = pName.getText();
        System.out.println(name);


        //select date
        WebElement calender = driver.findElement(By.xpath("//button[@class='btn btn-default']/i[@class='fa fa-calendar']"));
        calender.click();
        String day = "22";
        String month = "November";
        String year = "2013";
        while (true) {
            //get default month and year
            WebElement monthYear = driver.findElement(By.xpath("//tr/th[@class='picker-switch']"));
            System.out.println(monthYear.getText());
            String monyear = monthYear.getText();
            String arr[] = monyear.split(" ");
            String month1 = arr[0];
            String year1 = arr[1];

            // System.out.println(month1);
            //  System.out.println(year1);

            //verify and select given month and year
            if (month1.equalsIgnoreCase(month) && year1.equalsIgnoreCase(year)) {
                break;
            } else {
                //to click on next
                WebElement clickNext = driver.findElement(By.xpath("//th[@class='next']"));
                clickNext.click();
            }
        }
            List<WebElement> days=driver.findElements(By.xpath("//div[@class='datepicker-days']//tbody/tr/td[@class='day']"));
            for (WebElement element:days){
                if (element.getText().equalsIgnoreCase("22")){
                   element.click();
                    //System.out.println(element.getText());
                    break;
                }
            }


        //enter quantity

        WebElement qy=driver.findElement(By.xpath("//input[@id='input-quantity']"));
        qy.sendKeys(Keys.CONTROL + "a");   //clear search
        qy.sendKeys(Keys.DELETE);
        qy.sendKeys("1");

        //click on add to cart
        WebElement add=driver.findElement(By.xpath("//button[@id='button-cart']"));
        add.click();

        //verify msg add to cart
        WebElement msg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        System.out.println(msg.getText());

        //click on shopping cart link
        WebElement link=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/a[contains(text(),'shopping cart')]"));
        link.click();

        //verify shopping cart text
        WebElement cart=driver.findElement(By.xpath("//div[@id='content']/h1"));
        System.out.println(cart.getText());

        //verify product name
        WebElement prName=driver.findElement(By.linkText("HP LP3065"));
        System.out.println(prName.getText());

        //verify delivery date
        WebElement date=driver.findElement(By.xpath("del date: //table[@class='table table-bordered']//tbody//tr[1]//td[2]//small[1]"));
        System.out.println(date.getText());

        //verify model
        WebElement model=driver.findElement(By.xpath("//div[@class='table-responsive']//table//tbody//tr[1]//td[3]"));
        System.out.println(model.getText());

        //verify total
        WebElement totalPrice=driver.findElement(By.xpath("//li/table/tbody/tr/td[5]"));
        System.out.println(totalPrice.getText());

    }
    @After
    public void close(){
        closeBrowser();
    }
}
