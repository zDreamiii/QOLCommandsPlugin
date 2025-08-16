package at.zDreamiii.qOLCommands;


import org.bukkit.plugin.java.JavaPlugin;

public final class QOLCommands extends JavaPlugin {

    private CooldownManager cooldownManager;

    @Override
    public void onEnable() {

        saveDefaultConfig();
        cooldownManager = new CooldownManager(this);

        this.getCommand("heal").setExecutor(new Heal(this));
        this.getCommand("feed").setExecutor(new Feed(this));
        this.getCommand("repair").setExecutor(new Repair(this));
        this.getCommand("gamemode").setExecutor(new Gamemode());

    }

    public CooldownManager getCooldownManager() {
        return cooldownManager;
    }
}
