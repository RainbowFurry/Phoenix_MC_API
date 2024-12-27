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

    public LocationBuilder(){

    }

    public LocationBuilder(Player player){
        this.location = player.getLocation();
    }

    public LocationBuilder(Location location){
        this.location = location;
    }

    public LocationBuilder(World world){
        this.world = world;
    }

    public LocationBuilder setWorld(World world){
        this.world = world;
        return this;
    }

    public LocationBuilder setX(double x){
        this.x = x;
        return this;
    }

    public LocationBuilder setY(double y){
        this.y = y;
        return this;
    }

    public LocationBuilder setZ(double z){
        this.z = z;
        return this;
    }

    public LocationBuilder setYaw(float yaw){
        this.yaw = yaw;
        return this;
    }

    public LocationBuilder setPitch(float pitch){
        this.pitch = pitch;
        return this;
    }

    public Location modifyBuild(){
        location.setWorld(world);
        location.setX(x);
        location.setY(y);
        location.setZ(z);
        location.setYaw(yaw);
        location.setPitch(pitch);
        return location;
    }

    public Location build(){
        this.location = new Location(world, x, y, z, yaw, pitch);
        return location;
    }

}
