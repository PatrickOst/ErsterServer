package FirstCICDServerPackage.config;

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
    public void loadConfigurationFile(String filePath){

    }

    /**
     * Returns the Current loaded Configuration
     */
    public void getCurrentConfiguration(){

    }
}
