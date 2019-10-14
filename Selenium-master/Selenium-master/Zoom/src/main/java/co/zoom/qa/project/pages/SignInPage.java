package co.zoom.qa.project.pages;

import co.zoom.qa.project.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SignInPage extends TestBase {



    @FindBy(id = "email")
    WebElement Email;

    @FindBy(id = "password")
    WebElement Password;

    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    WebElement SignInBtn;

    @FindBy(xpath = "//img[contains(@class,\'logo\')]")
    WebElement ZoomLogo;

    // Initializing page objects

    public SignInPage() throws IOException {
        super();

        PageFactory.initElements(driver, this);
    }

    // Actions:

    public String validateSignInPageTitle() {
        return driver.getTitle();
    }

    public boolean validateZoomLogo() {
        return ZoomLogo.isDisplayed();
    }

    public ProfilePage signIn(String emailAdd, String pwd) throws IOException {
        Email.sendKeys(emailAdd);
        Password.sendKeys(pwd);
        SignInBtn.click();

        return new ProfilePage();
    }
}

