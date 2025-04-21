package user;

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
        writeLog("Register - Step 04: Register with firstname: " + User_Data_Test.firstName);
        registerPage.enterToFirstNameTextbox(User_Data_Test.firstName);
        writeLog("Register - Step 05: Register with lastname: " + User_Data_Test.lastName);
        registerPage.enterToLastNameTextbox(User_Data_Test.lastName);
        writeLog("Register - Step 06: Register with email: " + User_Data_Test.emailAddress);
        registerPage.enterToEmailAddressTextbox(User_Data_Test.emailAddress);
        writeLog("Register - Step 07: Register with password: " + User_Data_Test.password);
        registerPage.enterToPasswordTextbox(User_Data_Test.password);
        registerPage.enterToConfirmPasswordTextbox(User_Data_Test.password);
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
        verifyEquals(myAccountPage.getUserFistName(), User_Data_Test.firstName);
        verifyEquals(myAccountPage.getUserLastName(), User_Data_Test.lastName);
        verifyEquals(myAccountPage.getUserEmailAddress(), User_Data_Test.emailAddress);
    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }

}
