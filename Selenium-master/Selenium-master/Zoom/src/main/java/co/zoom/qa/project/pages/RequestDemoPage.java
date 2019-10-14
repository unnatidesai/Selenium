package co.zoom.qa.project.pages;

import co.zoom.qa.project.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class RequestDemoPage extends TestBase {

    @FindBy(css = "#email")
    private WebElement emailInput;

    @FindBy(css = "#company")
    private WebElement companyInput;

    @FindBy(css = "#first_name")
    private WebElement firstnameInput;

    @FindBy(css = "#last_name")
    private WebElement lastnameInput;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "description")
    private WebElement descInput;

    @FindBy(id = "btnSubmit")
    private WebElement submitBtn;



    public RequestDemoPage() throws IOException {
        PageFactory.initElements(driver,this);

    }


    public void createNewRequestDemo(String mail, String cname, String fname, String lname){
        emailInput.sendKeys(mail);
        companyInput.sendKeys(cname);
        firstnameInput.sendKeys(fname);
        lastnameInput.sendKeys(lname);
    }

    public void keyInEmail(String email){
        emailInput.sendKeys(email);
    }

    public void keyInCompanyName(String cname){
        companyInput.sendKeys(cname);
    }

    public void keyInFirstName(String fname){
        firstnameInput.sendKeys(fname);
    }

    public void keyInLastName(String lname){
        lastnameInput.sendKeys(lname);
    }

    public void selectEmpCount(String count){
        Select empCountInput = new Select(driver.findElement(By.id("00Nd0000007MFAl")));
        empCountInput.selectByVisibleText(count);
    }

    public void keyInPhone (String phone){
        phoneInput.sendKeys(phone);
    }

    public void selectCountry(String country){
        Select countryInput = new Select(driver.findElement(By.id("country")));
        countryInput.selectByVisibleText(country);
    }

    public void selectState(String state){
        Select stateInput = new Select(driver.findElement(By.id("state")));
        stateInput.selectByVisibleText(state);
    }

    public void keyInZipCode(String zipcode){
        zipcodeInput.sendKeys(zipcode);
    }

    public void keyInDescription(String desc){
        descInput.sendKeys(desc);
    }

    public void submit(){
        submitBtn.click();
    }

}
