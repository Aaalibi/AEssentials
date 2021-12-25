package com.aaalibi.aaalibiessentials;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class AECMDkill implements CommandExecutor {

    public Plugin plugin = Main.getPlugin(Main.class);

    String prefixplugin = plugin.getConfig().getString("prefix").replace("&", "§");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            try {

                if (sender.hasPermission("aaalibiessentials.kill")) {
                    if(Bukkit.getServer().getPlayer(args[0]).isOnline()) {
                        Player killedpl = Bukkit.getServer().getPlayer(args[0]);
                        killedpl.setHealth(0.0D);
                        sender.sendMessage(prefixplugin + "Killed "+killedpl.getDisplayName()+ ".");
                    }
                    else {
                        sender.sendMessage(prefixplugin + "The player is not online.");
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
