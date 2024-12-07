package net.rainbowfurry.PhoenixAPI;

import net.md_5.bungee.api.ChatColor;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFormatation {

    public static String customColor(String text, int r, int g, int b) {
        StringBuilder gradientText = new StringBuilder();
        Color interpolatedColor = new Color(r, g, b);
        String hexColor = String.format("#%02x%02x%02x", interpolatedColor.getRed(), interpolatedColor.getGreen(), interpolatedColor.getBlue());
        gradientText.append(ChatColor.of(hexColor)).append(text);
        return gradientText.toString();
    }

    public static String customColor(String text, String hex) {

        StringBuilder gradientText = new StringBuilder();

        Color interpolatedColor = Color.decode(hex);//ToDo get from hex
        String hexColor = String.format("#%02x%02x%02x", interpolatedColor.getRed(), interpolatedColor.getGreen(), interpolatedColor.getBlue());
        gradientText.append(ChatColor.of(hexColor)).append(text);
        return gradientText.toString();
    }

    public static String defaultColor(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    //ToDo Not working!
    public static String customColors(String message){

        String output = "";
        //message = defaultColor(message);
        if(message.contains("<#")) {
            for (String text : message.split("<#")) {
                if (text.contains(">")) {
                    System.out.println("<#" + text);
                    //String regex = "<(#[^>]+)>(.*?)</\\1>";
                    String regex = "<(#[^>]+)>(.*?)</(#[^>]+)>";

                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher("<#" + text);
                    if (matcher.find()) {
                        String tag = matcher.group(1);
                        String content = matcher.group(2);
                        String tag2 = matcher.group(3);
                        output = output + ChatGradient.applyGradient(content, Color.decode(tag), Color.decode(tag2.replace("/", "")));
                    }
                }

//            else {
//                System.out.println("§cNo match found.");
//            }
            }
            return defaultColor(output);
        }else{
            return defaultColor(message);
        }
    }

}
