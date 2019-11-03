package com.kamefrede.roic.util;

import com.kamefrede.roic.ROIC;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_UNKNOWN;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = ROIC.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KeybindHandler {

    public static final KeyBinding hotbarModifier = new KeyBinding(ROIC.MODID + ".key.hotbarModifier", GLFW_KEY_UNKNOWN, "key.categories." + ROIC.MODID);

    @SubscribeEvent
    public static void clientStuff(FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(hotbarModifier);
    }
}
