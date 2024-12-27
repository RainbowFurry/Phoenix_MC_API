package net.rainbowfurry.PhoenixAPI.builder;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryBuilder {

    private Inventory inventory;

    /**
     * Create Chest Inventory
     * @param title Inventory Title
     * @param rows Inventory rows
     * @return base Class
     */
    public InventoryBuilder createInventory(String title, int rows){
        inventory = Bukkit.createInventory(Bukkit.getPlayer("FAKE"), rows * 9, title);
        return this;
    }

    /**
     * Create Inventory with Type
     * @param title Inventory Title
     * @param inventoryType Inventory Type
     * @return base Class
     */
    public InventoryBuilder createInventoryType(String title, InventoryType inventoryType){
        inventory = Bukkit.createInventory(Bukkit.getPlayer("FAKE"), inventoryType, title);
        return this;
    }

    /**
     * Set/Load the Inventory to Modify
     * @param inventory Inventory to Modify
     * @return base Class
     */
    public InventoryBuilder setInventory(Inventory inventory) {
        this.inventory = inventory;
        return this;
    }

    /**
     * Fill Inventory with PlaceHolder Item
     * @param item ItemStack
     * @return base Class
     */
    public InventoryBuilder setPlaceHolder(ItemStack item){
        for(int position = 0; position < inventory.getSize(); position++){
            inventory.setItem(position, item);
        }
        return this;
    }

    /**
     * Add an Item to the Inventory
     * @param item ItemStack
     * @param position Inventory Position
     * @return base Class
     */
    public InventoryBuilder addItem(ItemStack item, int position){
        inventory.setItem(position, item);
        return this;
    }

    /**
     * Build the Inventory
     * @return Inventory
     */
    public Inventory build(){
        return inventory;
    }

}
