package net.rainbowfurry.PhoenixAPI;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryBuilder {

    private Inventory inventory;

    public InventoryBuilder createInventory(String title, int rows){
        inventory = Bukkit.createInventory(Bukkit.getPlayer("FAKE"), rows * 9, title);
        return this;
    }

    public InventoryBuilder createInventoryType(String title, InventoryType inventoryType){
        inventory = Bukkit.createInventory(Bukkit.getPlayer("FAKE"), inventoryType, title);
        return this;
    }

    public InventoryBuilder setPlaceHolder(ItemStack item){
        for(int position = 0; position < inventory.getSize(); position++){
            inventory.setItem(position, item);
        }
        return this;
    }

    public InventoryBuilder addItem(ItemStack item, int position){
        inventory.setItem(position, item);
        return this;
    }

    public Inventory build(){
        return inventory;
    }

}
