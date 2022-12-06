package pages;

import basepackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {
    public StorePage(WebDriver driver) {
        super(driver);
    }

    //UI+Actionmethods
    private By serachFld = By.xpath("//input[@id='woocommerce-product-search-field-0']");
    private By serachBtn = By.xpath("//button[@value='Search']");
    private By addToCartBtnUI = By.xpath("//a[@aria-label='Add “Blue Shoes” to your cart']");
    private By viewCartBtnUI = By.xpath("//a[@title='View cart']");

    public StorePage enterTxtinSerachFld(String text)
    {
        driver.findElement(serachFld).sendKeys(text);
        return this;
    }

    public StorePage clickSerachBtn()  {
        driver.findElement(serachBtn).click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public StorePage addToCartBtn()  {
        driver.findElement(addToCartBtnUI).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public CartPage viewCartBtn()
    {
        driver.findElement(viewCartBtnUI).click();
        return new CartPage(driver);
    }

}
