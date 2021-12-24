package com.aaalibi.aaalibiessentials;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import static org.bukkit.Bukkit.getPlayer;

public class strike implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(sender.hasPermission("aaalibiessentials.strike")) {
                Block block = ((Player) sender).getPlayer().getTargetBlockExact(10000000);
                try {
                    if(args.length == 1) {
                        Player target = getPlayer(args[0]);
                        Location loc = target.getLocation();
                        loc.getWorld().strikeLightningEffect(loc);
                    } else {
                        Location loc = block.getLocation();
                        loc.getWorld().strikeLightningEffect(loc);
                        sender.sendMessage("§9§lAE§7> Struck at cursor position.");
                    }

                } catch(NullPointerException e) {

                }
         }

        }
        else {
            sender.sendMessage("Only players can execute this command.");
        }
        return true;
    }
}
