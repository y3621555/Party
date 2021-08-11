package com.johnson.party;

import com.johnson.party.Command.PartyCommands;
import com.johnson.party.config.config;
import org.bukkit.plugin.java.JavaPlugin;

public final class Party extends JavaPlugin {
    public config config;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.config = new config(this);

        getCommand("party").setExecutor(new PartyCommands());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
