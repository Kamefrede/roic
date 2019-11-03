package com.kamefrede.roic.data;

import com.kamefrede.roic.handler.ConfigHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;

public class NoRingCondition implements ICondition {
    public static final NoRingCondition INSTANCE = new NoRingCondition();

    @Override
    public ResourceLocation getID() {
        return null;
    }

    @Override
    public boolean test() {
        return !ConfigHandler.COMMON.disableRing.get();
    }


}
