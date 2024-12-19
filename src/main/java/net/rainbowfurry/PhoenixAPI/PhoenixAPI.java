package net.rainbowfurry.PhoenixAPI;

import org.bukkit.plugin.java.JavaPlugin;

public final class PhoenixAPI extends JavaPlugin {

    public static JavaPlugin plugin;

    @Override
    public void onEnable() {

        this.plugin = this;
        // Plugin startup logic
//        if (!Bukkit.getPluginManager().isPluginEnabled("HolographicDisplays")) {
//            getLogger().severe("*** HolographicDisplays is not installed or not enabled. ***");
//            getLogger().severe("*** This plugin will be disabled. ***");
//            this.setEnabled(false);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
