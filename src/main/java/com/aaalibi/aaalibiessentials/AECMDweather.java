package com.aaalibi.aaalibiessentials;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class AECMDweather implements CommandExecutor {

    public Plugin plugin = Main.getPlugin(Main.class);

    String prefixplugin = plugin.getConfig().getString("prefix").replace("&", "§");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            if(sender instanceof Player) {
                if(sender.hasPermission("aaalibiessentials.weather")) {
                    if(args[0].equals("clear")) {
                        ((Player) sender).getLocation().getWorld().setClearWeatherDuration(24000);
                        sender.sendMessage(prefixplugin + "Weather set to clear.");
                    }
                    else if(args[0].equals("rain")) {
                        ((Player) sender).getLocation().getWorld().setStorm(true);
                        ((Player) sender).getLocation().getWorld().setThundering(false);
                        sender.sendMessage(prefixplugin + "Weather set to rain.");
                    }
                    else if(args[0].equals("storm")) {
                        ((Player) sender).getLocation().getWorld().setStorm(true);
                        sender.sendMessage(prefixplugin + "Weather set to storm.");
                    }
                    else {
                        sender.sendMessage(prefixplugin + "Usage: /weather (clear, rain, storm)");
                    }
                }


            }
            else {
                sender.sendMessage("Only players can execute this command.");
            }
        }
        catch(Exception e) {
            sender.sendMessage(prefixplugin + "Usage: /weather (clear, rain, storm)");

        }



        return true;
    }
}


