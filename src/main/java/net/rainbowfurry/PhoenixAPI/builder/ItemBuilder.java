package net.rainbowfurry.PhoenixAPI.builder;

import net.rainbowfurry.PhoenixAPI.text.TextFormatation;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {

    private ItemStack itemStack;
    private ItemMeta itemMeta;

    public ItemBuilder(){

    }

    public ItemBuilder(Material material){
        itemStack = new ItemStack(material);
        itemMeta = itemStack.getItemMeta();
    }

    public ItemBuilder(ItemStack itemStack){
        this.itemStack = itemStack;
        itemMeta = itemStack.getItemMeta();
    }

    public ItemBuilder setItemStack(ItemStack itemStack){
        this.itemStack = itemStack;
        itemMeta = itemStack.getItemMeta();
        return this;
    }

    public ItemBuilder setName(String name){
        itemMeta.setDisplayName(TextFormatation.defaultColor(name));
        return this;
    }

    public ItemBuilder setMaterial(Material material){
        itemStack.setType(material);
        return this;
    }

    public ItemBuilder setAmount(int amount){
        itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder setItemMeta(){
        return this;
    }

    public ItemStack build(){
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
