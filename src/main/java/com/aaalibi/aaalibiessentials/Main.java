package com.aaalibi.aaalibiessentials;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {

    public final String prefixplugin = getConfig().getString("prefix").replace("&", "§");

    @Override
    public void onEnable() {
        this.getCommand("hello").setExecutor(new AECMDhello());
        this.getCommand("gmc").setExecutor(new AECMDgmc());
        this.getCommand("gms").setExecutor(new AECMDgms());
        this.getCommand("day").setExecutor(new AECMDday());
        this.getCommand("fly").setExecutor(new AECMDfly());
        this.getCommand("ip").setExecutor(new AECMDip());
        this.getCommand("time").setExecutor(new AECMDtime());
        this.getCommand("night").setExecutor(new AECMDnight());
        this.getCommand("ping").setExecutor(new AECMDping());
        this.getCommand("heal").setExecutor(new AECMDheal());
        this.getCommand("kill").setExecutor(new AECMDkill());
        this.getCommand("tp").setExecutor(new AECMDteleport());
        this.getCommand("give").setExecutor(new AECMDgive());
        this.getCommand("strike").setExecutor(new AECMDstrike());
        this.getCommand("fix").setExecutor(new AECMDfix());
        this.getCommand("eweather").setExecutor(new AECMDweather());
        this.getCommand("armor").setExecutor(new AECMDarmor());
        this.getCommand("hat").setExecutor(new AECMDhat());
        this.getCommand("broadcast").setExecutor(new AECMDbroadcast());


        getServer().getPluginManager().registerEvents(new AEHandler(), this);
        getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
