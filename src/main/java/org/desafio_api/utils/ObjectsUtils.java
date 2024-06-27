package org.desafio_api.utils;

import java.io.File;
import java.util.Properties;

import static org.desafio_api.utils.FileOperations.getProperties;

public class ObjectsUtils {

    public static String getPropertiesData(String fileName, String property){
        try {
            Properties properties = getProperties("properties" + File.separator + fileName + ".properties");
            return properties.getProperty(property);
        } catch(Exception e){
            System.out.println("Não foi possível ler o arquivo " + e.getMessage());
            return null;
        }
    }

    public static void setPropertiesData(String fileName,String propKey,String propValue){
        try {
            FileOperations.setProperties("properties" + File.separator + fileName + ".properties",propKey,propValue);
        } catch(Exception e){
            System.out.println("Não foi possível ler o arquivo " + e.getMessage());
        }
    }

}