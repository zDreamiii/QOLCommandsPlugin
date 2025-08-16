package at.zDreamiii.qOLCommands;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CooldownManager {

    private final QOLCommands plugin;
    private final Map<String, Long> cooldowns = new HashMap<>();

    public CooldownManager(QOLCommands plugin) {
        this.plugin = plugin;
    }

    public boolean isOnCooldown(UUID uuid, String command) {
        String key = uuid.toString() + ":" + command;
        if (!cooldowns.containsKey(key)) {
            return false;
        }
        long expireTime = cooldowns.get(key);
        return System.currentTimeMillis() < expireTime;
    }

    public long getRemainingTime(UUID uuid, String command) {
        String key = uuid.toString() + ":" + command;
        if (!cooldowns.containsKey(key)) {
            return 0;
        }
        long expireTime = cooldowns.get(key);
        long remaining = expireTime - System.currentTimeMillis();
        return Math.max(0, remaining / 1000);
    }

    public void setCooldown(UUID uuid, String command) {
        int cooldown = plugin.getConfig().getInt("cooldowns." + command, 300);
        long expireTime = System.currentTimeMillis() + (cooldown * 1000L);
        cooldowns.put(uuid.toString() + ":" + command, expireTime);
    }
}
