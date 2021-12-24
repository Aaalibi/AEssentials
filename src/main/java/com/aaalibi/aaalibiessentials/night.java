package com.aaalibi.aaalibiessentials;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class night implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(sender.hasPermission("aaalibiessentials.night")) {
                Player player = (Player)sender;
                player.getLocation().getWorld().setTime(14000);
                sender.sendMessage("§9§lAE§7> Time is now night.");
            }

        }
        else {
            sender.sendMessage("Only players can execute this command.");
        }
        return true;
    }
}