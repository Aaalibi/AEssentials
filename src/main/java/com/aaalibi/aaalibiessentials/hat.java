package com.aaalibi.aaalibiessentials;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import static org.bukkit.Bukkit.getPlayer;

public class hat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            try {
                if (sender.hasPermission("aaalibiessentials.hat")) {
                    PlayerInventory inv = ((Player) sender).getInventory();
                    ItemStack stack = inv.getItemInMainHand();
                    if(stack.getType() == Material.AIR) {
                        inv.setHelmet(stack);
                        sender.sendMessage("§9§lAE§7> Removed your hat.");
                    } else {
                        inv.setHelmet(stack);
                        sender.sendMessage("§9§lAE§7> Set " + inv.getItemInMainHand().getType().toString().toLowerCase() + " as your hat.");
                    }
                }
            }
            catch(Exception e) {
                sender.sendMessage("§9§lAE§7> Error, item is not valid.");
            }
        }
        else {
            sender.sendMessage("Only players can execute this command.");
        }
        return true;
    }
}
