import dataprovider.OperCartRegisterAccount_DataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.MainPage;
import pageObjects.OpenCart_RegisterAccount;

public class OpenCartRegisterAccount extends Base{
    private OpenCart_RegisterAccount openCart_registerAccount;
    private MainPage mainPage;

    @BeforeTest
    public void Initialize() throws InterruptedException {
        driver=initializeDriver();
        openCart_registerAccount = new OpenCart_RegisterAccount(driver);
        mainPage = new MainPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get("https://demo.opencart.com");
        Thread.sleep(2000);
        mainPage.goToRegisterPage();
    }


    @Test
    public void testRegisterCorrectFields() throws InterruptedException {

        openCart_registerAccount = new OpenCart_RegisterAccount(driver);
        openCart_registerAccount.registerLogin("a","b","aste125@gmail.com","940090223","abc123","abc123");
        Assert.assertTrue(openCart_registerAccount.accountCreatedMessage());
    }

    @Test(dataProvider = "correct fields",dataProviderClass = OperCartRegisterAccount_DataProvider.class)
    public void testRegisterCorrectFieldsDP(String firstName,String lastName,String Email,String Phone,String Password,String PassConfirm) throws InterruptedException {

        openCart_registerAccount = new OpenCart_RegisterAccount(driver);
        openCart_registerAccount.registerLogin(firstName,lastName,Email,Phone,Password,PassConfirm);
        Assert.assertTrue(openCart_registerAccount.accountCreatedMessage());
    }



    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
