package com.kamefrede.roic.handler;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ConfigHandler {

    public static class Client {
        public final ForgeConfigSpec.BooleanValue invertDirection;

        public Client(ForgeConfigSpec.Builder builder) {
            invertDirection = builder.comment("Set to true to invert the direction of the scroll so that: " + "\n" +
                    "Mouse scroll down = Items cycle up" + "\n" +
                    "Mouse scroll up = Items cycle down")
                    .define("invert.direction", false);
        }


    }

    public static final Client CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;

    static {
        final Pair<Client, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Client::new);
        CLIENT_SPEC = specPair.getRight();
        CLIENT = specPair.getLeft();
    }
}
