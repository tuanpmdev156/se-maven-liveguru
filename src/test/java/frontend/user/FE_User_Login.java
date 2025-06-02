package frontend.user;

import common.BaseTest;
import common.CookiesArchive;
import common.StepLogger;
import common.User_Data_Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.FE_HomePO;
import pageObjects.FE_LoginPO;
import pageObjects.FE_MyAccountPO;
import pageObjects.PageGenerator;

public class FE_User_Login extends StepLogger {

    private WebDriver driver;
    private FE_HomePO homePage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        StepLogger.reset(); // Reset step
        logStep("BeforeClass","Open URL");
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);

    }

    @Test
    public void TC_03_Login() {
        StepLogger.reset(); // Reset step
        logStep("TC_03_Login","Click on ACCOUNT menu");
        homePage.clickToAccountMenu();
        logStep("TC_03_Login","Click on Login link");
        FE_LoginPO loginPage = homePage.clickToLoginLink();
        logStep("TC_03_Login","Insert login email: " + User_Data_Test.EMAIL_ADDRESS);
        loginPage.enterToFirstNameTextbox(User_Data_Test.EMAIL_ADDRESS);
        logStep("TC_03_Login","Insert login password: " + User_Data_Test.PASSWORD);
        loginPage.enterToPasswordTextbox(User_Data_Test.PASSWORD);
        loginPage.clickToLoginButton();
        FE_MyAccountPO myAccountPage = loginPage.confirmAlertPopup();
        logStep("TC_03_Login","Verify login successfully");
        verifyEquals(myAccountPage.getDashboardWelcomeText(),"Hello, "+ User_Data_Test.FIRST_NAME +" "+ User_Data_Test.LAST_NAME +"!");
        logStep("TC_03_Login","Get cookies after login");
        CookiesArchive.cookie = driver.manage().getCookies();
    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }

}
