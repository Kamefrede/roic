package com.kamefrede.roic.data;

import com.google.gson.JsonObject;
import com.kamefrede.roic.ROIC;
import com.kamefrede.roic.handler.ConfigHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class NoRingCondition implements ICondition {
    public static final NoRingCondition INSTANCE = new NoRingCondition();
    public static final ResourceLocation NAME = new ResourceLocation(ROIC.MODID, "no_ring");

    @Override
    public ResourceLocation getID() {
        return NAME;
    }

    @Override
    public boolean test() {
        return !ConfigHandler.COMMON.disableRing.get();
    }

    public NoRingCondition() {

    }

    @Override
    public String toString() {
        return "no_ring";
    }

    public static class Serializer implements IConditionSerializer<NoRingCondition> {
        public static final NoRingCondition.Serializer INSTANCE = new NoRingCondition.Serializer();

        @Override
        public void write(JsonObject json, NoRingCondition value) {
        }

        @Override
        public NoRingCondition read(JsonObject json) {
            return NoRingCondition.INSTANCE;
        }

        @Override
        public ResourceLocation getID() {
            return NoRingCondition.NAME;
        }
    }
}
