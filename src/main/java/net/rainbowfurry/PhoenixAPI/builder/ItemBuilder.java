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

public class ItemBuilder {

    public NamespacedKey namespacedKey;

    private ItemStack itemStack;
    private ItemMeta itemMeta;

    /// Init new ItemBuilder
    public ItemBuilder(){

    }

    /// Init new ItemBuilder with given Material
    public ItemBuilder(Material material){
        itemStack = new ItemStack(material);
        itemMeta = itemStack.getItemMeta();
    }

    /// Init new ItemBuilder with given ItemStack
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

    /// Set the Material of the ItemStack
    public ItemBuilder setMaterial(Material material){
        itemStack.setType(material);
        return this;
    }

    /// Set the Amount for the Item
    public ItemBuilder setAmount(int amount){
        itemStack.setAmount(amount);
        return this;
    }

    /// Add the ItemMeta to the Item
    public ItemBuilder setItemMeta(){
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
