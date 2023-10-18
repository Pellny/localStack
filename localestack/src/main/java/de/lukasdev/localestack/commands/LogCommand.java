package de.lukasdev.localestack.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogCommand  implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("showhanddata")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                try {
                    FileReader fileReader = new FileReader("localStack.txt");
                    BufferedReader reader = new BufferedReader(fileReader);
                    String line;
                    while ((line = reader.readLine()) != null) {
                        player.sendMessage(line);
                    }
                    reader.close();
                } catch (IOException e) {
                    player.sendMessage("Fehler beim Lesen der Daten.");
                    e.printStackTrace();
                }
                return true;
            } else {
                sender.sendMessage("Dieser Befehl ist nur für Spieler verfügbar.");
            }
        }
        return false;
    }
}