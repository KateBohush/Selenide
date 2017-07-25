package utill;


import java.io.IOException;
import java.util.Properties;

import static utill.Constants.PROPERTY_FILE_PATH;

public class PropertyLoader {
   public static Properties prop = new Properties();

   public static String getProperty(String propertyName) {

      try {
         prop.load(PropertyLoader.class.getClassLoader().getResourceAsStream(PROPERTY_FILE_PATH));
         return prop.getProperty(propertyName);
      } catch (IOException ex) {
         ex.printStackTrace();
      }
      return null;
   }
}
