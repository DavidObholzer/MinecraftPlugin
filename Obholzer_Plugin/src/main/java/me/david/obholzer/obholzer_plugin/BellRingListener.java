package me.david.obholzer.obholzer_plugin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.World;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BellRingEvent;
import java.util.Random;

public class BellRingListener implements Listener {
    //teleports the player to a random position whenever they ring a bell
    @EventHandler
    public void onBellRing(BellRingEvent e){

        Player p = (Player) e.getEntity();
        World w = p.getWorld();
        Random rng = new Random();
        double x = rng.nextDouble(30000000);
        double z = rng.nextDouble(30000000);
        for (int yTemp = 0; yTemp<200; yTemp++){
            Location location = new Location(w, x, yTemp, z);

            if (location.getBlock().getType() == Material.AIR && location.add(0, 1, 0).getBlock().getType() == Material.AIR) {
                p.teleport(location);
                break;
            }
        }

    }
}
