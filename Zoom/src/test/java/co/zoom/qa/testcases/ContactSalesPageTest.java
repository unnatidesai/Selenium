package co.zoom.qa.testcases;

import co.zoom.qa.project.base.TestBase;
import co.zoom.qa.project.data.ExcelDataProvider;
import co.zoom.qa.project.pages.ContactSales;
import co.zoom.qa.project.pages.SecondNavigationBar;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContactSalesPageTest extends TestBase {

    ContactSales contactSales;
    ContactSalesPageTest contactSalesPageTest;
    SecondNavigationBar secondNavigationBar;

    public ContactSalesPageTest() throws IOException {

        super();
    }

    @BeforeSuite
    public void setUp() throws IOException {
        initialization();
        contactSales = new ContactSales();
        contactSalesPageTest = new ContactSalesPageTest();
        secondNavigationBar = new SecondNavigationBar(driver);
        contactSales = secondNavigationBar.clickContactSales();
    }

    @Test
    public void createNewContactTest() throws IOException {
        //contactSales = secondNavigationBar.clickContactSales();
        contactSales.createContact("abc","sf","sd","erh");

    }

    @Test(dataProvider = "excelData", dataProviderClass = ExcelDataProvider.class)
    public void newContactTest(String email, String cname, String fname, String lname) throws IOException {
           contactSales.createContact(email, cname, fname, lname);
            System.out.println(email);
            System.out.println(cname);
            System.out.println(fname);
            System.out.println(lname);
         }

}
