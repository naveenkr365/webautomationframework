package com.web.utils;

import com.web.constants.FrameworkConstants;
import com.web.enums.ConfigProperties;
import com.web.exceptions.PropertyFileUsageException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils(){}

    private static Properties property = new Properties();
    private static final Map<String,String> CONFIGMAP = new HashMap<>();

    static {
        try(FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
            property.load(file);
            for(Map.Entry<Object, Object> entry : property.entrySet()){
                CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static String get(ConfigProperties key) {
        if(Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())) || Objects.isNull(key)){
            throw new PropertyFileUsageException("Propery name "+ key + " is not found, Please check config.properties file");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }


}
