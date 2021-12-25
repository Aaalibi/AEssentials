package com.aaalibi.aaalibiessentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AECMDhello implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(sender.hasPermission("aaalibiessentials.hello")) {
                Player player = (Player) sender;
                sender.sendMessage("Hello, " + player.getName());
            }
        }
        else {
            sender.sendMessage("Only players can execute this command.");
        }
        return true;
    }
}
