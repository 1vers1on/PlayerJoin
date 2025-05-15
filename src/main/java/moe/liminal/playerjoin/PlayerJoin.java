package moe.liminal.playerjoin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerJoin extends JavaPlugin {
    private boolean papiEnabled = false;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        papiEnabled = Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI");
        getCommand("playerjoin").setExecutor(new PlayerJoinCommand(this));
        getServer().getPluginManager().registerEvents(new JoinExitListener(this), this);

        getLogger().info("PlayerJoin enabled!");
    }

    @Override
    public void onDisable() {
    }

    public String getDescriptionString() {
        return "Running PlayerJoin version " + getDescription().getVersion() + " by 1vers1on";
    }

    public boolean isPapiEnabled() {
        return papiEnabled;
    }
}
