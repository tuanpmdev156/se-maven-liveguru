package common;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class User_Data_Test {
    public static String FIRST_NAME;
    public static String LAST_NAME;
    public static String EMAIL_ADDRESS;
    public static String PASSWORD;

    static{
        Properties props = new Properties();
        File file = new File("src/test/resources/user_data.properties");
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                props.load(reader);
                FIRST_NAME = props.getProperty("firstName");
                LAST_NAME = props.getProperty("lastName");
                EMAIL_ADDRESS = props.getProperty("email");
                PASSWORD = props.getProperty("password");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // If file does not exist, generate new dataset
            FIRST_NAME = DataFakerHelper.getFaker().name().firstName();
            LAST_NAME = DataFakerHelper.getFaker().name().lastName();
            EMAIL_ADDRESS = DataFakerHelper.getFaker().internet().emailAddress();
            PASSWORD = DataFakerHelper.getFaker().internet().password();

            // Save data into file after generating new dataset
            try (FileWriter writer = new FileWriter(file)) {
                props.setProperty("firstName", FIRST_NAME);
                props.setProperty("lastName", LAST_NAME);
                props.setProperty("email", EMAIL_ADDRESS);
                props.setProperty("password", PASSWORD);
                props.store(writer, "Generated user data");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
