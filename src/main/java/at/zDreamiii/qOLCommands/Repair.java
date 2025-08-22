package at.zDreamiii.qOLCommands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

public class Repair implements CommandExecutor {

    private final QOLCommands plugin;

    public Repair(QOLCommands plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;
        ItemStack item = player.getInventory().getItemInMainHand();

        if (!player.hasPermission("qolcommands.repair")) {
            player.sendMessage("§cYou don’t have permission to use this command!");
            return true;
        }


        if (item == null || item.getType() == Material.AIR) {
            player.sendMessage(ChatColor.RED + "You must hold an item in your hand that can be repaired!");
            return true;
        }

        if (plugin.getCooldownManager().isOnCooldown(player.getUniqueId(), "repair")) {
            long remaining = plugin.getCooldownManager().getRemainingTime(player.getUniqueId(), "repair");
            player.sendMessage("§cYou must wait " + remaining + " seconds before using this command again!");
            return true;
        }

        if (item.getItemMeta() instanceof Damageable damageable) {
            damageable.setDamage(0);
            item.setItemMeta(damageable);
            player.sendMessage(ChatColor.GREEN + "Your item has been successfully repaired!");


            plugin.getCooldownManager().setCooldown(player.getUniqueId(), "repair");
        } else {
            player.sendMessage(ChatColor.RED + "This item cannot be repaired!");
            return true;
        }
        return true;
    }
}
