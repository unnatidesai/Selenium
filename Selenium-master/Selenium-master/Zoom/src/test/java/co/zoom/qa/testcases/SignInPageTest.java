package co.zoom.qa.testcases;

import co.zoom.qa.project.base.TestBase;
import co.zoom.qa.project.listeners.ScreenShotListener;
import co.zoom.qa.project.pages.ProfilePage;
import co.zoom.qa.project.pages.SignInPage;
import co.zoom.qa.project.reports.HtmlReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners({ScreenShotListener.class})

public class SignInPageTest extends TestBase {

    SignInPage signInPage;
    ProfilePage profilePage;

    public SignInPageTest() throws IOException {
        super();
    }
    ExtentTest htmlReports = HtmlReport.getReportInstance().createTest("signInPageTest");




    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        signInPage = new SignInPage();
        profilePage = new ProfilePage();

        driver.findElement(By.xpath("//a[contains(text(),'SIGN IN')]")).click();
        //driver.switchTo().window("https://zoom.us/signin");
    }

    @Test(priority = 1)
    public void signInPageTitleTest(){
       String title = signInPage.validateSignInPageTitle();
        Assert.assertEquals(title,"Sign In - Zoom");

        try {
            Assert.fail();
        }catch (AssertionError error) {

            throw error;

        }
    }


    @Test(priority = 2)
    public void zoomLogoImgTest(){
        boolean b1 =signInPage.validateZoomLogo();
        Assert.assertTrue(b1);
    }

    @Test(priority = 3)
    public void signInTest() throws IOException{

          profilePage = signInPage.signIn(prop.getProperty("Email"),prop.getProperty("Password"));

    }

    @AfterMethod
    public void flush() throws IOException {
        HtmlReport.getReportInstance().flush();
        driver.quit();
    }




}
