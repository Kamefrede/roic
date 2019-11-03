package com.kamefrede.roic.core;

import com.kamefrede.roic.ROIC;
import com.kamefrede.roic.handler.ConfigHandler;
import com.kamefrede.roic.item.ROICItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = ROIC.MODID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class Registration {
    @ObjectHolder("roic:roic")
    public static final ROICItem ROIC_ITEM = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event){
        IForgeRegistry<Item> registry = event.getRegistry();
        Item.Properties props = new Item.Properties().maxStackSize(1).defaultMaxDamage(0);
        if (ConfigHandler.COMMON.disableRing.get())
            register(registry, new ROICItem(props), "roic");
        else
            register(registry, new ROICItem(props.group(ItemGroup.TOOLS)), "roic");
    }

    private static <V extends R, R extends IForgeRegistryEntry<R>> V register(IForgeRegistry<R> registry, V value, String name) {
        value.setRegistryName(new ResourceLocation(ROIC.MODID, name));
        registry.register(value);
        return value;
    }
}
