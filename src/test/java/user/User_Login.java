package user;

import common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.MyAccountPO;
import pageObjects.PageGenerator;

public class User_Login extends BaseTest {

    private WebDriver driver;
    private HomePO homePage;
    private LoginPO loginPage;
    private MyAccountPO myAccountPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        writeLog("User_Login - Step 01: Open URL");
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);

    }

    @Test
    public void TC_03_Login() {
        writeLog("User_Login - Step 02: Click on ACCOUNT menu");
        homePage.clickToAccountMenu();
        writeLog("User_Login - Step 03: Click on Login link");
        loginPage = homePage.clickToLoginLink();
        writeLog("User_Login - Step 04: Insert login email: " + User_Data.emailAddress);
        loginPage.enterToFirstNameTextbox(User_Data.emailAddress);
        writeLog("User_Login - Step 05: Insert login password: " + User_Data.password);
        loginPage.enterToPasswordTextbox(User_Data.password);
        loginPage.clickToLoginButton();
        myAccountPage = loginPage.confirmAlertPopup();
        writeLog("User_Login - Step 06: Verify login successfully");
        verifyEquals(myAccountPage.getDashboardWelcomeText(),"Hello, "+User_Data.firstName+" "+User_Data.lastName+"!");
    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }

}
