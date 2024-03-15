package net.minestom.pvp;

import net.minestom.pvp.configuration.GsonUtils;
import net.minestom.pvp.configuration.ToolConfiguation;
import net.minestom.server.MinecraftServer;

public class Pvp  {

    private static Pvp instance;
    private ToolConfiguation toolConfiguation;

    public void initialize() {
        instance = this;

        this.toolConfiguation = GsonUtils.readConfiguration(this, "tools.json", ToolConfiguation.class);


        MinecraftServer.getGlobalEventHandler().addChild(PvpBuilder.of(PvpMode.LEGACY).build());
    }

    public static Pvp getInstance() {
        return instance;
    }

    public ToolConfiguation getToolConfiguation() {
        return toolConfiguation;
    }
}
