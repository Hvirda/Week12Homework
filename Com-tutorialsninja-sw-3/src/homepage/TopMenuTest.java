package homepage;

import baseFactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopMenuTest extends BaseTest {
    String baseurl="https://tutorialsninja.com/demo/index.php";
    @Before
    public void setup(){
        openBrowser(baseurl);
    }
    @Test
      public void test1(){
        //get and click on desktops link
        List<WebElement> menuList=driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li/a"));
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

        //verify desktops word
        WebElement desktopmsg=driver.findElement(By.xpath("//h2"));
        String desktop=desktopmsg.getText();
        System.out.println(desktop);


        List<WebElement> ele1= driver.findElements(By.xpath("//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']"));
        for (WebElement element:ele1) {
            System.out.println(element.getText());
        }
    }
    @Test
    public void test2(){
        //get and click on laptops and notebooks
        List<WebElement> menuList=driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li/a"));
        for(WebElement element:menuList){
            //  System.out.println(element.getText());
            if (element.getText().equalsIgnoreCase("Laptops & Notebooks")){
                element.click();
                System.out.println(element);
            }
        }
        //click on all laptops and notebooks
        WebElement alllaptops = driver.findElement(By.xpath("//div[@class='dropdown-menu']/a[contains(text(),'Show AllLaptops & Notebooks')]"));
        alllaptops.click();
    }
    @Test
    public void test3(){

        //get and click on component link
        List<WebElement> menuList=driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li/a"));
        for(WebElement element:menuList){
            //  System.out.println(element.getText());
            if (element.getText().equalsIgnoreCase("Components")){
                element.click();
                System.out.println(element);
            }
        }
    }
    @After
    public void close(){
        closeBrowser();
    }
//    @After
//    public void quit(){
//        closeBrowser();
//    }

}
