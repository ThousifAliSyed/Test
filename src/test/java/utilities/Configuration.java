package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    static Properties props = null;

    public static String getProperty(String propName) {
        try{
            props = new Properties();
            FileInputStream fis = new FileInputStream("src\\test\\resources\\configurations\\config.properties");
            props.load(fis);
        }catch (Exception e){
            e.printStackTrace();
        }
        return props.getProperty(propName);
    }
}
