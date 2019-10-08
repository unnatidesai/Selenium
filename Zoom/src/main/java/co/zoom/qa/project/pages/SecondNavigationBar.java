package co.zoom.qa.project.pages;


import co.zoom.qa.project.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SecondNavigationBar extends TestBase {

    WebDriver driver;

    @FindBy(css = "li[class='dropdown mobile-hide']>a[id='btnSolutions']")
    private WebElement solutions;

    @FindBy(css = "a[href*='meetings']")
    private WebElement meetingsAndChat;

    @FindBy(css = "a[href*='zoomrooms']")
    private WebElement roomsAndWorkspaces;

    @FindBy(css = "a[href=\"https://zoom.us/phonesystem\"]")
    private WebElement phoneSystem;

    @FindBy(xpath="//*[@id='first-col-nav']/div/a[4]")
    private  WebElement videoWebinars;

    @FindBy(css ="a[href*='https://marketplace.zoom.us']")
    private WebElement appMarketPlace;

    @FindBy(xpath ="a[href*='education']")
    private WebElement education;

    @FindBy(css = "a[href*='finance']")
    private WebElement finance;

    @FindBy(xpath = "//a[text()='Government']")
    private WebElement government;

    @FindBy(css = "a[href*='healthcare']")
    private WebElement healthcare;

    @FindBy(xpath = "//a[contains(text(),'Plans & Pricing') and @role ='menuitem']")
    private WebElement plansAndPricing;

    @FindBy(xpath = "//a[contains(text(),'Contact Sales') and @role ='menuitem']")
    private WebElement contactSales;

    @FindBy(xpath = "//a[contains(text(),'Read our blog')]")
    private WebElement readOurBlog;

    @FindBy(xpath = "//a[contains(text(),'JOIN A MEETING')]")
    private WebElement joinAMeeting;

    @FindBy(xpath = "//a[contains(text(),'HOST A MEETING ')]")
    private WebElement hostAMeeting;

    @FindBy(xpath = "//a[contains(text(),'SIGN IN')]")
    private WebElement signIn;

    @FindBy(xpath = "//a[contains(@class,'btn btn-primary signupfree')]")
    private WebElement signUp;


    public SecondNavigationBar(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public MeetingsAndChatPage clickMeetingChat() {
        Actions actions = new Actions(driver);
        actions.moveToElement(solutions).moveToElement(meetingsAndChat).click().build().perform();
        return new MeetingsAndChatPage();
    }

    public RoomsAndWorkspacesPage clickRoomsAndWorkspaces(){
        Actions actions = new Actions(driver);
        actions.moveToElement(solutions).moveToElement(roomsAndWorkspaces).click().build().perform();
        return new RoomsAndWorkspacesPage();
    }

    public PhoneSystemPage clickPhoneSystem(){

        Actions actions = new Actions(driver);
        actions.moveToElement(solutions).moveToElement(phoneSystem).click().perform();
        return new PhoneSystemPage();
    }

    public VideoWebinarsPage clickVideoWebinars(){
        Actions actions=new Actions(driver);
        actions.moveToElement(solutions);
        actions.build().perform();
        actions.moveToElement(videoWebinars).click().perform();
        return new VideoWebinarsPage();
    }

    public AppMarketplacePage clickAllMarketplace(){
        Actions actions = new Actions(driver);
        actions.moveToElement(solutions).moveToElement(appMarketPlace).click().perform();
        return new AppMarketplacePage();
    }

    public EducationPage clickEducation(){
        Actions actions = new Actions(driver);
        actions.moveToElement(solutions).moveToElement(education).click().perform();
        return new EducationPage();
    }

    public FinancePage clickFinance(){
        Actions actions = new Actions(driver);
        actions.moveToElement(solutions).moveToElement(finance).click().perform();
        return new FinancePage();
    }

    public GovernmentPage clickGovernment(){
        Actions actions = new Actions(driver);
        actions.moveToElement(solutions).moveToElement(government).click().perform();
        return new GovernmentPage();
    }

    public HealthcarePage clickHealthcare(){
        Actions actions = new Actions(driver);
        actions.moveToElement(solutions).moveToElement(healthcare).click().perform();
        return new HealthcarePage();
    }

    public PlansAndPricingPage clickPlansAndPricing(){
        this.plansAndPricing.click();
        return new PlansAndPricingPage();
    }

    public ContactSales clickContactSales(){
        this.contactSales.click();
        return new ContactSales();
    }

    public ReadOurBlogPage clickReadOurBlogLabel(){
        this.readOurBlog.click();
        return new ReadOurBlogPage();
    }

    public JoinAMeetingPage clickJoinAMeeting(){
        this.joinAMeeting.click();
        return new JoinAMeetingPage();
    }

    public HostAMeetingPage clickHostAMeeting(){
        this.hostAMeeting.click();
        return new HostAMeetingPage();
    }

    public SignInPage clickSignIn() throws IOException{
        this.signIn.click();
        return new SignInPage();
    }

    public SignUpPage clickSignUpBtn() throws IOException {
        this.signUp.click();
        return new SignUpPage();
    }


}