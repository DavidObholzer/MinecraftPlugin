package me.david.obholzer.obholzer_plugin;

import org.bukkit.block.Bell;
import org.bukkit.plugin.java.JavaPlugin;

public final class Obholzer_Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        // this plugin features several small functions that aim to add a bit of randomness and surprise to a normal playthrough
        getServer().getPluginManager().registerEvents(new HitPlayerListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerMovementListener(), this);
        getServer().getPluginManager().registerEvents(new EggLandingListener(), this);
        getServer().getPluginManager().registerEvents(new BellRingListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
