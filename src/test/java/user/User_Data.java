package user;

import common.DataFakerHelper;

public class User_Data {

    protected static String firstName = DataFakerHelper.getFaker().name().firstName();
    protected static String lastName = DataFakerHelper.getFaker().name().lastName();
    protected static String emailAddress = DataFakerHelper.getFaker().internet().emailAddress();
    protected static String password = DataFakerHelper.getFaker().internet().password();

}
