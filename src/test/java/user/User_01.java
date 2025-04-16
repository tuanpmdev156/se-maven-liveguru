package user;

import common.BaseTest;
import common.DataFakerHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePO;
import pageObjects.MyAccountPO;
import pageObjects.PageGenerator;
import pageObjects.RegisterPO;

public class User_01 extends BaseTest {

    private WebDriver driver;
    private HomePO homePage;
    private RegisterPO registerPage;
    private MyAccountPO myAccountPage;
    private String firstName, lastName, emailAddress, password;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);
        firstName = DataFakerHelper.getFaker().name().firstName();
        lastName = DataFakerHelper.getFaker().name().lastName();
        emailAddress = DataFakerHelper.getFaker().internet().emailAddress();
        password = DataFakerHelper.getFaker().internet().password();
        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);
        System.out.println("emailAddress: " + emailAddress);
        System.out.println("password: " + password);

    }

    @Test
    public void TC_01_Register() {
        homePage.clickToAccountMenu();
        registerPage = homePage.clickToRegisterLink();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailAddressTextbox(emailAddress);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();
        myAccountPage = registerPage.clickContinueInAlertPopup();
        Assert.assertTrue(myAccountPage.isSuccessMessageDisplayed());
    }


    @Test
    public void TC_02_Verify_User_Information() {
        myAccountPage.clickToAccountInformationLink();
        Assert.assertEquals(myAccountPage.getUserFistName(),firstName);
        Assert.assertEquals(myAccountPage.getUserLastName(),lastName);
        Assert.assertEquals(myAccountPage.getUserEmailAddress(),emailAddress);
    }



    @AfterClass
    public void afterClass() {
        //closeBrowserDriver();
    }

}
