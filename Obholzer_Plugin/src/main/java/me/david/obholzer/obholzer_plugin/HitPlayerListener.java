package me.david.obholzer.obholzer_plugin;

import com.google.common.collect.Iterables;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Collection;

public class HitPlayerListener implements Listener {

    @EventHandler
    public void onHealthLost(EntityDamageByEntityEvent e){
        //doubles every enemy in a 20 block radius when the player gets hit
        if (e.getEntity() instanceof Player){
            Entity original = e.getDamager();
            Player p = (Player) e.getEntity();

            World w = original.getWorld();

            Collection<Entity> entityList = w.getNearbyEntities(p.getLocation(), 20, 20, 20);

            try{
                for(int i=0; i < entityList.size(); i++){
                    Entity nextClone = Iterables.get(entityList, i);
                    if (nextClone instanceof Enemy){
                        w.spawnEntity(nextClone.getLocation().subtract(1,0,0), nextClone.getType());
                    }
                }
            } catch (Exception ex) {
                p.sendMessage(ex.getMessage());
            }
        }
    }
}
