package com.aaalibi.aaalibiessentials;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class day implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(sender.hasPermission("aaalibiessentials.day")) {
                Player player = (Player)sender;
                player.getLocation().getWorld().setTime(1000);
                sender.sendMessage("§9§lAE§7> Time is now day.");
            }

        }
        else {
            sender.sendMessage("Only players can execute this command.");
        }
        return true;
    }
}