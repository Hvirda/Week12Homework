package myAccounts;

import baseFactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyAccountTest extends BaseTest {
    String baseurl="https://tutorialsninja.com/demo/index.php";

        public void selectMyAccount(String option){
        if(option.equals("Register")){
            WebElement register=driver.findElement(By.linkText("Register"));
            register.click();

        } else if (option.equals("Login")) {
            WebElement login=driver.findElement(By.linkText("Login"));
            login.click();
        }else if (option.equals("Logout")){
            WebElement logout=driver.findElement(By.linkText("Logout"));
            logout.click();
        }

    }
@Before
public void setup() {
        super.openBrowser(baseurl);
    }


    @Test
    public void  verifyUserShouldNavigateToRegisterPageSuccessfully(){
        //click on my account link
        WebElement myaccount=driver.findElement(By.linkText("My Account"));
        myaccount.click();
        selectMyAccount("Register");

        //fill register
        WebElement fname=driver.findElement(By.id("input-firstname"));
        fname.sendKeys("bc");

        //fill register
        WebElement lname=driver.findElement(By.id("input-lastname"));
        lname.sendKeys("hh");

        WebElement email=driver.findElement(By.id("input-email"));
        email.sendKeys("agff@gmail.com");

        WebElement tphone=driver.findElement(By.id("input-telephone"));
        tphone.sendKeys("7889342134");

        WebElement pwd=driver.findElement(By.id("input-password"));
        pwd.sendKeys("hh@123");

        WebElement cpwd=driver.findElement(By.id("input-confirm"));
        cpwd.sendKeys("hh@123");

        WebElement radio=driver.findElement(By.xpath("//div/label[1]/input[@name='newsletter']"));
        radio.click();

        WebElement check=driver.findElement(By.xpath("//div/input[@type='checkbox']"));
        check.click();

        WebElement con=driver.findElement(By.xpath("//div/input[2]"));
        con.click();

        //verify account created msg
        WebElement msg=driver.findElement(By.xpath("//div[@id='content']/h1"));
        System.out.println(msg.getText());

        //continue click
        WebElement ccon=driver.findElement(By.linkText("Continue"));
        ccon.click();
        //click on my account link
        WebElement myaccount2=driver.findElement(By.linkText("My Account"));
        myaccount2.click();

       selectMyAccount("Logout");

        //verify logout msg
        WebElement msg1=driver.findElement(By.xpath("//div[@id='content']/h1"));
        System.out.println(msg1.getText());

        WebElement conn=driver.findElement(By.linkText("Continue"));
        conn.click();
        }

        @Test
    public void  verifyThatUserShouldLoginAndLogoutSuccessfully(){
            WebElement myaccount3=driver.findElement(By.linkText("My Account"));
            myaccount3.click();

            selectMyAccount("Login");

            WebElement login=driver.findElement(By.id("input-email"));
            login.sendKeys("hh@gmail.com");


            WebElement pwd=driver.findElement(By.id("input-password"));
            pwd.sendKeys("hh@123");

            WebElement lg=driver.findElement(By.xpath("//input[@value='Login']"));
            lg.click();

            //verify my account text msg
            WebElement txt=driver.findElement(By.xpath("//h2[contains(text(),'My Account')]"));
            System.out.println(txt.getText());

            selectMyAccount("Logout");

            //verify logout msg
            WebElement log=driver.findElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
            System.out.println(log.getText());

    }
    @After
    public void close(){
        closeBrowser();
    }
}
