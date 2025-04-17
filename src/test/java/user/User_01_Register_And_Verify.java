package user;

import common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePO;
import pageObjects.MyAccountPO;
import pageObjects.PageGenerator;
import pageObjects.RegisterPO;

public class User_01_Register_And_Verify extends BaseTest {

    private WebDriver driver;
    private HomePO homePage;
    private RegisterPO registerPage;
    private MyAccountPO myAccountPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);
    }

    @Test
    public void TC_01_Register() {
        homePage.clickToAccountMenu();
        registerPage = homePage.clickToRegisterLink();
        registerPage.enterToFirstNameTextbox(User_Data.firstName);
        registerPage.enterToLastNameTextbox(User_Data.lastName);
        registerPage.enterToEmailAddressTextbox(User_Data.emailAddress);
        registerPage.enterToPasswordTextbox(User_Data.password);
        registerPage.enterToConfirmPasswordTextbox(User_Data.password);
        registerPage.clickToRegisterButton();
        myAccountPage = registerPage.confirmAlertPopup();
        verifyTrue(myAccountPage.isSuccessMessageDisplayed());
    }


    @Test
    public void TC_02_Verify_User_Information() {
        myAccountPage.clickToAccountInformationLink();
        verifyEquals(myAccountPage.getUserFistName(), User_Data.firstName);
        verifyEquals(myAccountPage.getUserLastName(), User_Data.lastName);
        verifyEquals(myAccountPage.getUserEmailAddress(), User_Data.emailAddress);
    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }

}
