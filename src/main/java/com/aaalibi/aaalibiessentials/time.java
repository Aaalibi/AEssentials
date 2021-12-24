package com.aaalibi.aaalibiessentials;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class time implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            if(sender instanceof Player) {
                if(sender.hasPermission("aaalibiessentials.time")) {
                    ((Player) sender).getLocation().getWorld().setTime(Long.parseLong(args[0]));
                    sender.sendMessage("§9§lAE§7> Time set to " + args[0] + ".");
                }

            }
            else {
                sender.sendMessage("Only players can execute this command.");
            }
        }
        catch(Exception e) {
            sender.sendMessage("§9§lAE§7> Usage: /time <time_in_ticks>");

        }



        return true;
    }
}
