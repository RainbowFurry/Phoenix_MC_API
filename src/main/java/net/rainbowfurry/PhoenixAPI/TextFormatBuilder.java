package net.rainbowfurry.PhoenixAPI;

import org.bukkit.ChatColor;

public class TextFormatBuilder {

    public static String FormatText(String message){
        return ChatColor.translateAlternateColorCodes('&',message);
    }

}
