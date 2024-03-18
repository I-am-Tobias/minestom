package net.minestom.plugin;

import net.minestom.server.plugins.Plugin;

public class GamePlugin extends Plugin {

    public GamePlugin() {
    }

    @Override
    public void onEnable() {
        System.out.println("plugin enable");
    }

    @Override
    public void onDisable() {
        System.out.println("plugin disable");
    }
}
