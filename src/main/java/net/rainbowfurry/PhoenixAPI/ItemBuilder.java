package net.rainbowfurry.PhoenixAPI;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {

    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    public ItemBuilder(Material material){
        itemStack = new ItemStack(material);
        itemMeta = itemStack.getItemMeta();
    }

    public void setName(String name){
        itemMeta.setDisplayName(TextFormatation.defaultColor(name));
    }

    public void setMaterial(Material material){
        itemStack.setType(material);
    }

    public void setAmount(int amount){
        itemStack.setAmount(amount);
    }

    public void setItemMeta(){

    }

    public ItemStack build(){
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
