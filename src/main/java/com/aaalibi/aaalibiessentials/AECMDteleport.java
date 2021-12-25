package com.aaalibi.aaalibiessentials;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import static org.bukkit.Bukkit.getOfflinePlayer;
import static org.bukkit.Bukkit.getPlayer;

public class AECMDteleport implements CommandExecutor {

    public Plugin plugin = Main.getPlugin(Main.class);

    String prefixplugin = plugin.getConfig().getString("prefix").replace("&", "§");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            try {
                if (args.length == 3) {
                    if (sender.hasPermission("aaalibiessentials.tp")) {
                        Location location = new Location(Bukkit.getWorld("world"), Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), 0, 0);
                        ((Player) sender).teleport(location);
                        sender.sendMessage(prefixplugin + "You have been teleported to: §ex(§9" + args[0] + "§e) z(§9" + args[1] + "§e) z(§9" + args[2] + "§e)§7.");
                    }
                } else if (args.length == 1) {
                    if (sender.hasPermission("aaalibiessentials.tp")) {
                        Player target = getPlayer(args[0]);
                        Location location = target.getLocation();
                        ((Player) sender).teleport(location);
                        sender.sendMessage(prefixplugin + "You have been teleported to: " + target.getDisplayName() + ".");
                    }
                }
            }
            catch (Exception e) {
                sender.sendMessage(prefixplugin + "Usage: /tp [player] or /tp [x] [y] [z]");
            }

        }
        else {
            sender.sendMessage("Only players can execute this command.");
        }
        return true;
    }
}


