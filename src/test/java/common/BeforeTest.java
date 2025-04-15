package common;

import org.testng.annotations.BeforeSuite;

import java.io.File;

public class BeforeTest {
    @BeforeSuite
    public void cleanAllureResults() {
        File folder = new File("allure-results");
        if (folder.exists() && folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                if (file.getName().endsWith(".json")) {
                    file.delete();
                }
            }
            System.out.println("Old Allure JSON files deleted.");
        }
    }
}
