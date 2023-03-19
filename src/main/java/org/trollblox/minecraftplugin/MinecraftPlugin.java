package org.trollblox.minecraftplugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.trollblox.minecraftplugin.listeners.SpawnDolphins;

public final class MinecraftPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        new SpawnDolphins(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
