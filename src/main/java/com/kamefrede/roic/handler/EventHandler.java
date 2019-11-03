package com.kamefrede.roic.handler;

import com.kamefrede.roic.ROIC;
import com.kamefrede.roic.core.Registration;
import com.kamefrede.roic.network.PacketHandler;
import com.kamefrede.roic.network.PacketSwapItems;
import com.kamefrede.roic.util.KeybindHandler;
import com.kamefrede.roic.util.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Level;


@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = ROIC.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class EventHandler {


    @SubscribeEvent
    public static void scrollEvent(InputEvent.MouseScrollEvent event){
        ROIC.LOGGER.log(Level.INFO, KeybindHandler.hotbarModifier.isPressed());
        boolean invert = ConfigHandler.CLIENT.invertDirection.get();
        boolean noRing = ConfigHandler.COMMON.disableRing.get();
        boolean direction = event.getScrollDelta() == -1.0;
        PlayerEntity player = Minecraft.getInstance().player;

        if (invert)
            direction = !direction;
        if(player.isSneaking())
            if (noRing || Util.findItem(Registration.ROIC_ITEM, player) != ItemStack.EMPTY) {
                PacketHandler.sendToServer(new PacketSwapItems(direction, KeybindHandler.hotbarModifier.isPressed()));
                event.setCanceled(true);
            }

    }
}
