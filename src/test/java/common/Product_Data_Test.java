package common;

public class Product_Data_Test extends DataFakerHelper{
   
    public static final String SUMMARY_REVIEW_DATA = getFaker().lorem().sentence(3);;
    public static final String YOUR_THOUGHT = getFaker().lorem().paragraph();
    public static final int QUALITY_RATING = getFaker().number().numberBetween(1,5);
    public static final String SEARCH_PRICE_FROM = "151";
    public static final String SEARCH_PRICE_TO = "1000";
    public static String COUPLE_CODE = "GURU50";
    public static String PRODUCT_NAME = "Sony Xperia";
    public static String PRODUCT_QUANTITY = "501";
}
