package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.FE_ProductReviewPUI;

public class FE_ProductReviewPO extends BasePage {
    WebDriver driver;

    public FE_ProductReviewPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clearReviewField() {
        waitForElementClickable(driver, FE_ProductReviewPUI.REVIEW_FIELD);
        clearElementText(driver, FE_ProductReviewPUI.REVIEW_FIELD);
    }

    public void clearSummaryReviewField() {
        waitForElementClickable(driver, FE_ProductReviewPUI.SUMMARY_REVIEW_FIELD);
        clearElementText(driver, FE_ProductReviewPUI.SUMMARY_REVIEW_FIELD);
    }

    public void clickToSubmitReviewBtn() {
        waitForElementClickable(driver, FE_ProductReviewPUI.SUBMIT_REVIEW_BTN);
        clickToElement(driver, FE_ProductReviewPUI.SUBMIT_REVIEW_BTN);
    }

    public boolean isQualityRatingRequiredMsgDisplayed(String requiredMsg) {
        waitForElementVisible(driver, FE_ProductReviewPUI.QUALITY_RATING_REQUIRED_MSG,requiredMsg);
        return isElementDisplayed(driver, FE_ProductReviewPUI.QUALITY_RATING_REQUIRED_MSG,requiredMsg);
    }

    public boolean isReviewRequiredMsgDisplayed(String requiredMsg) {
        waitForElementVisible(driver, FE_ProductReviewPUI.REVIEW_FIELD_REQUIRED_MSG,requiredMsg);
        return isElementDisplayed(driver, FE_ProductReviewPUI.REVIEW_FIELD_REQUIRED_MSG,requiredMsg);
    }

    public boolean isSummaryReviewRequiredMsgDisplayed(String requiredMsg) {
        waitForElementVisible(driver, FE_ProductReviewPUI.SUMMARY_REVIEW_FIELD_REQUIRED_MSG,requiredMsg);
        return isElementDisplayed(driver, FE_ProductReviewPUI.SUMMARY_REVIEW_FIELD_REQUIRED_MSG,requiredMsg);
    }
    public void selectQualityRatingRadioBtn(int rating) {
        waitForElementClickable(driver, FE_ProductReviewPUI.QUALITY_RATING,String.valueOf(rating));
        checkToCheckboxOrRadio(driver, FE_ProductReviewPUI.QUALITY_RATING, String.valueOf(rating));
    }

    public void enterToReviewField(String reviewData) {
        waitForElementClickable(driver, FE_ProductReviewPUI.REVIEW_FIELD);
        sendKeyToElement(driver, FE_ProductReviewPUI.REVIEW_FIELD,reviewData);
    }

    public void enterToSummaryReviewField(String summaryReviewData) {
        waitForElementClickable(driver, FE_ProductReviewPUI.SUMMARY_REVIEW_FIELD);
        sendKeyToElement(driver, FE_ProductReviewPUI.SUMMARY_REVIEW_FIELD,summaryReviewData);
    }
}
