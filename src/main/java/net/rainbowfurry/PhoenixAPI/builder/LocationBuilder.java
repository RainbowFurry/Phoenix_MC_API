package net.rainbowfurry.PhoenixAPI.builder;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class LocationBuilder {

    private Location location;
    private World world = Bukkit.getWorld("world");
    private double x = 0;
    private double y = 0;
    private double z = 0;
    private float yaw = 0.5f;
    private float pitch = 0.5f;

    /**
     * Init locationBuilder blank
     * (if values are missing Exeption could appear)
     */
    public LocationBuilder(){

    }

    /**
     * Init LocationBuilder with the Player Location
     * @param player Player
     */
    public LocationBuilder(Player player){
        this.location = player.getLocation();
    }

    /**
     * Init LocationBuilder with Locationt to modify
     * @param location Location
     */
    public LocationBuilder(Location location){
        this.location = location;
    }

    /**
     * Init LocationBuilder with World
     * @param world World
     */
    public LocationBuilder(World world){
        this.world = world;
    }

    /**
     * Set the World for the Location
     * @param world World
     * @return base Class
     */
    public LocationBuilder setWorld(World world){
        this.world = world;
        return this;
    }

    /**
     * Set the X Coordinate for the Location
     * @param x X Coordinate
     * @return base Class
     */
    public LocationBuilder setX(double x){
        this.x = x;
        return this;
    }

    /**
     * Set the Y Coordinate for the Location
     * @param y Y Coordinate
     * @return  base Class
     */
    public LocationBuilder setY(double y){
        this.y = y;
        return this;
    }

    /**
     * Set the Z Coordinate for the Location
     * @param z Z Coordinate
     * @return base Class
     */
    public LocationBuilder setZ(double z){
        this.z = z;
        return this;
    }

    /**
     * Set the Yaw Coordinate for the Location
     * @param yaw Yaw
     * @return base Class
     */
    public LocationBuilder setYaw(float yaw){
        this.yaw = yaw;
        return this;
    }

    /**
     * Set the Pitch Coordinate for the Location
     * @param pitch Pitch
     * @return base Class
     */
    public LocationBuilder setPitch(float pitch){
        this.pitch = pitch;
        return this;
    }

    /**
     * Get modified Location
     * @return Location
     */
    public Location modify(){
        location.setWorld(world);
        location.setX(x);
        location.setY(y);
        location.setZ(z);
        location.setYaw(yaw);
        location.setPitch(pitch);
        return location;
    }

    /**
     * Get Location
     * @return Location
     */
    public Location build(){
        this.location = new Location(world, x, y, z, yaw, pitch);
        return location;
    }

}
