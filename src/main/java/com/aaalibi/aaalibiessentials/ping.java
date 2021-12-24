package com.aaalibi.aaalibiessentials;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ping implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            if(sender instanceof Player) {
                if(sender.hasPermission("aaalibiessentials.ping")) {

                    sender.sendMessage("§9§lAE§7> Your ping is: " + ((Player) sender).getPing() + ".");
                }

            }
            else {
                sender.sendMessage("Only players can execute this command.");
            }
        }
        catch(Exception e) {
            sender.sendMessage("§9§lAE§7> Usage: /ping");

        }



        return true;
    }
}
