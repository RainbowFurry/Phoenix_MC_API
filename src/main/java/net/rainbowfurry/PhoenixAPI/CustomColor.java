package net.rainbowfurry.PhoenixAPI;

import net.md_5.bungee.api.ChatColor;

import java.awt.*;

public class CustomColor {

    public static String customColor(String text, int r, int g, int b) {
        StringBuilder gradientText = new StringBuilder();
        Color interpolatedColor = new Color(r, g, b);
        String hexColor = String.format("#%02x%02x%02x", interpolatedColor.getRed(), interpolatedColor.getGreen(), interpolatedColor.getBlue());
        gradientText.append(ChatColor.of(hexColor)).append(text);
        return gradientText.toString();
    }

    public static String customColor(String text, String hex) {
        StringBuilder gradientText = new StringBuilder();
        Color interpolatedColor = new Color(0, 0, 0);//get from hex
        String hexColor = String.format("#%02x%02x%02x", interpolatedColor.getRed(), interpolatedColor.getGreen(), interpolatedColor.getBlue());
        gradientText.append(ChatColor.of(hexColor)).append(text);
        return gradientText.toString();
    }

}
