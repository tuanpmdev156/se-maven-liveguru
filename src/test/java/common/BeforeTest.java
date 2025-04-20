package common;

import org.testng.annotations.BeforeSuite;

import java.io.File;

public class BeforeTest {
    @BeforeSuite
    public void cleanAllureResultsFolder() {
        File folder = new File("allure-results");
        if (folder.exists() && folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                    file.delete();
            }
        }
    }
    @BeforeSuite
    public void cleanLogsFolder() {
        File folder = new File("logs");
        if (folder.exists() && folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                file.delete();
            }
            }
        }
    }

