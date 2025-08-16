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
            sender.sendMessage(ChatColor.RED + "Only players can you this command!");
            return true;
        }
        Player player = (Player) sender;

        if (!player.hasPermission("qolcommands.heal")) {
            player.sendMessage("§cYou don't have the necessary permissions to use this command!");
            return true;
        }

        if (plugin.getCooldownManager().isOnCooldown(player.getUniqueId(), "heal")) {
            long remaining = plugin.getCooldownManager().getRemainingTime(player.getUniqueId(), "heal");
            player.sendMessage("§cYou have to wait " + remaining + " more seconds before you can use this command again!");
            return true;

        }

        player.setHealth(20);
        player.sendMessage("§aYou have been fully healed!");

        plugin.getCooldownManager().setCooldown(player.getUniqueId(), "heal");
        return true;
    }
}
