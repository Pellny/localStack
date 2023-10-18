package de.lukasdev.localestack;

import de.lukasdev.localestack.Events.log;
import de.lukasdev.localestack.Verification.HumanVerification;
import de.lukasdev.localestack.commands.LogCommand;
import de.lukasdev.localestack.tab.TabComplete;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Localestack extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("enabled");
        Bukkit.getPluginManager().registerEvents(new log(), this);
        Bukkit.getPluginManager().registerEvents(new TabComplete(), this);
        Bukkit.getPluginManager().registerEvents(new HumanVerification(), this);
        getCommand("localestack").setExecutor(new LogCommand());


    }

    @Override
    public void onDisable() {
    }
}
