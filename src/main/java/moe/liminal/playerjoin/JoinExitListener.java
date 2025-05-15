package moe.liminal.playerjoin;

import me.clip.placeholderapi.PlaceholderAPI;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class JoinExitListener implements Listener {
    private final PlayerJoin plugin;

    public JoinExitListener(PlayerJoin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        List<String> commands = plugin.getConfig().getStringList("join-commands");
        ConsoleCommandSender console = event.getPlayer().getServer().getConsoleSender();

        if (plugin.isPapiEnabled()) {
            for (String command : commands) {
                String parsedCommand = PlaceholderAPI.setPlaceholders(player, command);
                parsedCommand = parsedCommand.replace("%player%", player.getName());
                event.getPlayer().getServer().dispatchCommand(console, parsedCommand);
            }
        } else {
            for (String command : commands) {
                String parsedCommand = command.replace("%player%", player.getName());
                event.getPlayer().getServer().dispatchCommand(console, parsedCommand);
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(@NotNull PlayerQuitEvent event) {
        Player player = event.getPlayer();
        List<String> commands = plugin.getConfig().getStringList("leave-commands");
        ConsoleCommandSender console = event.getPlayer().getServer().getConsoleSender();

        if (plugin.isPapiEnabled()) {
            for (String command : commands) {
                String parsedCommand = PlaceholderAPI.setPlaceholders(player, command);
                parsedCommand = parsedCommand.replace("%player%", player.getName());
                event.getPlayer().getServer().dispatchCommand(console, parsedCommand);
            }
        } else {
            for (String command : commands) {
                String parsedCommand = command.replace("%player%", player.getName());
                event.getPlayer().getServer().dispatchCommand(console, parsedCommand);
            }
        }
    }
}
