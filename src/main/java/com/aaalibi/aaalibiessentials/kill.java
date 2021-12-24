package com.aaalibi.aaalibiessentials;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public class kill implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            try {

                if (sender.hasPermission("aaalibiessentials.kill")) {
                    if(Bukkit.getServer().getPlayer(args[0]).isOnline()) {
                        Player killedpl = Bukkit.getServer().getPlayer(args[0]);
                        killedpl.setHealth(0.0D);
                        sender.sendMessage("§9§lAE§7> Killed "+killedpl.getDisplayName()+ ".");
                    }
                    else {
                        sender.sendMessage("§9§lAE§7> The player is not online.");
                    }

                }

            }



            catch(Exception e) {
                ((Player) sender).setHealth(0.0D);

            }
        }


        else {
            sender.sendMessage("Only players can execute this command.");
        }
        return true;
    }
}
