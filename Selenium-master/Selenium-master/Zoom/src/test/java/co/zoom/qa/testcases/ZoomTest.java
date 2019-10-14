package co.zoom.qa.testcases;
import java.io.File;
        import java.io.IOException;
        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.concurrent.TimeUnit;

        import org.apache.commons.io.FileUtils;
        import org.openqa.selenium.By;
        import org.openqa.selenium.OutputType;
        import org.openqa.selenium.TakesScreenshot;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.Assert;
        import org.testng.ITestResult;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.AfterTest;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.BeforeTest;
        import org.testng.annotations.Test;

        import com.relevantcodes.extentreports.ExtentReports;
        import com.relevantcodes.extentreports.ExtentTest;
        import com.relevantcodes.extentreports.LogStatus;



public class ZoomTest {


    public WebDriver driver;
    public ExtentReports extent;
    public ExtentTest extentTest;


    @BeforeTest
    public void setExtent() {
        extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
        extent.addSystemInfo("Host Name", "Unnati HP");
        extent.addSystemInfo("User Name", "Unnati Desai");
        extent.addSystemInfo("Environment", "QA");

    }

    @AfterTest
    public void endReport() {
        extent.flush();
        extent.close();
    }

    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots"
        // under src folder
        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
                + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }


    @BeforeMethod
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RICHA\\Selenium\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.zoom.us/");

    }


    @Test
    public void zoomTest() {
        extentTest = extent.startTest("ZoomTest");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Video Conferencing, Web Conferencing, Webinars, Screen Sharing - Zoom");
    }

    @Test
    public void zoomLogoTest() {
        extentTest = extent.startTest("ZoomLogoTest");
        boolean b = driver.findElement(By.xpath("//img[@class='logo']")).isDisplayed();
        Assert.assertTrue(b);
        Assert.fail();
    }


    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName()); //to add name in extent report
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); //to add error/exception in extent report

            String screenshotPath = ZoomTest.getScreenshot(driver, result.getName());
            extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
            //extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

        }


        extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
        driver.quit();
    }


}
