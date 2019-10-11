package co.zoom.qa.project.pages;

import co.zoom.qa.project.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class ContactSales extends TestBase {

    @FindBy(id = "email")
    private WebElement workEmailAdd;

    @FindBy(id = "company")
    private WebElement companyName;

    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "last_name")
    private WebElement lastName;



    public ContactSales() throws IOException {
        PageFactory.initElements(driver,this);
    }


    public void createContact(String mail, String cname, String fname, String lname){
        workEmailAdd.sendKeys(mail);
        companyName.sendKeys(cname);
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
    }


}
