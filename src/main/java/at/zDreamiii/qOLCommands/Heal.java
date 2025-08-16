package at.zDreamiii.qOLCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

    private final QOLCommands plugin;

    public Heal(QOLCommands plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Nur Spieler können diesen Befehl verwenden!");
            return true;
        }
        Player player = (Player) sender;

        if (!player.hasPermission("qolcommands.heal")) {
            player.sendMessage("§cDu hast keine Berechtigung, diesen Befehl zu nutzen!");
            return true;
        }

        if (plugin.getCooldownManager().isOnCooldown(player.getUniqueId(), "heal")) {
            long remaining = plugin.getCooldownManager().getRemainingTime(player.getUniqueId(), "heal");
            player.sendMessage("§cDu musst noch " + remaining + " Sekunden warten, bevor du diesen Befehl wieder nutzen kannst!");
            return true;

        }

        player.setHealth(20);
        player.sendMessage("§aDu wurdest vollständig geheilt!");

        plugin.getCooldownManager().setCooldown(player.getUniqueId(), "heal");
        return true;
    }
}