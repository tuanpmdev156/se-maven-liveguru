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

public class User_02_Login extends BaseTest {

    private WebDriver driver;
    private HomePO homePage;
    private LoginPO loginPage;
    private MyAccountPO myAccountPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);

    }

    @Test
    public void TC_03_Login() {
        homePage.clickToAccountMenu();
        loginPage = homePage.clickToLoginLink();
        loginPage.enterToFirstNameTextbox(User_Data.emailAddress);
        loginPage.enterToLastNameTextbox(User_Data.password);
        loginPage.clickToLoginButton();
        myAccountPage = loginPage.confirmAlertPopup();
        verifyEquals(myAccountPage.getDashboardWelcomeText(),"Hello, "+User_Data.firstName+" "+User_Data.lastName+"!");
    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }

}
