package ru.daedal_dev.spigrestbukkit.controller;

import org.bukkit.BanEntry;
import ru.daedal_dev.spigrestbukkit.Plugin;
import ru.daedal_dev.spigrestbukkit.object.rest.SpigotServer;

import java.util.HashMap;

import static spark.Spark.get;

public class BanController {

    public BanController(Plugin plugin) {
        get("/ban/:nick", (request, response) -> {
            BanEntry entry = SpigotServer.getBanList().getBanEntry(request.params(":nick"));new HashMap<String, String>() {{
                put("admin", entry.getSource());
                put("player", entry.getTarget());
                put("reason", entry.getReason());
                put("creation_date", entry.getCreated().toString());
                put("expiration_date", entry.getExpiration().toString());}};
        });
        get("/ban/:nick/admin", (request, response) -> {
            BanEntry entry = SpigotServer.getBanList().getBanEntry(request.params(":nick"));
            return entry.getSource();
        });
        get("/ban/:nick/reason", (request, response) -> {
            BanEntry entry = SpigotServer.getBanList().getBanEntry(request.params(":nick"));
            return entry.getReason();
        });
        get("/ban/:nick/creation_date", (request, response) -> {
            BanEntry entry = SpigotServer.getBanList().getBanEntry(request.params(":nick"));
            return entry.getCreated().toString();
        });
        get("/ban/:nick/expiration_date", (request, response) -> {
            BanEntry entry = SpigotServer.getBanList().getBanEntry(request.params(":nick"));
            return entry.getExpiration().toString();
        });
    }
}
