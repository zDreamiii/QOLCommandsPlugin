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

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Nur Spieler können diesen Befehl verwenden!");
            return true;
        }

        Player player = (Player) sender;
        ItemStack item = player.getInventory().getItemInMainHand();

        if (!player.hasPermission("qolcommands.repair")) {
            player.sendMessage("§cDu hast keine Berechtigung, diesen Befehl zu nutzen!");
            return true;
        }


        if (item == null || item.getType() == Material.AIR) {
            player.sendMessage(ChatColor.RED + "Du musst ein Item in der Hand halten, welches man reparieren kann!");
            return true;
        }

        if (item.getItemMeta() instanceof Damageable damageable) {
            damageable.setDamage(0);
            item.setItemMeta(damageable);
            player.sendMessage( ChatColor.GREEN +"Dein Item wurde erfolgreich repariert!");
        } else {
            player.sendMessage(ChatColor.RED + "Dein Item kann nicht repariert werden!");
        }
        return true;
    }
}
