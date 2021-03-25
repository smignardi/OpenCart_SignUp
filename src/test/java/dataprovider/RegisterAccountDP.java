package dataprovider;

import org.testng.annotations.DataProvider;

public class RegisterAccountDP {


    @DataProvider(name = "correct fields")
    public Object[][] correctFields() {
        return new Object[][]{
                {"STEVEN", "MIGNARDI", "testaccount00012@gmail.com","940090223", "abc123","abc123"},
                {"STEVEN", "MIGNARDI", "testaccount00013@gmail.com","940090223", "abc123","abc123"}
        };
    }

    @DataProvider(name = "null fields")
    public Object[][] nullFields() {
        return new Object[][]{
                {null, "MIGNARDI", "river103@gmail.com","940090223", "abc123","abc123"},
                {"STEVEN", null, "river104@gmail.com","940090223", "abc123","abc123"},
                {"STEVEN", "MIGNARDI", null,"940090223", "abc123","abc123"},
                {"STEVEN", "MIGNARDI","river104@gmail.com",null, "abc123","abc123"},
                {"STEVEN", "MIGNARDI", "river104@gmail.com","940090223",null,"abc123"},
                {"STEVEN", "MIGNARDI", "river104@gmail.com","940090223", "abc123",null}
        };
    }


}
