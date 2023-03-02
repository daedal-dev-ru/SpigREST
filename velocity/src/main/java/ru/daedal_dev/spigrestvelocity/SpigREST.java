package ru.daedal_dev.spigrestvelocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.lifecycle.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import org.slf4j.Logger;

@Plugin(
        id = "spigrest-velocity",
        name = "SpigRESTVelocity",
        version = "1.0-SNAPSHOT",
        url = "vk.com/daedal_dev",
        authors = {"Daedal"}
)
public class SpigREST {

    @Inject
    private Logger logger;

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
    }
}
