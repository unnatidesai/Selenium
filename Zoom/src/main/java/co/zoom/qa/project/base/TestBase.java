package co.zoom.qa.project.base;

import co.zoom.qa.project.utils.TestUtil;
import co.zoom.qa.project.utils.WebEventListener;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {

    private final Logger logger = LogManager.getLogger(TestBase.class);
    public static WebDriver driver;
    public static Properties prop;


    public TestBase() throws IOException {

        try {

            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\RICHA\\Documents\\GitHub\\Selenium\\Zoom\\src\\main\\java\\co\\zoom\\qa\\project\\config\\config.properties");
            prop.load(ip);
        }   catch (FileNotFoundException e) {
            e.printStackTrace();
        }   catch (IOException e) {
                e.printStackTrace();
        }

    }

    protected static WebDriver driver() {
        return driver;
    }

    public void initialization() throws IOException {

        logger.log(Level.INFO,"Using executable from path {} for chrome",prop.getProperty("browser"));

        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\RICHA\\Selenium\\chromedriver.exe");
            logger.log(Level.INFO, "Found Match for {} browser",System.setProperty("webdriver.chrome.driver","C:\\Users\\RICHA\\Selenium\\chromedriver.exe"));
            driver = new ChromeDriver();
        }
        else if (browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","C:\\Users\\RICHA\\Selenium\\geckodriver.exe");
            driver = new FirefoxDriver();
        }


        EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        WebEventListener eventListener = new WebEventListener() {
            @Override
            public void onException(Throwable throwable, WebDriver driver) {

            }
        };
        e_driver.register(eventListener);
        driver = e_driver;


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("appUrl"));

    }
}
