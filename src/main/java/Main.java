import pageFactory.AppManager;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        AppManager configurationReader = new AppManager();
        configurationReader.init();


        String baseUrl = configurationReader.BASE_URL;


        // Print the properties
        System.out.println("Base URL: " + baseUrl);

    }
}
