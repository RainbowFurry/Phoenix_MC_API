package net.rainbowfurry.PhoenixAPI.manager;

import org.apache.commons.io.FileUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ConfigManager {

    private final String fileName;
    private final File configFile;
    private YamlConfiguration config;//FileConifguration
    private JavaPlugin plugin;

    /**
     * Init ConfigManager and load Config File
     * @param fileName Config File path and name with ending
     * @param plugin Your Plugin Instance
     */
    public ConfigManager(String fileName, JavaPlugin plugin) {
        this.fileName = fileName;
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder(), fileName);
    }

    /**
     * Create the Config File if not exist
     */
    public void createConfig() {
        if (!configFile.exists()) {
            try {
                configFile.getParentFile().mkdirs();
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    /**
     * Create the default ConfigFile from your "resources" Folder
     * The path on your Server and in your resources Filder need to be
     * identical to work.
     * @param plugin Your Plugin Instance
     * @param fileName File path and name with ending
     */
    public void createDefaultConfig(JavaPlugin plugin, String fileName) {
        if (!configFile.exists()) {
            try {
                configFile.getParentFile().mkdirs();
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        InputStream stream = plugin.getResource(fileName);
        try {
            FileUtils.copyInputStreamToFile(stream, new File(plugin.getDataFolder(),fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    /**
     * Get the Current ConfigFile
     * @return FileConfiguration
     */
    public FileConfiguration getConfig() {
        if (config == null) {
            config = YamlConfiguration.loadConfiguration(configFile);
        }
        return config;
    }

    /**
     * Save the Config File
     */
    public void saveConfig() {
        try {
            if (config != null) {
                config.save(configFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reload the Config File
     */
    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(configFile);
    }

}
