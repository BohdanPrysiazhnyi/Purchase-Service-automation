package utils;

import org.openqa.selenium.Capabilities;

public class CapabilityFactory {
    private Capabilities capabilities;
    public Capabilities getCapabilities(String value){
        capabilities = OptionsManager.getChromeOptions();
        return capabilities;
    }
}
