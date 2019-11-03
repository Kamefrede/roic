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
                    .define("client.invertDirection", false);
        }


    }

    public static final Client CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;

    static {
        final Pair<Client, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Client::new);
        CLIENT_SPEC = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    public static class Common {
        public final ForgeConfigSpec.BooleanValue disableRing;

        public Common(ForgeConfigSpec.Builder builder) {
            disableRing = builder.comment("Set to true to disable the necessity of having a ring")
                    .define("common.disableRing", false);
        }
    }

    public static final Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }
}
