package net.rainbowfurry.PhoenixAPI.manager;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class LanguageManager {

    //UPDATE: Get Language by Player and Config with config option?

    private ConfigManager messageConfig;

    public LanguageManager(JavaPlugin plugin){
        loadLanguage("en", plugin);
    }

    public void loadLanguage(String languageCode, JavaPlugin plugin) {
        //messageConfig = new ConfigManager("language/messages_" + languageCode + ".yml", Essentials.plugin);
        messageConfig = new ConfigManager("language/" + languageCode + ".yml", plugin);
        messageConfig.createDefaultConfig(plugin,"language/" + languageCode +".yml");
    }

    public String getMessage(String key){
        if(messageConfig.getConfig().getString(key) == null)
            return messageConfig.getConfig().getString(key);
        else
            return "NULL";
    }

}
