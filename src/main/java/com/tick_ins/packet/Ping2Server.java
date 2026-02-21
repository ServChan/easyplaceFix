package com.tick_ins.packet;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.PlayerListEntry;

public final class Ping2Server {
    private Ping2Server() {
    }

    public static int getRtt() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client == null || client.player == null || client.getNetworkHandler() == null) {
            return 150;
        }

        PlayerListEntry entry = client.getNetworkHandler().getPlayerListEntry(client.player.getUuid());
        if (entry == null) {
            return 150;
        }

        int latency = entry.getLatency();
        return Math.max(latency, 50);
    }
}
