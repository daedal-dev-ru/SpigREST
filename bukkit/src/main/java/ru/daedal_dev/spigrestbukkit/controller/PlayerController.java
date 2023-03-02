package ru.daedal_dev.spigrestbukkit.controller;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import ru.daedal_dev.spigrestbukkit.handler.player.PlayerUUID;
import ru.daedal_dev.spigrestbukkit.object.rest.SpigotPlayer;

import static spark.Spark.get;

public class PlayerController {
    private final Plugin plugin;
    private final FileConfiguration config;

    public PlayerController(Plugin plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
        new PlayerUUID(plugin);
        get("/player/:nick/xp", (request, response) -> new SpigotPlayer(request.params(":nick")).getXP());
        get("/player/:nick/level", (request, response) -> new SpigotPlayer(request.params(":nick")).getLevel());
        get("/player/:nick/food", (request, response) -> new SpigotPlayer(request.params(":nick")).getFood());
        get("/player/:nick/location", (request, response) -> new SpigotPlayer(request.params(":nick")).getLocation());
    }
}
