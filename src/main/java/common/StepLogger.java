package common;

public class StepLogger extends BaseTest{
    private static int stepCounter = 1;

    public void logStep(String testName, String actionDescription) {
        writeLog(testName + " - Step " + String.format("%02d", stepCounter++) + ": " + actionDescription);
    }

    public static void reset() {
        stepCounter = 1;
    }
}
