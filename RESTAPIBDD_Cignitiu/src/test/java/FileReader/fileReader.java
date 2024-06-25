package FileReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class fileReader {
    private Properties properties;
    private final String configFilePath = "src/main/resources/Configs/data.properties";

    public fileReader() throws IOException {
        File ConfigFile = new File(configFilePath);

        try {
            FileInputStream configFileReader = new FileInputStream(ConfigFile);
            properties = new Properties();

            properties.load(configFileReader);
            configFileReader.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}







