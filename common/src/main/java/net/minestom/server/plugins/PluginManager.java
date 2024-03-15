package net.minestom.server.plugins;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class PluginManager {

    private static final Path PLUGINS_DIRECTORY = Path.of("plugins");
    private final List<PluginInfo> plugins = new ArrayList<>();

    public PluginManager() {
        try {
            if (!Files.exists(PLUGINS_DIRECTORY)) {
                Files.createDirectory(PLUGINS_DIRECTORY);
            }

            Files.list(PLUGINS_DIRECTORY).filter(path -> path.toString().endsWith(".jar")).forEach(path -> plugins.add(new PluginInfo(path.toFile())));

            // load all meta data
            for (var plugin : plugins) {
                var jarUrl = new URL("jar:file:" + plugin.getFile().getAbsolutePath() + "!/plugin.json");

                try (var inputStream = jarUrl.openStream()) {
                    //todo: load plugin.json
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
