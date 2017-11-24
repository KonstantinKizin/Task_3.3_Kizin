package by.tc.jwd.task3_3.kizin.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

public class PropertyLoaderImpl {

    private final static String PROPERTY_FILE_NAME = "config";

    private final static ResourceBundle resource = ResourceBundle.getBundle(PROPERTY_FILE_NAME );

    private final static Map<String , String> propertyMap = new HashMap<>();

    private final static PropertyLoaderImpl instance = new PropertyLoaderImpl();

    private PropertyLoaderImpl(){
        Set<String > keys = resource.keySet();
        for(String tmp : keys){
            propertyMap.put(tmp , resource.getString(tmp));
        }
    }

    public static String getConstant(String key){
        return propertyMap.get(key);
    }

    public static Map<String, String> getPropertyMap() {
        return propertyMap;
    }

    public static PropertyLoaderImpl getInstance() {
        return instance;
    }
}
