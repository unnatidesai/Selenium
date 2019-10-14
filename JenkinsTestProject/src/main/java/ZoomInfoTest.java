import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ZoomInfoTest {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\RICHA\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();


    }

    @BeforeTest
    public void OpenUrl(){
        driver.get("https://zoom.us/signin");
    }

    @Test
    public void testOpen(){

        driver.findElement(By.id("email")).sendKeys("unnatidesai1994@gmail.com");

        driver.findElement(By.id("password")).sendKeys("Unnati@23");

        driver.findElement(By.xpath("//a[@class='btn btn-primary submit signin user']")).click();

    }



}
