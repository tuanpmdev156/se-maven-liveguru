package frontend.user;

import common.BaseTest;
import common.StepLogger;
import common.User_Data_Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.FE_HomePO;
import pageObjects.FE_MyAccountPO;
import pageObjects.PageGenerator;
import pageObjects.FE_RegisterPO;

public class FE_User_Register extends StepLogger {

    private FE_HomePO homePage;
    private FE_MyAccountPO myAccountPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        StepLogger.reset(); // Reset step
        logStep("BeforeClass","Open URL");
        WebDriver driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);
    }

    @Test
    public void TC_01_Register() {
        StepLogger.reset(); // Reset step
        logStep("TC_01_Register","Click on ACCOUNT menu");
        homePage.clickToAccountMenu();
        logStep("TC_01_Register","Click on Register link");
        FE_RegisterPO registerPage = homePage.clickToRegisterLink();
        logStep("TC_01_Register","Register with firstname: " + User_Data_Test.FIRST_NAME);
        registerPage.enterToFirstNameTextbox(User_Data_Test.FIRST_NAME);
        logStep("TC_01_Register","Register with lastname: " + User_Data_Test.LAST_NAME);
        registerPage.enterToLastNameTextbox(User_Data_Test.LAST_NAME);
        logStep("TC_01_Register","Register with email: " + User_Data_Test.EMAIL_ADDRESS);
        registerPage.enterToEmailAddressTextbox(User_Data_Test.EMAIL_ADDRESS);
        logStep("TC_01_Register","Register with password: " + User_Data_Test.PASSWORD);
        registerPage.enterToPasswordTextbox(User_Data_Test.PASSWORD);
        registerPage.enterToConfirmPasswordTextbox(User_Data_Test.PASSWORD);
        registerPage.clickToRegisterButton();
        myAccountPage = registerPage.confirmAlertPopup();
        logStep("TC_01_Register","Verify register successful");
        verifyTrue(myAccountPage.isSuccessMessageDisplayed());
    }


    @Test
    public void TC_02_Verify_User_Information() {
        StepLogger.reset(); // Reset step
        logStep("TC_02_Verify_User_Information","Open Account Information Link");
        myAccountPage.clickToAccountInformationLink();
        logStep("TC_02_Verify_User_Information","Get Information and Verify information");
        verifyEquals(myAccountPage.getUserFistName(), User_Data_Test.FIRST_NAME);
        verifyEquals(myAccountPage.getUserLastName(), User_Data_Test.LAST_NAME);
        verifyEquals(myAccountPage.getUserEmailAddress(), User_Data_Test.EMAIL_ADDRESS);
    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }

}
