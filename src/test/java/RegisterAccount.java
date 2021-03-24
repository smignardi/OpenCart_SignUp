import dataprovider.RegisterAccountDP;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.MainPagePO;
import pageObjects.RegisterAccountPO;

public class RegisterAccount extends Base{
    private RegisterAccountPO registerAccountPO;
    private MainPagePO mainPagePO;


    @BeforeTest
    public void Initialize() throws InterruptedException {
        driver=initializeDriver();
        registerAccountPO = new RegisterAccountPO(driver);
        mainPagePO = new MainPagePO(driver);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://demo.opencart.com");
        mainPagePO.goToRegisterPage();
    }

    //TEST DE DATA VACIA
    @Test(dataProvider = "null fields",dataProviderClass = RegisterAccountDP.class)
    public void testNullFields(String firstName,String lastName,String Email,String Phone,String Password,String PassConfirm) throws InterruptedException {

        registerAccountPO.registerLogin(firstName,lastName,Email,Phone,Password,PassConfirm);
        Assert.assertTrue(registerAccountPO.errorDisplayed());
    }

    //CREACION DE CUENTA DE FORMA CORRECTA
    @Test(dataProvider = "correct fields",dataProviderClass = RegisterAccountDP.class)
    public void testRegisterCorrectFieldsDP(String firstName,String lastName,String Email,String Phone,String Password,String PassConfirm) throws InterruptedException {

        registerAccountPO.registerLogin(firstName,lastName,Email,Phone,Password,PassConfirm);
        Assert.assertTrue(registerAccountPO.accountCreatedMessage());
    }

    @AfterMethod
    public void DeleteCookies() {
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
