package io.dizie.snap;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("Snap").setExecutor(new Snap());
    }

    @Override
    public void onDisable() {

    }
}
