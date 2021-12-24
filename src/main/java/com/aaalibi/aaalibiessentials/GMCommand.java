package com.aaalibi.aaalibiessentials;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GMCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(sender.hasPermission("aaalibiessentials.gmc")) {
                Player player = (Player)sender;
                player.setGameMode(GameMode.CREATIVE);
                sender.sendMessage("§9§lAE§7> Gamemode is now set to creative.");
            }

        }
        else {
            sender.sendMessage("Only players can execute this command.");
        }
        return true;
    }
}
