package pageFactory;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AppManager {

    public Properties properties;
    public static String BROWSER = "";
    public static String DB_URL = "";
    public static String DB_USERNAME = "";
    public static String DB_PASSWORD = "";
    public static String BASE_URL;
    public static String USER_STANDART_LOGIN = "";
    public static String USER_STANDART_PASSWORD = "";
    public static String USER_AUTH_LOGIN = "";
    public static String USER_AUTH_PASSWORD = "";
    public static String CUSTOMER_FIRST_NAME = "";
    public static String CUSTOMER_LAST_NAME = "";
    public static String CUSTOMER_ADDRESS = "";
    public static String CUSTOMER_POSTCODE = "";
    public static String CUSTOMER_CITY = "";
    public static String CUSTOMER_EMAIL = "";
    public static String CUSTOMER_PHONE = "";

    public AppManager() {
        properties = new Properties();
    }

    public void init() {
        getDataFromPropertiesFile();
    }

    public void getDataFromPropertiesFile() {
        try {
            properties.load(new FileReader("/Users/bprysiazhnyi/IdeaProjects/Purchase-Service-automation/src/main/resources/config.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        BROWSER = properties.getProperty("browser");
        DB_URL = properties.getProperty("db_url");
        DB_USERNAME = properties.getProperty("db_username");
        DB_PASSWORD = properties.getProperty("db_password");
        BASE_URL = properties.getProperty("baseUrl");
        USER_AUTH_LOGIN = properties.getProperty("userAuthLogin");
        USER_AUTH_PASSWORD = properties.getProperty("userAuthPassword");
        USER_STANDART_LOGIN = properties.getProperty("userStandartLogin");
        USER_AUTH_PASSWORD = properties.getProperty("userStandartPassword");
        CUSTOMER_FIRST_NAME = properties.getProperty("customerFirstName");
        CUSTOMER_LAST_NAME = properties.getProperty("customerLastName");
        CUSTOMER_ADDRESS = properties.getProperty("customerAddress");
        CUSTOMER_POSTCODE = properties.getProperty("customerPostcode");
        CUSTOMER_CITY = properties.getProperty("customerCity");
        CUSTOMER_PHONE = properties.getProperty("customerPhone");
    }
}

