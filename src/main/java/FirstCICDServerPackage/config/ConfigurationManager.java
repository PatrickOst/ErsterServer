package FirstCICDServerPackage.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import FirstCICDServerPackage.util.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigurationManager {
    private static ConfigurationManager myConfigurationManager;
    private static Configuration myCurrentConfiguration;

    public ConfigurationManager() {
    }

    public static ConfigurationManager getInstance(){
        if(myConfigurationManager==null){
            myConfigurationManager = new ConfigurationManager();
        }
        return myConfigurationManager;
    }

    /**
     * Used to load a configuration file by the path
     *
     */
    public void loadConfigurationFile(String filePath) {
        FileReader fileReader = null;
        try{
            fileReader = new FileReader(filePath);
        }catch (FileNotFoundException e){
            throw new HttpConfigurationException(e);
        }

        StringBuffer sb = new StringBuffer();
        int i;
        try {
            while( (i = fileReader.read()) != -1){
                sb.append((char)i);
            }
        } catch (IOException e) {
            throw new HttpConfigurationException(e);
        }
        JsonNode conf = null;
        try {
            conf = json.parse(sb.toString());
        } catch (IOException e) {
            throw new HttpConfigurationException("Error parsing the Configuration file", e);
        }

        try {
            myCurrentConfiguration = json.fromJson(conf, Configuration.class);
        } catch (JsonProcessingException e) {
            throw new HttpConfigurationException("Error parsing the Configuration file, internal.",e);
        }
    }

    /**
     * Returns the Current loaded Configuration
     */
    public Configuration getCurrentConfiguration(){
        if(myCurrentConfiguration == null){
            throw new HttpConfigurationException("No Current Configuration Set.");
        }
        return myCurrentConfiguration;
    }
}
