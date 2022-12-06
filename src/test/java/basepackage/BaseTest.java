package basepackage;

import factory.DriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class BaseTest {
    //common for all test classes
    //protected WebDriver driver;
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public void setDriver(WebDriver driver)
    {
        this.driver.set(driver);
    }

    public WebDriver getDriver()
    {
        return this.driver.get();
    }
    @BeforeMethod
    public void setupBrowser()
    {

        setDriver(new DriverManager().intilaizeDriver());
    }

    @AfterMethod
    public void tearDown()
    {

        getDriver().close();
    }

    //excel reading code
    public static HashMap<String, String> excelreading() throws FileNotFoundException, IOException {
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(".\\data.xlsx"));
        XSSFSheet sh = wb.getSheetAt(0);
        int rows = sh.getLastRowNum();
        HashMap<String, String> data = new HashMap<String, String>();
        for (int r = 0; r <= rows; r++) {
            String key = sh.getRow(r).getCell(0).getStringCellValue();
            String value = sh.getRow(r).getCell(1).getStringCellValue();
            data.put(key, value);

        }
        return data;
    }

    public  void validation(String actual,String expected)
    {
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(actual,expected);
        sa.assertAll();
    }
}
