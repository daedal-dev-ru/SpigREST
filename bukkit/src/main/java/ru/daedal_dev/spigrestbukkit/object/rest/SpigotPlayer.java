package ru.daedal_dev.spigrestbukkit.object.rest;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class SpigotPlayer {
    private final Player player;
    private String nick;

    public SpigotPlayer(String nick) {
        this.player = Bukkit.getPlayer(nick);
    }

    public UUID getUuid() {
        return player.getUniqueId();
    }

    public double getHealth() { return player.getHealth(); }
    public float getXP() {
        return player.getExp();
    }
    public int getLevel() {
        return player.getLevel();
    }

    public int getFood() { return player.getFoodLevel(); }

    public HashMap<String, Integer> getInventory() {
        HashMap<String, Integer> inv = new HashMap<>();
        ItemStack[] items = player.getInventory().getContents();
        for (ItemStack item : items) {
            inv.put(item.getI18NDisplayName(), item.getAmount());
        }
        return inv;
    }

    public HashMap<String, Integer> getLocation() {
        Location loc = player.getLocation();
        return new HashMap<String, Integer>() {{
            put("x", loc.getBlockX());
            put("y", loc.getBlockY());
            put("z", loc.getBlockZ());
        }};
    }
}
