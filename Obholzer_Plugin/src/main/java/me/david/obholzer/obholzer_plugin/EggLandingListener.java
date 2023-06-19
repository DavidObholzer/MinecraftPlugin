package me.david.obholzer.obholzer_plugin;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class EggLandingListener implements Listener {

    //creates a small explosion on the landing position
    @EventHandler
    public void onEggLanding(ProjectileHitEvent event){
        if (event.getEntity().getType() == EntityType.EGG){
            Egg egg = (Egg) event.getEntity();
            egg.getWorld().createExplosion(egg.getLocation(), 2);
        }
    }
}
