package testSuite;

import browserFactory.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl="https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void test1() {

        //click on register link
        WebElement registerLink = driver.findElement(By.xpath("//div[@id='loginPanel']/p[2]/a"));
        registerLink.click();

        //get welcome message
        WebElement title = driver.findElement(By.xpath("//h1[@class='title']"));
        String welcomeMsg = title.getText();
        System.out.println(welcomeMsg);

        //fill register fields

        WebElement fName = driver.findElement(By.xpath("//input[@id='customer.firstName']"));
        fName.sendKeys("Jinal");

        WebElement lName = driver.findElement(By.xpath("//input[@id='customer.lastName']"));
        lName.sendKeys("Roy");

        WebElement address = driver.findElement(By.xpath("//input[@id='customer.address.street']"));
        address.sendKeys("Landseer close");

        WebElement city = driver.findElement(By.xpath("//input[@id='customer.address.city']"));
        city.sendKeys("London");

        WebElement state = driver.findElement(By.xpath("//input[@id='customer.address.state']"));
        state.sendKeys("London");

        WebElement zipCode = driver.findElement(By.xpath("//input[@id='customer.address.zipCode']"));
        zipCode.sendKeys("HA74BZ");

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='customer.phoneNumber']"));
        phoneNumber.sendKeys("7712324565");

        WebElement ssn = driver.findElement(By.xpath("//input[@id='customer.ssn']"));
        ssn.sendKeys("771");

        WebElement uName = driver.findElement(By.xpath("//input[@id='customer.username']"));
        uName.sendKeys("HJinal");

        WebElement pwd = driver.findElement(By.xpath("//input[@id='customer.password']"));
        pwd.sendKeys("HJinal@123");


        WebElement confirm = driver.findElement(By.xpath("//input[@id='repeatedPassword']"));
        confirm.sendKeys("HJinal@123");

        WebElement submit = driver.findElement(By.xpath("//div[3]/input[@class='button']"));
        submit.click();

        WebElement registerMsg = driver.findElement(By.xpath("//div[@id='rightPanel']/p"));
        String msg = registerMsg.getText();
        System.out.println(msg);

        WebElement username = driver.findElement(By.xpath("//div[1]/input[@class='input']"));
        username.sendKeys("HJinal");

        WebElement password= driver.findElement(By.xpath("//div[2]/input[@class='input']"));
        password.sendKeys("HJinal@123");

        WebElement login=driver.findElement(By.xpath("//div/input[@class='button']"));
        login.click();

        WebElement logout=driver.findElement(By.xpath("//div[@id='leftPanel']//li[8]/a"));
        logout.click();
    }


}
