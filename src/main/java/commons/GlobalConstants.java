package commons;

public class GlobalConstants {
    // SYSTEM INFO
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String SEPARATOR =  System.getProperty("file.separator");

    // WAIT INFO
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 20;

    // DOWNLOAD OR UPLOAD FILE
    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR + "uploadFiles" + SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR + "downloadFiles" + SEPARATOR;

    // BROWSER LOGS
    public static final String BROWSER_LOG = PROJECT_PATH + SEPARATOR + "downloadFiles";
    public static final String DRAG_DROP_HTML5 = PROJECT_PATH + SEPARATOR + "dragDropHTML5";

    // RETRY CASE FAILED
    public static final long RETRY_TEST_FAIL = 3;

    // HTML Report Folder
    public static final String REPORTNG_PATH = PROJECT_PATH + SEPARATOR + "htmlReportNG" + SEPARATOR;
    public static final String EXTENT_PATH = PROJECT_PATH + SEPARATOR + "htmlExtent" + SEPARATOR;
    public static final String ALLURE_PATH = PROJECT_PATH + SEPARATOR + "htmlAllure" + SEPARATOR;

    // Admin Info
    public static final String ADMIN_ORANGE_HRM_USERNAME = "Admin";
    public static final String ADMIN_ORANGE_HRM_PASSWORD = "admin123";

}
