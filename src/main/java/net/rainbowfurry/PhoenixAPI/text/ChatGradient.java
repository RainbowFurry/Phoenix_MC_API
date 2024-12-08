package net.rainbowfurry.PhoenixAPI.text;

import net.md_5.bungee.api.ChatColor;

import java.awt.*;


public class ChatGradient {

    public static String applyGradient(String text, Color startColor, Color endColor) {
        StringBuilder gradientText = new StringBuilder();
        int length = text.length();

        for (int i = 0; i < length; i++) {
            float fraction = (float) i / (length - 1); // Calculate the fraction of the gradient
            Color interpolatedColor = ColorUtils.interpolateColor(startColor, endColor, fraction);
            String hexColor = String.format("#%02x%02x%02x", interpolatedColor.getRed(), interpolatedColor.getGreen(), interpolatedColor.getBlue());
            gradientText.append(ChatColor.of(hexColor)).append(text.charAt(i));
        }

        return gradientText.toString();
    }

}

class ColorUtils{
    public static Color interpolateColor(Color startColor, Color endColor, float fraction) {
        int red = (int) (startColor.getRed() + fraction * (endColor.getRed() - startColor.getRed()));
        int green = (int) (startColor.getGreen() + fraction * (endColor.getGreen() - startColor.getGreen()));
        int blue = (int) (startColor.getBlue() + fraction * (endColor.getBlue() - startColor.getBlue()));
        return new Color(red, green, blue);
    }
}
