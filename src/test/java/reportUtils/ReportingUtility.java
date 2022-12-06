package reportUtils;
import basepackage.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ReportingUtility extends BaseTest implements ITestListener{
    public ExtentSparkReporter sparkReporter;//GUI---colour,Title.Alignment,path
    public ExtentReports extent; //common information
    public ExtentTest test; //updation of teststatus in reports

    public void onStart(ITestContext context)
    {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy-HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);

        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/myreports/myreport.html"+actualDate);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Regression Senario's");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Environment", "UAT");
        extent.setSystemInfo("user", "Deepak");
        extent.setSystemInfo("Browser", "Chrome");
    }
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.PASS, "Test case passed is "+result.getName());

    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case failed is "+result.getName());
        test.log(Status.FAIL, "Test case failed is "+result.getThrowable());

    }


    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case skipped is "+result.getName());
    }

    public void onFinish(ITestContext contex) {
        extent.flush();
    }
}


