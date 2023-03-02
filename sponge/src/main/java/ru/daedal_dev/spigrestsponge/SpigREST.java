package ru.daedal_dev.spigrestsponge;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.plugin.Plugin;

@Plugin(
        id = "spigrest-sponge",
        name = "SpigRESTSponge",
        version = "1.0-SNAPSHOT",
        url = "vk.com/daedal_dev",
        authors = {
                "Daedal"
        }
)
public class SpigREST {

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
    }
}
