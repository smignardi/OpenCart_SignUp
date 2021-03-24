package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPO {
    private final WebDriver driver;

    @FindBy(id="input-firstname")
    private WebElement inputFirstname;

    @FindBy(id="input-lastname")
    private WebElement inputLastname;

    @FindBy(id="input-email")
    private WebElement inputEmail;

    @FindBy(id="input-telephone")
    private WebElement inputPhone;

    @FindBy(id="input-password")
    private WebElement inputPassword;

    @FindBy(id="input-confirm")
    private WebElement inputPasswordConfirm;

    @FindBy(xpath="//input[@name='agree']")
    private WebElement checkPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement btnContinue;

    @FindBy(xpath = "//div[@class='form-group required has-error']")
    private WebElement lblErrorMessage;

    @FindBy(xpath = "//div/h1[text()='Your Account Has Been Created!']")
    private WebElement lblAccountCreatedMessage;

    public boolean errorDisplayed(){
        return lblErrorMessage.isDisplayed();
    }

    public boolean accountCreatedMessage(){
        return lblAccountCreatedMessage.isDisplayed();
    }

    public RegisterAccountPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void registerLogin(String firstName,String lastName,String Email,String Phone,String Password,String PasswConfirm) throws InterruptedException {
        inputFirstname.clear();
        if(firstName!=null){
            inputFirstname.sendKeys(firstName);}

        inputLastname.clear();
        if(lastName!=null){
            inputLastname.sendKeys(lastName);}

        inputEmail.clear();
        if(Email!=null){
            inputEmail.sendKeys(Email);}

        inputPhone.clear();
        if(Phone!=null){
            inputPhone.sendKeys(Phone);}

        inputPassword.clear();
        if(Password!=null){
            inputPassword.sendKeys(Password);}

        inputPasswordConfirm.clear();
        if(PasswConfirm!=null){
            inputPasswordConfirm.sendKeys(PasswConfirm);}

        checkPolicy.click();

        Thread.sleep(2000);
        btnContinue.click();



    }
}
