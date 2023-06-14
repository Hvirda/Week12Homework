package homepage;

import baseFactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {
    String baseUrl="https://demo.nopcommerce.com/";
    public void selectMenu(String menu) {

        if(menu.equals("computers")){
           driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a[@href='/computers']")).click();

        } else if (menu.equals("electronics")) {
            driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/a[@href='/electronics']")).click();
            
        }
    }
    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyPageNavigation(){
        selectMenu("computers");
        selectMenu("electronics");
    }

    @After
    public void close(){
        closeBrowser();
    }


}
