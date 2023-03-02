package ru.daedal_dev.spigrestbukkit;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Plugin extends JavaPlugin {

    private Logger log;
    private FileConfiguration config;
    private static Plugin instance;
    private Application app;

    @Override
    public void onEnable() {
        long start = System.currentTimeMillis();
        log = getLogger();
        config = getConfig();
        saveDefaultConfig();
        startApplication();
        log.info("");
        log.info(ChatColor.translateAlternateColorCodes('&', "&eSpigREST ©&rdeveloped by github.com/daedal-dev-ru"));
        log.info(ChatColor.translateAlternateColorCodes('&', "&eThis plugin is an exclusive only for &6spigotmc.ru"));
        log.info(ChatColor.translateAlternateColorCodes('&', "&cIf you did not download this plugin from this site, you may have been the victim of a hacker attack"));
        log.info("");
        long end = System.currentTimeMillis();
        log.info(ChatColor.translateAlternateColorCodes('&', String.format(config.getString("messages.plugin.enabled"), (end-start))));
    }

    @Override
    public void onDisable() {
        app.stopServer();
        log.info(ChatColor.translateAlternateColorCodes('&', config.getString("messages.plugin.disabled")));
    }

    public void startApplication() {
        app = new Application(this, config.getInt("server.port"), config.getInt("server.maxThreads"));
        app.startServer();
    }

    public void reload() {
        reloadConfig();
        app.stopServer();
        startApplication();
    }
}
