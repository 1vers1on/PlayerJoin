package moe.liminal.playerjoin;

import org.bukkit.command.CommandExecutor;

public class PlayerJoinCommand implements CommandExecutor {
    private final PlayerJoin plugin;

    public PlayerJoinCommand(PlayerJoin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("&e" + plugin.getDescriptionString());
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "reload":
                plugin.reloadConfig();
                sender.sendMessage("&aConfig reloaded!");
                break;
            case "help":
                sender.sendMessage("&ePlayerJoin Help:");
                sender.sendMessage("&e/playerjoin reload - Reload the plugin configuration.");
                sender.sendMessage("&e/playerjoin help - Show this help message.");
                break;
            default:
                sender.sendMessage("&cUnknown command. Use /playerjoin help for a list of commands.");
                break;
        }
        return true;
    }
}
