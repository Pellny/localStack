package de.lukasdev.localestack.tab;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.TabCompleteEvent;

public class TabComplete implements Listener {


    @EventHandler
    public void onTabComplete(TabCompleteEvent event) {
        String partialCommand = event.getBuffer();

        if (partialCommand.startsWith("/") && !event.getSender().hasPermission("tabcomplete.bypass")) {
            event.setCancelled(true);
        }
    }
}