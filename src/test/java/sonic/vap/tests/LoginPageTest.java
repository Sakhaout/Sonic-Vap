package sonic.vap.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sonic.vap.base.BaseClass;

public class LoginPageTest extends BaseClass {

    @BeforeTest
    public void testSetUp() {
        driverInitialization();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    @Test
    public void titleValidation() {
        System.out.println("Title: " + driver.getTitle());
    }
}
