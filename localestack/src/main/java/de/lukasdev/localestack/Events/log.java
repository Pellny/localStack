package de.lukasdev.localestack.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class log  implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName();
        String blockInHand = player.getInventory().getItemInMainHand().getType().name();
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        logToExternalFile(playerName, blockInHand, timeStamp);
    }

    private void logToExternalFile(String playerName, String blockInHand, String timeStamp) {
        try (FileWriter writer = new FileWriter("localStack.txt", true)) {
            writer.write("Spieler: " + playerName + " Block: " + blockInHand + " Uhrzeit: " + timeStamp + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
