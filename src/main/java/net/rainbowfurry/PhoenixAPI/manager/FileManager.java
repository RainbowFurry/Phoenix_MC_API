package net.rainbowfurry.PhoenixAPI.manager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileManager {

    /*
    * This File is still in Progress and not tested or completed!
    * */

    private File file;
    private FileConfiguration config;
    private YamlConfiguration yamlConfiguration;
    private List<FileConfiguration> configs = new ArrayList<>();

    @Deprecated
    public List<FileConfiguration> loadAllConfigs(File directory, boolean subFolder){
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if(file.length() > 0)
                            configs.add(YamlConfiguration.loadConfiguration(file));
                    } else if (file.isDirectory()) {
                        if(subFolder)
                            loadAllConfigs(file, true);
                    }
                }
            }
        }
        return configs;
    }

    @Deprecated
    public List<FileConfiguration> loadAllConfigs(JavaPlugin plugin, boolean subFolders){
        return loadAllConfigs(plugin.getDataFolder(), subFolders);
    }

    @Deprecated
    public YamlConfiguration loadConfig(String fileName, boolean validate){
        this.file = new File(fileName);
        if(file.exists() && file.isFile()){
            if(validate)
                if(isValidFile(this.file))
                    return YamlConfiguration.loadConfiguration(file);
        }
        return null;
    }

    @Deprecated
    public YamlConfiguration loadConfig(JavaPlugin plugin, String file, boolean validate){
        return loadConfig(plugin.getDataFolder() + file, validate);
    }

    @Deprecated
    /**
     * Creates the Default Config File of your selected File
     * Your Defaults Config needs to be existing in the "resources" Folder
     * At the same Location in your "plugins" Folder the new Config File will be created.
     * @param plugin Your Plugin Instance
     * @param file Your File Path + File Name + File Ending
     */
    public void createDefaults(JavaPlugin plugin, String file){
        //ToDo check if file exists before
        InputStream inputStream = plugin.getClass().getResourceAsStream(file);
        if (inputStream != null) {
            yamlConfiguration = YamlConfiguration.loadConfiguration(new InputStreamReader(inputStream));
            File outputFile = new File(plugin.getDataFolder(), file);
            try {
                if (!outputFile.getParentFile().exists()) {
                    outputFile.getParentFile().mkdirs();
                }
                yamlConfiguration.save(outputFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Deprecated
    public boolean contains(FileConfiguration config, String key){
        Map<String, Object> _object = config.getConfigurationSection(key).getValues(false);
        if(_object.keySet() != null)
            return true;
        return false;
    }

    /**
     * Check if File exists and is Valid YML
     * @param file YML File
     * @return Is Valid
     */
    @Deprecated
    public boolean isValidFile(File file){
        config = YamlConfiguration.loadConfiguration(file);
        return isValidConfig(config);
    }

    @Deprecated
    public boolean isValidConfig(FileConfiguration config){
        this.config = config;
        try {
            // Check if File exists and is Valid YML
            if (!file.exists() && !file.isFile()) {
                System.out.println("YAML file is missing or invalid.");
                return false;
            }

            // Check if the file is empty or has no meaningful content
            if (config.getKeys(false).isEmpty() || file.length() == 0) {
                System.out.println("YAML file is empty or contains no top-level keys.");
                return false;
            }

            // Add specific checks for required content
//        if (!config.contains("Buildings")) {
//            System.out.println("YAML file is missing required 'Buildings' section.");
//            return false;
//        }

            return true;
        } catch (Exception e) {
//            System.out.println("Error while loading YAML file: " + e.getMessage());
//            e.printStackTrace();
            return false;
        }
    }

}
