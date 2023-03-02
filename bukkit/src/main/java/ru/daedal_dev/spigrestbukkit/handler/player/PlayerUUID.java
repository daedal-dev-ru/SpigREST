package ru.daedal_dev.spigrestbukkit.handler.player;

import lombok.NonNull;
import ru.daedal_dev.spigrestbukkit.Plugin;
import ru.daedal_dev.spigrestbukkit.handler.BaseHandler;
import ru.daedal_dev.spigrestbukkit.object.rest.SpigotPlayer;

import static spark.Spark.get;

public class PlayerUUID extends BaseHandler {
    public PlayerUUID(@NonNull Plugin plugin, boolean isProtected, boolean isLogged) {
        super(plugin, isProtected, isLogged);
    }

    public void init() {
        get("/player/:nick/uuid", (request, response) -> new SpigotPlayer(request.params(":nick")));
    }
}
