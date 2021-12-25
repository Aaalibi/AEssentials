package com.aaalibi.aaalibiessentials;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class AECMDtime implements CommandExecutor {

    public Plugin plugin = Main.getPlugin(Main.class);

    String prefixplugin = plugin.getConfig().getString("prefix").replace("&", "§");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            if(sender instanceof Player) {
                if(sender.hasPermission("aaalibiessentials.time")) {
                    ((Player) sender).getLocation().getWorld().setTime(Long.parseLong(args[0]));
                    sender.sendMessage(prefixplugin + "Time set to " + args[0] + ".");
                }

            }
            else {
                sender.sendMessage("Only players can execute this command.");
            }
        }
        catch(Exception e) {
            sender.sendMessage(prefixplugin + "Usage: /time <time_in_ticks>");

        }



        return true;
    }
}
