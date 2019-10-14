package co.zoom.qa.testcases;

import co.zoom.qa.project.base.TestBase;
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


    @Test()
    public void createNewReqDemoPageTest() throws IOException {
        requestDemoPage = topNavigation.clickRequestDemoPageLink();
        requestDemoPage.createNewRequestDemo("sf","sfc","sf","sfv");
    }



    @Test()
    public void clickTest() throws IOException {

        requestDemoPage = topNavigation.clickRequestDemoPageLink();
        requestDemoPage.keyInEmail("jadsnvkj");
    }

    @Test
    public void submitTest() {
        requestDemoPage.submit();
    }






}

