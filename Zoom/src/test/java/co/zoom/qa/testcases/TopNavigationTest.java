package co.zoom.qa.testcases;

import co.zoom.qa.project.base.TestBase;
import co.zoom.qa.project.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class TopNavigationTest extends TestBase {


    DownloadZoomClientPage downloadZoomClientPage;
    FaqPage faqPage;
    LiveTrainingPage liveTrainingPage;
    Num1888Page num1888Page;
    RequestDemoPage requestDemoPage;
    ResourcesPage resourcesPage;
    SupportPage supportPage;
    TopNavigation topNavigation;
    VideoTutorialsPage videoTutorialsPage;
    WebinarsAndEventsPage webinarsAndEventsPage;
    ZoomBlogPage zoomBlogPage;

    public TopNavigationTest() throws IOException {

    super();
    }

    @BeforeMethod
    public void setUp()throws IOException{
        initialization();
        topNavigation = new TopNavigation(driver) ;

    }

    @Test
    public void clickRequestDemoPageLinkTest() throws IOException{
        requestDemoPage = topNavigation.clickRequestDemoPageLink();
    }

    @Test
    public void clickNum1888PageLinkTest(){
        num1888Page = topNavigation.clickNum1888PageLink();
    }

    @Test
    public void clickResourcesPageLinkTest(){
        resourcesPage = topNavigation.clickResourcesPageLink();
    }

    @Test
    public void clickDownloadZoomClientPageLinkTest(){
        downloadZoomClientPage = topNavigation.clickDownloadZoomClientPageLink();
    }

    @Test
    public void clickVideoTutorialPageLink() {
        videoTutorialsPage = topNavigation.clickVideoTutorialPageLink();
    }

    @Test
    public void clickLiveTrainingPageLinkTest() {
        liveTrainingPage = topNavigation.clickLiveTrainingPageLink();
    }

    @Test
    public void clickWebinaraAndEventsLinkTest(){
        webinarsAndEventsPage = topNavigation.clickWebinaraAndEventsLink();
    }

    @Test
    public void clickZoomBlogLinkTest(){
        zoomBlogPage = topNavigation.clickZoomBlogLink();
    }

    @Test
    public void clickFaqLinkTest(){
        faqPage = topNavigation.clickFaqLink();
    }

    @Test
    public void clickSupportPageLink(){
        supportPage = topNavigation.clickSupportPageLink();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
