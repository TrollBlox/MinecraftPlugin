package org.trollblox.minecraftplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.trollblox.minecraftplugin.MinecraftPlugin;

import java.util.ArrayList;
import java.util.List;

public class SpawnDolphins implements Listener {
    private final Plugin plugin;
    private boolean entered = false;

    public SpawnDolphins(MinecraftPlugin plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, this.plugin);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerMove_Low(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Material block = player.getLocation().getBlock().getType();
        List<Entity> dolphins = new ArrayList<>();

        if (block == Material.WATER) {
            if (entered) return;
            entered = true;
            dolphins.add(player.getWorld().spawnEntity(player.getLocation(), EntityType.DOLPHIN));
            dolphins.add(player.getWorld().spawnEntity(player.getLocation(), EntityType.DOLPHIN));

//            for (Entity dolphin : dolphins) {
//                new BukkitRunnable() {
//                    public void run() {
//                        if (!player.isOnline() || dolphin.isDead()) {
//                            cancel();
//                        }
////                        Vector vector = dolphin.getLocation().toVector().subtract(player.getLocation().toVector()).normalize();
////                        dolphin.setVelocity(vector);
//                        dolphin.setVelocity(player.getVelocity());
//                        Bukkit.getLogger().info("followed");
//                    }
//                }.runTaskTimer(plugin, 10L, 10L);
//            }
        } else {
            entered = false;
        }
    }
}
