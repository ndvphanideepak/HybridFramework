package basepackage;

import org.openqa.selenium.WebDriver;

public class BasePage {
    //common code for all the pages
   protected WebDriver driver;
    public BasePage(WebDriver driver)
    {
        this.driver=driver;
    }
}
