package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
public class BaseTest extends DataFakerHelper{
        private WebDriver driver;

        public WebDriver getDriver() {
            return driver;
        }

        protected WebDriver getBrowserDriver(String browserName){
            BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
            switch (browser){
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;
                case CHROME:
                    driver = new ChromeDriver();
                    break;
                case EDGE:
                    driver = new EdgeDriver();
                    break;
                case SAFARI:
                    driver = new SafariDriver();
                    break;
                default:
                    throw new RuntimeException("Browser name is not valid");
            }
            return driver;
        }

        protected WebDriver getBrowserDriver(String browserName, String url){
            BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
            switch (browser){
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;
                case HFIREFOX:
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless");
                    firefoxOptions.addArguments("window-size=1920x1080");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case CHROME:
                    driver = new ChromeDriver();
                    break;
                case HCHROME:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    //chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("window-size=1920x1080");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case EDGE:
                    driver = new EdgeDriver();
                    break;
                case HEDGE:
                    EdgeOptions edgeOptions = new EdgeOptions();
                    //edgeOptions.addArguments("--headless");
                    edgeOptions.addArguments("window-size=1920x1080");
                    driver = new EdgeDriver(edgeOptions);
                    break;
                case SAFARI:
                    driver = new SafariDriver();
                    break;
                default:
                    throw new RuntimeException("Browser name is not valid");
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
            driver.get(url);
            driver.manage().window().maximize();
            return driver;
        }
        protected void closeBrowserDriver() {
            String cmd = null;
            try {
                String osName = System.getProperty("os.name").toLowerCase();

                String driverInstanceName = driver.toString().toLowerCase();

                String browserDriverName;

                if (driverInstanceName.contains("chrome")) {
                    browserDriverName = "chromedriver";
                } else if (driverInstanceName.contains("internetexplorer")) {
                    browserDriverName = "IEDriverServer";
                } else if (driverInstanceName.contains("firefox")) {
                    browserDriverName = "geckodriver";
                } else if (driverInstanceName.contains("edge")) {
                    browserDriverName = "msedgedriver";
                } else if (driverInstanceName.contains("opera")) {
                    browserDriverName = "operadriver";
                } else {
                    browserDriverName = "safaridriver";
                }

                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
                } else {
                    cmd = "pkill " + browserDriverName;
                }

                if (driver != null) {
                    driver.manage().deleteAllCookies();
                    driver.quit();
                }
            } catch (Exception e) {
                e.getMessage();
            } finally {
                try {
                    Process process = Runtime.getRuntime().exec(cmd);
                    process.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public int getRandomNumber(){
            Random ran = new Random();
            return ran.nextInt(9999);
        }

        @BeforeSuite
        public void deleteFileInReport() {
            // Remove all file in ReportNG screenshot (image)
            deleteAllFileInFolder("ReportNGScreenShots");
        }


        public void deleteAllFileInFolder(String folderName) {
            try {
                String pathFolderDownload = GlobalConstants.PROJECT_PATH + File.separator + folderName;
                File file = new File(pathFolderDownload);
                File[] listOfFiles = file.listFiles();
                if (listOfFiles.length != 0) {
                    for (File listOfFile : listOfFiles) {
                        if (listOfFile.isFile() && !listOfFile.getName().equals("environment.properties")) {
                            new File(listOfFile.toString()).delete();
                        }
                    }
                }
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
}

