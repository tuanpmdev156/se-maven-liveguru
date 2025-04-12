package user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LoginPO;
import pageObjects.PageGenerator;

public class User_01 extends BaseTest {

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        System.out.println(">>> Getting browser driver...");
        driver = getBrowserDriver(browserName, url);
        System.out.println(">>> Driver initialized.");

    }

    @Test
    public void TC_01_Register(){

    }





    @AfterClass
    public void afterClass(){
        closeBrowserDriver();
    }

    private WebDriver driver;
    private LoginPO loginPage;

}
