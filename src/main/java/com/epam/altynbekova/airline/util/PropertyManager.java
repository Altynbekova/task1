package com.epam.altynbekova.airline.util;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(PropertyManager.class);
    private static final String PROPERTIES_FILE= "app.properties";
    private static PropertyManager instance;
    private final Properties PROPERTIES = new Properties();

    private PropertyManager() throws IOException {
        InputStream in = PropertyManager.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);
       try {
           if (in!=null)
            PROPERTIES.load(in);
           else
               LOG.error("Cannot find {} file",PROPERTIES_FILE);
        } catch (IOException e) {
           LOG.error("IOException ",e);
        }
       finally {
           if (in!=null)
                in.close();
        }
    }

    public static PropertyManager getInstance() throws IOException {
        if (instance == null) {
            instance= new PropertyManager();
        }
        return instance;
    }

    public String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
