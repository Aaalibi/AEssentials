package com.aaalibi.aaalibiessentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("hello").setExecutor(new HelloCommand());
        this.getCommand("gmc").setExecutor(new GMCommand());
        this.getCommand("gms").setExecutor(new GMScommand());
        this.getCommand("day").setExecutor(new day());
        this.getCommand("fly").setExecutor(new fly());
        this.getCommand("ip").setExecutor(new ip());
        this.getCommand("time").setExecutor(new time());
        this.getCommand("night").setExecutor(new night());
        this.getCommand("ping").setExecutor(new ping());
        this.getCommand("heal").setExecutor(new Heal());
        this.getCommand("kill").setExecutor(new kill());
        this.getCommand("tp").setExecutor(new teleport());
        this.getCommand("give").setExecutor(new give());
        this.getCommand("strike").setExecutor(new strike());
        this.getCommand("fix").setExecutor(new fix());
        this.getCommand("eweather").setExecutor(new weather());
        this.getCommand("armor").setExecutor(new armor());
        this.getCommand("hat").setExecutor(new hat());
        this.getCommand("broadcast").setExecutor(new broadcast());


        getServer().getPluginManager().registerEvents(new AEHandler(), this);
        getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
