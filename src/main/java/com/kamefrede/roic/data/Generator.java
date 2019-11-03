package com.kamefrede.roic.data;

import com.kamefrede.roic.ROIC;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = ROIC.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Generator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        event.getGenerator().addProvider(new RecipeGenerator(event.getGenerator()));
    }

    @SubscribeEvent
    public static void registerRecipeSerializers(RegistryEvent.Register<IRecipeSerializer<?>> event) {
        CraftingHelper.register(NoRingCondition.Serializer.INSTANCE);
    }
}
