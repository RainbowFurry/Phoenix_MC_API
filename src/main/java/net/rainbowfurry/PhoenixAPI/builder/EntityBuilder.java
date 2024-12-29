package net.rainbowfurry.PhoenixAPI.builder;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;

public class EntityBuilder {

    private EntityType entityType;
    private String name = "";
    private double health = 1;
    private boolean visibility = false;

    public EntityBuilder(){

    }

    public EntityBuilder(EntityType entityType){
        this.entityType = entityType;
    }

    public EntityBuilder setEntityType(EntityType entityType){
        this.entityType = entityType;
        return this;
    }

    public EntityBuilder setName(String name){
        this.name = name;
        return this;
    }

    public EntityBuilder setHealth(double health){
        this.health = health;
        return this;
    }

    public EntityBuilder isNameVisible(boolean visibility){
        this.visibility = visibility;
        return this;
    }

    private void addPotionEffect(PotionEffect potionEffect){
        //
    }

    private void setEquipment(){
      //
    }

    public void build(){
        //
    }

    public void spawn(Location location){
        Entity entity = location.getWorld().spawnEntity(location, this.entityType);
        entity.setCustomName(this.name);
        entity.setCustomNameVisible(this.visibility);
        //this.entityType.getClass().cast(entity)
        //entity.setHealth(20);
    }

    /*
    .addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1))
    .setEquipment(EquipmentSlot.HEAD, new ItemBuilder(Material.DIAMOND_HELMET).build())
    * */

}
