package co.zoom.qa.testcases;

import co.zoom.qa.project.base.TestBase;
import co.zoom.qa.project.data.ExcelDataProvider;
import co.zoom.qa.project.pages.RequestDemoPage;
import co.zoom.qa.project.pages.TopNavigation;
import co.zoom.qa.project.utils.TestUtil;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class RequestDemoPageTest extends TestBase {

    RequestDemoPageTest requestDemoPageTest;
    TopNavigation topNavigation;
    RequestDemoPage requestDemoPage;
    TestUtil testUtil;
    //String sheetName = "RequestDemo";

    public RequestDemoPageTest() throws IOException {
        super();

    }

    @BeforeSuite
    public void setUp() throws IOException {
        initialization();

        requestDemoPageTest = new RequestDemoPageTest();
        topNavigation = new TopNavigation(driver);
        requestDemoPage = new RequestDemoPage();
        topNavigation.clickRequestDemoPageLink();
        testUtil = new TestUtil();
    }

    @Test
    public void testReqDemoPage() throws IOException {
        requestDemoPage = topNavigation.clickRequestDemoPageLink();
        Path path = Paths.get("C:\\Users\\RICHA\\Documents\\GitHub\\Selenium\\Zoom\\src\\main\\resources\\data.csv");
        Scanner scanner = new Scanner(new FileInputStream(path.toFile()));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] split = line.split(",");
            requestDemoPage.keyInEmail(split[0]);
            requestDemoPage.keyInCompanyName(split[1]);
            requestDemoPage.keyInFirstName(split[2]);
            requestDemoPage.keyInLastName(split[3]);
        }
    }

    @Test()
    public void createNewReqDemoPageTest(){
        requestDemoPage.createNewRequestDemo("sf","sfc","sf","sfv");
    }

    @DataProvider(name = "companyDataProvider")
    public Object [][] companyData(){
        Object [][] data = {
                {
                        "abc@gmail.com","abc","rtg","hgbh"
                }
        };
        return data;
    }

    @Test()
    public void keyInMAilTest(){
        requestDemoPage.keyInEmail("uajncsndc");
    }


    @Test
    public void submitTest() {
        requestDemoPage.submit();
    }


    // @DataProvider
    // public Object[][] getZoomTestData(){
    //   Object data [][] = TestUtil.getTestData(sheetName);
    // return data;
    //}


    // @Test(dataProvider = "getZoomTestData")
    //public void createNewRequestDemoTest(String mail, String cname, String fname, String lname){
    // requestDemoPage.createNewRequestDemo("u@gmail.com","pragra","unnati","desai");
    //  requestDemoPage.createNewRequestDemo(mail, cname, fname, lname);
    //}


    //  @Test(dataProvider = "ZoomTestData", dataProviderClass = ExcelDataProvider.class)
    //public void createNewRequestDemoTest(String mail, String cname, String fname, String lname) {
    //  System.out.println(mail);
    //System.out.println(cname);
    //System.out.println(fname);
    //System.out.println(lname);
    //requestDemoPage.createNewRequestDemo(mail, cname, fname, lname);
    //}



}

