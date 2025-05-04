package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.ProductReviewPUI;

public class ProductReviewPO extends BasePage {
    WebDriver driver;

    public ProductReviewPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clearReviewField() {
        waitForElementClickable(driver, ProductReviewPUI.REVIEW_FIELD);
        clearElementText(driver, ProductReviewPUI.REVIEW_FIELD);
    }

    public void clearSummaryReviewField() {
        waitForElementClickable(driver, ProductReviewPUI.SUMMARY_REVIEW_FIELD);
        clearElementText(driver, ProductReviewPUI.SUMMARY_REVIEW_FIELD);
    }

    public void clickToSubmitReviewBtn() {
        waitForElementClickable(driver, ProductReviewPUI.SUBMIT_REVIEW_BTN);
        clickToElement(driver, ProductReviewPUI.SUBMIT_REVIEW_BTN);
    }

    public boolean isQualityRatingRequiredMsgDisplayed(String requiredMsg) {
        waitForElementVisible(driver, ProductReviewPUI.QUALITY_RATING_REQUIRED_MSG,requiredMsg);
        return isElementDisplayed(driver,ProductReviewPUI.QUALITY_RATING_REQUIRED_MSG,requiredMsg);
    }

    public boolean isReviewRequiredMsgDisplayed(String requiredMsg) {
        waitForElementVisible(driver, ProductReviewPUI.REVIEW_FIELD_REQUIRED_MSG,requiredMsg);
        return isElementDisplayed(driver,ProductReviewPUI.REVIEW_FIELD_REQUIRED_MSG,requiredMsg);
    }

    public boolean isSummaryReviewRequiredMsgDisplayed(String requiredMsg) {
        waitForElementVisible(driver, ProductReviewPUI.SUMMARY_REVIEW_FIELD_REQUIRED_MSG,requiredMsg);
        return isElementDisplayed(driver,ProductReviewPUI.SUMMARY_REVIEW_FIELD_REQUIRED_MSG,requiredMsg);
    }
    public void selectQualityRatingRadioBtn(int rating) {
        waitForElementClickable(driver,ProductReviewPUI.QUALITY_RATING,String.valueOf(rating));
        checkToCheckboxOrRadio(driver,ProductReviewPUI.QUALITY_RATING, String.valueOf(rating));
    }

    public void enterToReviewField(String reviewData) {
        waitForElementClickable(driver,ProductReviewPUI.REVIEW_FIELD);
        sendKeyToElement(driver,ProductReviewPUI.REVIEW_FIELD,reviewData);
    }

    public void enterToSummaryReviewField(String summaryReviewData) {
        waitForElementClickable(driver,ProductReviewPUI.SUMMARY_REVIEW_FIELD);
        sendKeyToElement(driver,ProductReviewPUI.SUMMARY_REVIEW_FIELD,summaryReviewData);
    }
}
