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
//import java.util.Vector;
import org.bukkit.util.Vector;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class PlayerMovementListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        Player p = event.getPlayer();
        World w = p.getWorld();

        if (p.isOnGround()){
            p.setFlying(false);
            p.setAllowFlight(true);
            p.sendMessage("Boden");
        }
        if (p.isFlying()){
            p.sendMessage("flyingATM");
        }
        //Block b = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
    }

    //pushes the player in the air after trying to fly to mimic a double jump
    @EventHandler
    public void onFlightToggle(PlayerToggleFlightEvent event) {
        Player p = event.getPlayer();
        World w = p.getWorld();

        p.setAllowFlight(false);
        p.setFlying(false);
        Vector v = p.getLocation().getDirection().multiply(1.1).setY(0.5);
        p.setVelocity(v);

        p.sendMessage("Flug");
    }
}
