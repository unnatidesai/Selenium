package co.zoom.qa.project.pages;

import co.zoom.qa.project.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class TopNavigation extends TestBase {

    WebDriver driver;

    @FindBy(css = "#black-topbar ul>li>a[href='https://zoom.us/livedemo']")
    private WebElement requstADemoLink;

    @FindBy(css = "a[href='tel:1.888.799.9666'")
    private WebElement num1800Link;

    @FindBy(css = "#btnResouces")
    private WebElement resources;

    @FindBy(css = "a[href='https://zoom.us/events'")
    private WebElement webinarsAndEvents;

    @FindBy(xpath = "//*[@id=\"resourcesDropdown\"]/li[9]/a")
    private WebElement zoomBlog;

    @FindBy(css = "a[href='https://support.zoom.us/hc/en-us/articles/206618765-Zoom-Video-Tutorials']")
    private WebElement videoTutorial;

    @FindBy(css = "a[href='https://zoom.us/livetraining'")
    private WebElement liveTraining;

    @FindBy(css = "a[href='https://zoom.us/download#client_4meeting'")
    private WebElement downloadZoomClient;

    @FindBy(css = "a[href='https://support.zoom.us/hc/en-us/articles/206175806-Top-Questions'")
    private WebElement faq;

    @FindBy(css = "a[href='https://support.zoom.us/hc/en-us'")
    private WebElement support;

    public TopNavigation(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public RequestDemoPage clickRequestDemoPageLink() throws IOException{
        this.requstADemoLink.click();
        return new RequestDemoPage();
    }

    public Num1888Page clickNum1888PageLink(){
        this.num1800Link.click();
        return new Num1888Page();
    }

    public ResourcesPage clickResourcesPageLink(){
        this.resources.click();
        return new ResourcesPage();
    }

    public DownloadZoomClientPage clickDownloadZoomClientPageLink(){
        Actions actions = new Actions(driver);
        actions.moveToElement(resources).moveToElement(downloadZoomClient).click().perform();
        return new DownloadZoomClientPage();
    }

    public VideoTutorialsPage clickVideoTutorialPageLink(){
        Actions actions = new Actions(driver);
        actions.moveToElement(resources).moveToElement(videoTutorial).click().perform();
        return new VideoTutorialsPage();
    }

    public LiveTrainingPage clickLiveTrainingPageLink(){
        Actions actions = new Actions(driver);
        actions.moveToElement(resources).moveToElement(liveTraining).click().perform();
        return new LiveTrainingPage();
    }

    public WebinarsAndEventsPage clickWebinaraAndEventsLink(){
        Actions actions = new Actions(driver);
        actions.moveToElement(resources).moveToElement(webinarsAndEvents).click().perform();
        return new WebinarsAndEventsPage();
    }

    public ZoomBlogPage clickZoomBlogLink(){
        Actions actions=new Actions(driver);
        actions.moveToElement(resources).moveToElement(zoomBlog).click().perform();
        return new ZoomBlogPage();
    }

    public FaqPage clickFaqLink(){
        Actions actions = new Actions(driver);
        actions.moveToElement(resources).moveToElement(faq).click().perform();
        return new FaqPage();
    }

    public SupportPage clickSupportPageLink(){
        this.support.click();
        return new SupportPage();
    }

}


