package ru.daedal_dev.spigrestbukkit.controller;

import ru.daedal_dev.spigrestbukkit.Plugin;
import ru.daedal_dev.spigrestbukkit.object.rest.SpigotServer;
import static spark.Spark.get;

public class ServerController {
    public ServerController(Plugin plugin) {
        get("/server/tps", (request, response) -> SpigotServer.getTPS());
    }
}
