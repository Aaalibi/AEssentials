package com.aaalibi.aaalibiessentials;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import static org.bukkit.Bukkit.getPlayer;

public class AEHandler implements Listener {

    public Plugin plugin = Main.getPlugin(Main.class);

    String prefixplugin = plugin.getConfig().getString("prefix").replace("&", "§");

    String joinmessage = plugin.getConfig().getString("joinmessage").replace("§", "&");
    String leavemessage = plugin.getConfig().getString("leavemessage").replace("§", "&");


    @EventHandler(priority=EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
        Bukkit.broadcastMessage(joinmessage + event.getPlayer().getDisplayName());
    }
    @EventHandler(priority=EventPriority.HIGH)
    public void onPlayerLeave(PlayerQuitEvent event) {
        event.setQuitMessage(null);
        Bukkit.broadcastMessage(leavemessage + event.getPlayer().getDisplayName());
    }
    @EventHandler(priority=EventPriority.HIGHEST)
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.setDeathMessage(null);
        Bukkit.broadcastMessage(prefixplugin + event.getEntity().getPlayer().getDisplayName() + " died.");
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if(plugin.getConfig().getBoolean("antitnt")) {
            if (e.getBlockPlaced().getType() == Material.TNT) {
                e.setCancelled(true);
                e.getPlayer().sendMessage(prefixplugin + " Il griefing è disabilitato.");
            }
        }
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e) {
        if(e.getEntity().getType() == EntityType.PRIMED_TNT) {
            e.setCancelled(true);
        }
        else if(e.getEntity().getType() == EntityType.CREEPER) {
            e.setCancelled(true);
        }
    }

}

