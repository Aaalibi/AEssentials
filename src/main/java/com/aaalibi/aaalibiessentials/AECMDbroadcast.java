package com.aaalibi.aaalibiessentials;

import org.bukkit.Bukkit;
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
import org.bukkit.plugin.Plugin;

import java.util.Arrays;

import static org.bukkit.Bukkit.getPlayer;
import static org.bukkit.Bukkit.getServer;

public class AECMDbroadcast implements CommandExecutor {

    public Plugin plugin = Main.getPlugin(Main.class);

    String prefixplugin = plugin.getConfig().getString("prefix").replace("&", "§");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(sender.hasPermission("aaalibiessentials.broadcast")) {
                String message = Arrays.toString(args).replace("&", "§").replace("[", "").replace("]", "").trim();
                Bukkit.getServer().broadcastMessage("§7[§9§lAE§7] " + message);
            }
        }
        else {
            sender.sendMessage("Only players can execute this command.");
        }
        return true;
    }
}
