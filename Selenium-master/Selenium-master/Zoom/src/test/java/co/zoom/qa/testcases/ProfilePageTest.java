package co.zoom.qa.testcases;

import co.zoom.qa.project.base.TestBase;
import co.zoom.qa.project.pages.ProfilePage;
import co.zoom.qa.project.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProfilePageTest extends TestBase {

    SignInPage signInPage;
    ProfilePage profilePage;

    public ProfilePageTest() throws IOException {
        super();
    }


    @BeforeSuite
    public void setUp() throws IOException{
        initialization();
        signInPage = new SignInPage();
        profilePage = new ProfilePage();
        profilePage.clickSignInBtn();
        profilePage = signInPage.signIn(prop.getProperty("Email"),prop.getProperty("Password"));
    }


    @Test(priority = 1)
    public void profilePageTitleTest(){
        String title = profilePage.verifyTitle();
        Assert.assertEquals(title,"Sign In - Zoom");
    }

    @Test(priority = 2)
    public void verifyDisplayedNameTest(){
        Assert.assertTrue(profilePage.verifyDisplayedName());
    }

   // @Test(priority = 3)
   // public void changeProfilePictureTest(){
     //   profilePage.changeProfilePicture();
}
