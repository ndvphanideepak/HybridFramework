package pages;

import basepackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    private By storeBtn = By.xpath("//li[@id='menu-item-1227']//a[@class='menu-link'][normalize-space()='Store']");

    public StorePage clickStoreBtn()
    {
        driver.findElement(storeBtn).click();
        return new StorePage(driver);
    }
}
