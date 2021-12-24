package com.aaalibi.aaalibiessentials;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            if(sender.hasPermission("aaalibiessentials.fly")) {
                if(((Player) sender).getAllowFlight()) {
                    ((Player) sender).setAllowFlight(false);
                    ((Player) sender).setFlying(false);
                    sender.sendMessage("§9§lAE§7> Flight disactivated.");
                }
                else {
                    ((Player) sender).setAllowFlight(true);
                    sender.sendMessage("§9§lAE§7> Flight activated.");
                }
            }

        }
        else {
            sender.sendMessage("Only players can execute this command.");
        }
        return true;
    }
}
