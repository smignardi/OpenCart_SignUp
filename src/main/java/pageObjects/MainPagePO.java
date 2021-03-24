package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPagePO {
    private final WebDriver driver;

    @FindBy(xpath="//span[text()='My Account']")
    private WebElement btnMyAccount;


    @FindBy(xpath="//a[text()='Register']")
    private WebElement btnRegister;

    public MainPagePO(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void goToRegisterPage() throws InterruptedException {
        Thread.sleep(2000);
        btnMyAccount.click();
        Thread.sleep(2000);
        btnRegister.click();
        Thread.sleep(2000);
    }
}
