package co.zoom.qa.project.pages;

import co.zoom.qa.project.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SignUpPage extends TestBase {

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(xpath = "//a[text()='Sign Up']")
    private WebElement signUpBtn;




    public SignUpPage() throws IOException {
        super();

        PageFactory.initElements(driver,this);
    }

    public String validateSignUpPageTitle(){
       return driver.getTitle();
    }

    public SentConfirmationEmailPage signUp(String em){
        email.sendKeys(em);
        signUpBtn.click();
        return new SentConfirmationEmailPage();

    }
}
