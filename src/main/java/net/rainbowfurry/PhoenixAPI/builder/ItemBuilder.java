package net.rainbowfurry.PhoenixAPI.builder;

import net.rainbowfurry.PhoenixAPI.text.TextFormatation;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

    public NamespacedKey namespacedKey;

    private ItemStack itemStack;
    private ItemMeta itemMeta;
    private List<String> itemLore;

    /**
     * Init new blank ItemBuilder
     * To create an Item from blank
     */
    public ItemBuilder(){

    }

    /**
     * Init ItemBuilder with Material
     * @param material Material
     */
    public ItemBuilder(Material material){
        itemStack = new ItemStack(material);
        itemMeta = itemStack.getItemMeta();
    }

    /**
     * Init ItemBuilder with ItemStack
     * @param itemStack ItemStack
     */
    public ItemBuilder(ItemStack itemStack){
        this.itemStack = itemStack;
        itemMeta = itemStack.getItemMeta();
    }

    /**
     * Define the ItemStack to modify
     * @param itemStack The ItemStack which should be modified
     * @return Base Class
     */
    public ItemBuilder setItemStack(ItemStack itemStack){
        this.itemStack = itemStack;
        itemMeta = itemStack.getItemMeta();
        return this;
    }

    /**
     * Set the DisplayName for the Item
     * @param name The new Name for the Item
     * @return Base Class
     */
    public ItemBuilder setName(String name){
        itemMeta.setDisplayName(TextFormatation.defaultColor(name));
        return this;
    }

    /**
     * Set the Material for the ItemStack
     * @param material Material
     * @return base Class
     */
    public ItemBuilder setMaterial(Material material){
        itemStack.setType(material);
        return this;
    }

    /**
     * Set the Amount of the ItemStack max 64
     * depends on ItemStack size. Can be exploded by changing default
     * Games Stack size Config
     * @param amount Amount of the ItemStack size
     * @return base Class
     */
    public ItemBuilder setAmount(int amount){
        itemStack.setAmount(amount);
        return this;
    }

    /**
     * Add new Line to the ItemLore
     * @param line Content of the Line
     * @return base Class
     */
    public ItemBuilder addLore(String line){
        if(itemLore == null)
            itemLore = new ArrayList<>();
        itemLore.add(line);
        return this;
    }

    /**
     * Build ItemLore
     * @return ItemLore
     */
    public List<String> buildLore(){
        List<String> itemLore = this.itemLore;
        this.itemLore.clear();
        return itemLore;
    }

    /**
     * Set the Lore for the Item.
     * @param itemLore
     * @return
     */
    public ItemBuilder setLore(List<String> itemLore){
        itemMeta.setLore(itemLore);
        return this;
    }

    /**
     * Add the ItemMeta to the Item
     * @param itemMeta ItemMeta
     * @return base Class
     */
    public ItemBuilder setItemMeta(ItemMeta itemMeta){
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    /**
     * Add custom NBT Tag to the Item
     * @param plugin Your Plugin Instance
     * @param identifyer The Key to identify your Value
     * @param name The Value for your identifier
     * @return Base Class
     */
    public ItemBuilder addItemNBT(JavaPlugin plugin, String identifyer, String name){
        namespacedKey = new NamespacedKey(plugin, identifyer);
        PersistentDataContainer pdc = itemMeta.getPersistentDataContainer();
            pdc.set(namespacedKey, PersistentDataType.STRING, name);
            //itemStack.setItemMeta(itemMeta);
            return this;
    }

    /**
     * Get the ItemStack by building and returning it.
     * @return Returns your created ItemStack
     */
    public ItemStack build(){
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
