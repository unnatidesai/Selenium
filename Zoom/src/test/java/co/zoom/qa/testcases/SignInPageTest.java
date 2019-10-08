package co.zoom.qa.testcases;

import co.zoom.qa.project.base.TestBase;
import co.zoom.qa.project.pages.ProfilePage;
import co.zoom.qa.project.pages.SignInPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignInPageTest extends TestBase {

    SignInPage signInPage;
    ProfilePage profilePage;

    public SignInPageTest() throws IOException {
        super();
    }


    @BeforeSuite
    public void setUp() throws IOException {
        initialization();
        signInPage = new SignInPage();
        profilePage = new ProfilePage();

        driver.findElement(By.xpath("//a[contains(text(),'SIGN IN')]")).click();
        //driver.switchTo().window("https://zoom.us/signin");
    }

    @Test
    public void signInPageTitleTest(){
       String title = signInPage.validateSignInPageTitle();
        Assert.assertEquals(title,"Sign In - Zoom");

    }

    @Test
    public void zoomLogoImgTest(){
        boolean b1 =signInPage.validateZoomLogo();
        Assert.assertTrue(b1);
    }

    @Test
    public void signInTest() throws IOException{

          profilePage = signInPage.signIn(prop.getProperty("Email"),prop.getProperty("Password"));



    }


}
