package ru.daedal_dev.spigrestbukkit.handler;

import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import ru.daedal_dev.spigrestbukkit.Plugin;
import ru.daedal_dev.spigrestbukkit.api.events.RequestEvent;

import java.util.logging.Logger;

import static spark.Spark.before;
import static spark.Spark.halt;

public class BaseHandler {
    public BaseHandler(@NonNull Plugin plugin, boolean isProtected, boolean fireEvent, boolean isLogged) {
        if (fireEvent) {
            before((request, response) -> {
                RequestEvent requestEvent = new RequestEvent(request);
                Bukkit.getPluginManager().callEvent(requestEvent);
                if (requestEvent.isCancelled()) {
                    halt(501, "Not implemented");
                }
            });
        }
        if (isProtected) {
            before((request, response) -> {

                halt(401, "Not authorized");
            });
        }
        if (isLogged) {
            Logger log = plugin.getLogger();
            before((request, response) -> log.info(ChatColor.translateAlternateColorCodes('&',
                    "&e----- Spig&6&lREST &e-----" +
                                "\n&eReceived API call from IP &6 " + request.ip() +
                                "\n&eURL: &6 " + request.url() +
                                "\n&eURL: &6" + request.url() +
                                "\n&eMethod: &6 " + request.requestMethod() +
                                "\n&eProtocol: &6 " + request.protocol() +
                                "\n&eHeaders: &6 " + request.headers() +
                                "\n&eCookies: &6 " + request.cookies() +
                                "\n&eParams: &6" + request.params() +
                                "\n")));
        }
    }
}
