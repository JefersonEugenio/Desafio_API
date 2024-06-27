package org.desafio_api.utils;

import java.io.*;
import java.util.Properties;

public class FileOperations {

    private static final String CAMINHO_RESOURCES = System.getProperty("user.dir") + File.separator+
            "src" + File.separator + "main" + File.separator+ "resources" + File.separator;

    public static Properties getProperties(String fileName) throws IOException {
        InputStream inputStream = null;
        Properties prop = new Properties();
        try {
            File file = new File(fileName);
            inputStream = new FileInputStream(CAMINHO_RESOURCES + file);
            prop.load(inputStream);
            return prop;
        } catch (Exception e){
            System.out.println("Passando exception " + e.getMessage());
        } finally {
            inputStream.close();
        }
        return prop;
    }

    public static void setProperties(String fileName,String propKey,String propValue) throws IOException {
        Properties prop = getProperties(fileName);
        try {
            OutputStream outputStream = new FileOutputStream(CAMINHO_RESOURCES + fileName);
            prop.setProperty(propKey, propValue);
            prop.store(outputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}