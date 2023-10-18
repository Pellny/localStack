package de.lukasdev.localestack.Verification;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class HumanVerification implements Listener {

    private Map<Player, String> verificationMap = new HashMap<>();
    private SecureRandom random = new SecureRandom();
    private int codeLength = 6;



    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String verificationCode = generateRandomCode();
        player.sendMessage("Bitte gib den folgenden Code im Chat ein: §e" + verificationCode + " §7(Verify)");
        verificationMap.put(player, verificationCode);
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        if (verificationMap.containsKey(player)) {
            String verificationCode = verificationMap.get(player);
            if (message.equals(verificationCode)) {
                player.sendMessage("Du hast die Menschlichkeitsüberprüfung bestanden!");
                verificationMap.remove(player);
            } else {
                player.sendMessage("§cFalscher Code. Du wirst gekickt.");
                player.kickPlayer("§cFalsche Menschlichkeitsüberprüfung.");
            }
        }
    }

    private String generateRandomCode() {
        StringBuilder code = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < codeLength; i++) {
            int index = random.nextInt(characters.length());
            code.append(characters.charAt(index));
        }
        return code.toString();
    }
}