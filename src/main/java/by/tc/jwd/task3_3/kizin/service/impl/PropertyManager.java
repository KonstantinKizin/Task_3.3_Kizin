package by.tc.jwd.task3_3.kizin.service.impl;

import java.util.ResourceBundle;

public class PropertyManager {
    private final static ResourceBundle resource = ResourceBundle.getBundle("config");
    public static String getProperty(String key){

        return resource.getString(key);
    }


}
