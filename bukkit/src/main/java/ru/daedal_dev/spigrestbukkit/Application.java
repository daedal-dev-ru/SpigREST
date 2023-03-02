package ru.daedal_dev.spigrestbukkit;


import ru.daedal_dev.spigrestbukkit.controller.BanController;
import ru.daedal_dev.spigrestbukkit.controller.PlayerController;
import ru.daedal_dev.spigrestbukkit.controller.ServerController;

import java.util.logging.Logger;

import static spark.Spark.*;

public class Application {
    private final Plugin plugin;
    private final int port;
    private final int maxThreads;
    private Logger log;
    public Application(Plugin plugin, int port, int maxThreads) {
        this.plugin = plugin;
        this.port = port;
        this.maxThreads = maxThreads;
    }

    public static void hui() {
        plugin.getLogger();
    }
    public void startServer() {
        port(port);
        threadPool(maxThreads);
        init();
        new BanController(plugin);
        new PlayerController(plugin);
        new ServerController(plugin);
    }

    public void stopServer() {
        stop();
    }
}
