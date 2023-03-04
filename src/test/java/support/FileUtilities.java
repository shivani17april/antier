package support;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtilities {

    public static String readProperty(String propertyFileName, String propertyKey) {
        FileInputStream fileinputStream;
        Properties property = null;
        String propertyFilePath = System.getProperty("user.dir")+"\\src\\test\\resources\\test_data\\"+propertyFileName+
                ".properties";
        try {
            fileinputStream = new FileInputStream(propertyFilePath);
            property = new Properties();
            property.load(fileinputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String propertyValue = property.getProperty(propertyKey);
        return propertyValue.toString();
    }

//    public static void main(String[] args) {
//        System.out.println(readProperty("login","app_url"));
//        System.out.println(readProperty("login","username"));
//        System.out.println(readProperty("contactus","contactHeading"));
//    }
}
