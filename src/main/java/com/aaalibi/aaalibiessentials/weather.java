package com.aaalibi.aaalibiessentials;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class weather implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            if(sender instanceof Player) {
                if(sender.hasPermission("aaalibiessentials.weather")) {
                    if(args[0].equals("clear")) {
                        ((Player) sender).getLocation().getWorld().setClearWeatherDuration(24000);
                        sender.sendMessage("§9§lAE§7> Weather set to clear.");
                    }
                    else if(args[0].equals("rain")) {
                        ((Player) sender).getLocation().getWorld().setStorm(true);
                        ((Player) sender).getLocation().getWorld().setThundering(false);
                        sender.sendMessage("§9§lAE§7> Weather set to rain.");
                    }
                    else if(args[0].equals("storm")) {
                        ((Player) sender).getLocation().getWorld().setStorm(true);
                        sender.sendMessage("§9§lAE§7> Weather set to storm.");
                    }
                    else {
                        sender.sendMessage("§9§lAE§7> Usage: /weather (clear, rain, storm)");
                    }
                }


            }
            else {
                sender.sendMessage("Only players can execute this command.");
            }
        }
        catch(Exception e) {
            sender.sendMessage("§9§lAE§7> Usage: /weather (clear, rain, storm)");

        }



        return true;
    }
}


