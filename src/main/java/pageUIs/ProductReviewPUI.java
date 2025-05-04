package pageUIs;

public class ProductReviewPUI {
    public static final String QUALITY_RATING = "xpath=//th[text()='Quality 1']/following-sibling::td[@class='value']//input[@value='%s']";
    public static final String SUMMARY_REVIEW_FIELD = "id=review_field";
    public static final String REVIEW_FIELD = "id=summary_field";
    public static final String SUBMIT_REVIEW_BTN = "xpath=//button[@title='Submit Review']";
    public static final String QUALITY_RATING_REQUIRED_MSG = "xpath=//div[@id='advice-validate-rating-validate_rating' and text()='%s']";
    public static final String REVIEW_FIELD_REQUIRED_MSG = "xpath=//textarea[@id='review_field']/following-sibling::div[text()='%s']";
    public static final String SUMMARY_REVIEW_FIELD_REQUIRED_MSG = "xpath=//input[@id='summary_field']/following-sibling::div[text()='%s']";
}
