package ru.daedal_dev.spigrestbukkit.api.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import spark.Request;

public class RequestEvent extends Event implements Cancellable {
    private HandlerList handlers;
    private final Request request;
    private boolean cancelled;

    public RequestEvent(Request request) {
        this.request = request;
    }
    public Request getRequest() {
        return this.request;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
