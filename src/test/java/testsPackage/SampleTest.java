package testsPackage;

import basepackage.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.StorePage;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class SampleTest extends BaseTest {

    @Test
    public void guestCheckout() throws InterruptedException, IOException {
        HashMap<String, String> testdata = excelreading();

        HomePage homepage = new HomePage(getDriver());
        StorePage storepage = homepage.clickStoreBtn();

       storepage.enterTxtinSerachFld(testdata.get("Name")).
                 clickSerachBtn().
                 addToCartBtn().
               viewCartBtn();









        getDriver().findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']")).click();
        WebElement fName = getDriver().findElement(By.xpath("//input[@id='billing_first_name']"));
        fName.clear();
        fName.sendKeys("testfName");
        WebElement lName =getDriver().findElement(By.xpath("//input[@id='billing_last_name']"));
        lName.clear();
        lName.sendKeys("testlName");

        WebElement Street= getDriver().findElement(By.xpath("//input[@id='billing_address_1']"));
        Street.clear();
        Street.sendKeys("testStreet");

        getDriver().findElement(By.id("billing_email")).sendKeys("test@test.com");

        WebElement town= getDriver().findElement(By.xpath("//input[@id='billing_city']"));
        town.clear();
        town.sendKeys("test town");
        WebElement zipcode =getDriver().findElement(By.xpath("//input[@id='billing_postcode']"));
        zipcode.clear();
        zipcode.sendKeys("15417");
        validation("test","test1");
        //driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("test@test.com");
        getDriver().findElement(By.xpath("//button[@id='place_order']")).click();
        String text2 = getDriver().findElement(By.xpath("//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']")).getText();
        Assert.assertEquals(text2,"Thank you. Your order has been received.");
    }

    @Test
    public void loginAndCheckout() throws InterruptedException
    {

        HomePage homepage = new HomePage(getDriver());
        StorePage storepage = homepage.clickStoreBtn();

        storepage.enterTxtinSerachFld("Blue").
                clickSerachBtn().
                addToCartBtn().
                viewCartBtn();
        getDriver().findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']")).click();
        getDriver().findElement(By.xpath("//a[@class='showlogin']")).click();
        getDriver().findElement(By.xpath("//input[@id='username']")).sendKeys("phani");
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("phani");
        getDriver().findElement(By.xpath("//button[@name='login']")).click();
        WebElement fName = getDriver().findElement(By.xpath("//input[@id='billing_first_name']"));
        fName.clear();
        fName.sendKeys("testfName");
        WebElement lName =getDriver().findElement(By.xpath("//input[@id='billing_last_name']"));
        lName.clear();
        lName.sendKeys("testlName");

        WebElement Street= getDriver().findElement(By.xpath("//input[@id='billing_address_1']"));
        Street.clear();
        Street.sendKeys("testStreet");
        WebElement town= getDriver().findElement(By.xpath("//input[@id='billing_city']"));
        town.clear();
        town.sendKeys("test town");
        WebElement zipcode =getDriver().findElement(By.xpath("//input[@id='billing_postcode']"));
        zipcode.clear();
        zipcode.sendKeys("15417");
        //driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("test@test.com");
        getDriver().findElement(By.xpath("//button[@id='place_order']")).click();
        String text2 = getDriver().findElement(By.xpath("//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']")).getText();
        Assert.assertEquals(text2,"Thank you. Your order has been received.");
    }
}
