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
            sender.sendMessage(ChatColor.RED + "Nur Spieler können diesen Befehl verwenden!");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("qolcommands.gamemode")) {
            player.sendMessage("§cDu hast keine Berechtigung, diesen Befehl zu nutzen!");
            return true;
        }

        if (args.length != 1) {
            player.sendMessage(ChatColor.GREEN + "Verwendung: /gamemode 0|1|2|3 oder Survival|Creative|Adventure|Spectator");
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
                player.sendMessage(ChatColor.RED + "Ungültiger Spielmodus: " + args[0]);
                return true;
            }
        }

        player.setGameMode(mode);
        player.sendMessage("Dein Spielmodus wurde zu " + mode.name().toLowerCase() + " geändert.");
        return true;
    }
}


