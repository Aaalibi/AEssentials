package com.aaalibi.aaalibiessentials;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import static org.bukkit.Bukkit.getPlayer;

public class give implements CommandExecutor {

    // /give carrot 3 Optional(Aaalibi)

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(sender.hasPermission("aaalibiessentials.give")) {
                if(args.length == 3) {
                    Player player = getPlayer(args[2]);
                    try {
                        ItemStack Item = new ItemStack(Material.valueOf(args[0].toUpperCase()), Integer.parseInt(args[1]));
                        PlayerInventory inv = player.getInventory();
                        inv.addItem(Item);
                        sender.sendMessage("§9§lAE§7> Given to " + args[2] + " " + args[1] + " " + args[0]);
                    } catch(IllegalArgumentException e)  {
                        sender.sendMessage("§9§lAE§7> Invalid item.");
                    }
                }
                if(args.length == 2) {
                    try {
                        Player player = (Player) sender;
                        ItemStack Item = new ItemStack(Material.valueOf(args[0].toUpperCase()), Integer.parseInt(args[1]));
                        PlayerInventory inv = player.getInventory();
                        inv.addItem(Item);
                        sender.sendMessage("§9§lAE§7> Given yourself " + args[1] + " " + args[0]);
                    } catch(IllegalArgumentException e) {
                        sender.sendMessage("§9§lAE§7> Invalid item.");
                    }
                }
                if(args.length == 1) {
                    try {
                        Player player = (Player) sender;
                        ItemStack Item = new ItemStack(Material.valueOf(args[0].toUpperCase()), 1);
                        PlayerInventory inv = player.getInventory();
                        inv.addItem(Item);
                        sender.sendMessage("§9§lAE§7> Given yourself 1 " + args[0]);
                    } catch(IllegalArgumentException e) {
                        sender.sendMessage("§9§lAE§7> Invalid item.");
                    }
                }
            }

        }
        else {
            sender.sendMessage("Only players can execute this command.");
        }
        return true;
    }
}
