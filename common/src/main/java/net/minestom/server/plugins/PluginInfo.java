package net.minestom.server.plugins;

import org.jetbrains.annotations.Nullable;

import java.io.File;

public final class PluginInfo {

    private @Nullable Plugin plugin;

    private final File file;
    private PluginState state = PluginState.INITIALIZING;

    public PluginInfo(File file) {
        this.file = file;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public File getFile() {
        return file;
    }

    public PluginState getState() {
        return state;
    }
}
