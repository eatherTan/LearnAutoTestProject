package hello.utils;

import hello.model.InterfaceNameEnum;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {

    private static ResourceBundle bundle = ResourceBundle.getBundle("test_url", Locale.CHINA);

    public static String getUrl(InterfaceNameEnum interfaceNameEnum){
        String address = bundle.getString("test.url");
        String uri = "";
        String testUrl;
        uri = bundle.getString(interfaceNameEnum.getCode());
        testUrl = address + uri;
        return testUrl;
    }
}
