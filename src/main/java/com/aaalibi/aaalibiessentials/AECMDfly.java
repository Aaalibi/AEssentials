package com.aaalibi.aaalibiessentials;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class AECMDfly implements CommandExecutor {

    public Plugin plugin = Main.getPlugin(Main.class);

    String prefixplugin = plugin.getConfig().getString("prefix").replace("&", "§");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            if(sender.hasPermission("aaalibiessentials.fly")) {
                if(((Player) sender).getAllowFlight()) {
                    ((Player) sender).setAllowFlight(false);
                    ((Player) sender).setFlying(false);
                    sender.sendMessage(prefixplugin + "Flight disactivated.");
                }
                else {
                    ((Player) sender).setAllowFlight(true);
                    sender.sendMessage(prefixplugin + "Flight activated.");
                }
            }

        }
        else {
            sender.sendMessage("Only players can execute this command.");
        }
        return true;
    }
}
