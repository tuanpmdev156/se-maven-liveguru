package FE.user;

import common.BaseTest;
import common.User_Data_Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePO;
import pageObjects.MyAccountPO;
import pageObjects.PageGenerator;
import pageObjects.RegisterPO;

public class User_Register extends BaseTest {

    private WebDriver driver;
    private HomePO homePage;
    private RegisterPO registerPage;
    private MyAccountPO myAccountPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        writeLog("Register - Step 01: Open URL");
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);
    }

    @Test
    public void TC_01_Register() {
        writeLog("Register - Step 02: Click on ACCOUNT menu");
        homePage.clickToAccountMenu();
        writeLog("Register - Step 03: Click on Register link");
        registerPage = homePage.clickToRegisterLink();
        writeLog("Register - Step 04: Register with firstname: " + User_Data_Test.FIRST_NAME);
        registerPage.enterToFirstNameTextbox(User_Data_Test.FIRST_NAME);
        writeLog("Register - Step 05: Register with lastname: " + User_Data_Test.LAST_NAME);
        registerPage.enterToLastNameTextbox(User_Data_Test.LAST_NAME);
        writeLog("Register - Step 06: Register with email: " + User_Data_Test.EMAIL_ADDRESS);
        registerPage.enterToEmailAddressTextbox(User_Data_Test.EMAIL_ADDRESS);
        writeLog("Register - Step 07: Register with password: " + User_Data_Test.PASSWORD);
        registerPage.enterToPasswordTextbox(User_Data_Test.PASSWORD);
        registerPage.enterToConfirmPasswordTextbox(User_Data_Test.PASSWORD);
        registerPage.clickToRegisterButton();
        myAccountPage = registerPage.confirmAlertPopup();
        writeLog("Register - Step 08: Verify register successful");
        verifyTrue(myAccountPage.isSuccessMessageDisplayed());
    }


    @Test
    public void TC_02_Verify_User_Information() {
        writeLog("Register - Step 09: Open Account Information Link");
        myAccountPage.clickToAccountInformationLink();
        writeLog("Register - Step 10: Get Information and Verify information");
        verifyEquals(myAccountPage.getUserFistName(), User_Data_Test.FIRST_NAME);
        verifyEquals(myAccountPage.getUserLastName(), User_Data_Test.LAST_NAME);
        verifyEquals(myAccountPage.getUserEmailAddress(), User_Data_Test.EMAIL_ADDRESS);
    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }

}
