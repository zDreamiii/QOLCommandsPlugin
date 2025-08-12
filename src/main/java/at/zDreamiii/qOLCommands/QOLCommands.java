package at.zDreamiii.qOLCommands;


import org.bukkit.plugin.java.JavaPlugin;

public final class QOLCommands extends JavaPlugin {

    @Override
    public void onEnable() {

        this.getCommand("heal").setExecutor(new Heal());
        this.getCommand("feed").setExecutor(new Feed());
        this.getCommand("repair").setExecutor(new Repair());
        this.getCommand("gamemode").setExecutor(new Gamemode());

    }
}
