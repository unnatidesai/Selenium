package co.zoom.qa.project.pages;

import co.zoom.qa.project.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ProfilePage extends TestBase {

    @FindBy(xpath = "//a[text()='SIGN IN']")
    private WebElement signInBtn;

    @FindBy(xpath = "//p[contains(@class,'form-control-static displayName')]")
    private WebElement displayName;

    @FindBy(xpath = "//a//img[contains(@alt,'change profile picture')]")
    private WebElement changeProfilePic;

    @FindBy(xpath = "//input[@id=\"file\"]")
    private WebElement uploadBtn;



    public ProfilePage() throws IOException {

        PageFactory.initElements(driver,this);
    }


    public SignInPage clickSignInBtn() throws IOException{
        signInBtn.click();

        return new SignInPage();

    }

    public String verifyTitle(){
        return driver.getTitle();
    }

    public boolean verifyDisplayedName(){

        return displayName.isDisplayed();
    }

    public void changeProfilePicture(){

        changeProfilePic.click();
        driver.switchTo().frame(0);
        uploadBtn.click();

    }
}
