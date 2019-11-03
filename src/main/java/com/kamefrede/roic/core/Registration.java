package com.kamefrede.roic.core;

import com.kamefrede.roic.ROIC;
import com.kamefrede.roic.item.ROICItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = ROIC.MODID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class Registration {
    @ObjectHolder("roic:roic")
    public static final ROICItem ROIC_ITEM = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event){
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(new ROICItem());
    }
}
