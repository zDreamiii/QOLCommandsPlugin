package at.zDreamiii.qOLCommands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("qolcommands.gamemode")) {
            player.sendMessage("§cYou don’t have permission to use this command!");
            return true;
        }

        if (args.length != 1) {
            player.sendMessage(ChatColor.GREEN + "Usage: /gamemode 0|1|2|3 or survival|creative|adventure|spectator");
            return true;
        }

        String input = args[0].toLowerCase();
        GameMode mode;

        switch (input) {
            case "0", "survival" -> mode = GameMode.SURVIVAL;
            case "1", "creative" -> mode = GameMode.CREATIVE;
            case "2", "adventure" -> mode = GameMode.ADVENTURE;
            case "3", "spectator" -> mode = GameMode.SPECTATOR;
            default -> {
                player.sendMessage(ChatColor.RED + "Invalid gamemode: " + args[0]);
                return true;
            }
        }

        player.setGameMode(mode);
        player.sendMessage("Your gamemode has been set to " + mode.name().toLowerCase() + ".");
        return true;
    }
}


