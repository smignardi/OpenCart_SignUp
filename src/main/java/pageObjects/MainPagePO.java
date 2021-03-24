package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPagePO {
    private final WebDriver driver;

    @FindBy(xpath="//span[text()='My Account']")
    private WebElement btnMyAccount;


    @FindBy(xpath="//a[text()='Register']")
    private WebElement btnRegister;

    @FindBy(xpath="//div/h1[text()='Register Account']")
    private WebElement lblRegisterAccount;


    public MainPagePO(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void goToRegisterPage() {
        WebDriverWait esperaExplicita = new WebDriverWait(driver,5);
        esperaExplicita.until(ExpectedConditions.visibilityOf(btnMyAccount));

        btnMyAccount.click();
        esperaExplicita.until(ExpectedConditions.visibilityOf(btnRegister));

        btnRegister.click();
        esperaExplicita.until(ExpectedConditions.visibilityOf(lblRegisterAccount));
    }
}
