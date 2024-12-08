package net.rainbowfurry.PhoenixAPI.manager;

import net.rainbowfurry.PhoenixAPI.PhoenixAPI;
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
    private FileConfiguration config;
    private JavaPlugin plugin;

    public ConfigManager(String fileName, JavaPlugin plugin) {
        this.fileName = fileName;
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder(), fileName);
    }

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

    public FileConfiguration getConfig() {
        if (config == null) {
            config = YamlConfiguration.loadConfiguration(configFile);
        }
        return config;
    }

    public void saveConfig() {
        try {
            if (config != null) {
                config.save(configFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(configFile);
    }

}
