import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;


public class Base {
    public WebDriver driver;

    public WebDriver initializeDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/stevenmignardi/Desktop/TEST OKTANA/tools/chromedriver");
        this.driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }
}
