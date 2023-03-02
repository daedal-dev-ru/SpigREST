package ru.daedal_dev.spigrestbukkit.object.rest;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import ru.daedal_dev.spigrestbukkit.annotation.RestModel;

@RestModel(path = "/server")
public class SpigotServer {
    private static final Server server = Bukkit.getServer();

    public static double[] getTPS() {
        return server.getTPS();
    }
    public static BanList getBanList() {
        return server.getBanList(BanList.Type.NAME);
    }
}
