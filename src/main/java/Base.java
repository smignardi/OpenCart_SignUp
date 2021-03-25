import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
    public WebDriver driver;

    public WebDriver initializeDriver() {
        System.setProperty("webdriver.chrome.driver","/Users/stevenmignardi/Desktop/TEST OKTANA/tools/chromedriver");
        this.driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }
}
