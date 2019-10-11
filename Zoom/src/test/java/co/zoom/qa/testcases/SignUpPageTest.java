package co.zoom.qa.testcases;

import co.zoom.qa.project.base.TestBase;
import co.zoom.qa.project.pages.SentConfirmationEmailPage;
import co.zoom.qa.project.pages.SignUpPage;
import co.zoom.qa.project.reports.HtmlReport;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignUpPageTest extends TestBase {

    SignUpPage signUpPage;
    SentConfirmationEmailPage sentConfirmationEmailPage;

    public SignUpPageTest() throws IOException {

        super();

    }

    ExtentTest htmlReports = HtmlReport.getReportInstance().createTest("signUpPageTest");


    @BeforeMethod
    public void setUp() throws IOException {

        initialization();
        signUpPage = new SignUpPage();
        sentConfirmationEmailPage = new SentConfirmationEmailPage();
        driver.findElement(By.xpath("//a[contains(@class,'btn btn-primary signupfree')]")).click();
    }

    @Test(priority = 1)
    public void signPageTitleTest(){
        String title = signUpPage.validateSignUpPageTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Sign Up Free - Zoom");
    }

    @Test(priority = 2)
    public void signUpTest(){
        sentConfirmationEmailPage = signUpPage.signUp("desaibm31@gmail.com");
    }


    @AfterMethod
    public void flush() throws IOException {
        HtmlReport.getReportInstance().flush();

    }
}
