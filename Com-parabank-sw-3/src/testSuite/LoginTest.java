package testSuite;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends RegisterTest{

    @Test
    public void test1(){

        //valid username and password
        WebElement username = driver.findElement(By.xpath("//div[1]/input[@class='input']"));
        username.sendKeys("HJinal");

        WebElement password= driver.findElement(By.xpath("//div[2]/input[@class='input']"));
        password.sendKeys("HJinal@123");

        WebElement login=driver.findElement(By.xpath("//div/input[@class='button']"));
        login.click();

        WebElement msg=driver.findElement(By.xpath("//h1"));
        String welcomemsg=msg.getText();
        System.out.println(welcomemsg);

        WebElement logout=driver.findElement(By.xpath("//div[@id='leftPanel']//li[8]/a"));
        logout.click();

        //customer login
        WebElement loginmsg=driver.findElement(By.xpath("//h2"));
       String lgnmsg=loginmsg.getText();
        System.out.println(lgnmsg);
    }

    @Test
    public void test2(){

        //invalid username and password
        WebElement username = driver.findElement(By.xpath("//div[1]/input[@class='input']"));
        username.sendKeys("HJinal1");

        WebElement uerrormsg=driver.findElement(By.xpath("//div[@id='rightPanel']"));
        String msg= uerrormsg.getText();
        System.out.println(msg);

        WebElement password= driver.findElement(By.xpath("//div[2]/input[@class='input']"));
        password.sendKeys("HJinal@1234");

        WebElement perrormsg=driver.findElement(By.xpath("//div[@id='rightPanel']"));
        String pmsg= uerrormsg.getText();
        System.out.println(msg);

        WebElement login=driver.findElement(By.xpath("//div/input[@class='button']"));
        login.click();

    }
    @After
    public void close(){
        closeBrowser();
    }
}
