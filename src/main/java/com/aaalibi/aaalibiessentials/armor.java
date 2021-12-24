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

public class armor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(sender.hasPermission("aaalibiessentials.armor")) {
                PlayerInventory inv = ((Player) sender).getInventory();
                ItemStack helmet = new ItemStack(Material.NETHERITE_HELMET);
                helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                helmet.addEnchantment(Enchantment.DURABILITY, 3);
                ItemStack chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
                chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                chestplate.addEnchantment(Enchantment.DURABILITY, 3);
                ItemStack legs = new ItemStack(Material.NETHERITE_LEGGINGS);
                legs.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                legs.addEnchantment(Enchantment.DURABILITY, 3);
                ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);
                boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                boots.addEnchantment(Enchantment.DURABILITY, 3);
                inv.setHelmet(helmet);
                inv.setChestplate(chestplate);
                inv.setLeggings(legs);
                inv.setBoots(boots);
                sender.sendMessage("§9§lAE§7> Set default OP armour.");
            }

        }
        else {
            sender.sendMessage("Only players can execute this command.");
        }
        return true;
    }
}
