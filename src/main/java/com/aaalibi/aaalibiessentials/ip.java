package com.aaalibi.aaalibiessentials;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class ip implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(sender.hasPermission("aaalibiessentials.ip")) {
                String[] senderaddress = ((Player) sender).getAddress().toString().split(":");
                sender.sendMessage("§9§lAE§7> Your ip address is: " + senderaddress[0].replace("/", "") + ".");
            }

        }
        else {
            sender.sendMessage("Only players can execute this command.");
        }
        return true;
    }
}
