package net.rainbowfurry.PhoenixAPI.manager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;

public class FileManager {

    private File file;
    private FileConfiguration config;
    private YamlConfiguration yamlConfiguration;

    public void loadAllFiles(String path){

    }

    private void loadFile(String file){

    }

    private void loadFile(String file, boolean validate){

    }

    private void createDefaults(JavaPlugin plugin, String file){

        InputStream inputStream =  plugin.getClass().getResourceAsStream(file);
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

//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    System.out.println(line);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

    /**
     * Check if File exists and is Valid YML
     * @param file YML File
     * @return Is Valid
     */
    private boolean isValidFile(File file){

        try {
        // Check if File exists and is Valid YML
        if (file == null || !file.exists() || !file.isFile()) {
            System.out.println("YAML file is missing or invalid.");
            return false;
        }

        // Check if the file is empty or has no meaningful content
        if (config.getKeys(false).isEmpty()) {
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
