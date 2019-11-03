package com.kamefrede.roic.handler;

import com.kamefrede.roic.ROIC;
import com.kamefrede.roic.Util;
import com.kamefrede.roic.core.Registration;
import com.kamefrede.roic.network.PacketHandler;
import com.kamefrede.roic.network.PacketSwapItems;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = ROIC.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class EventHandler {

    @SubscribeEvent
    public static void scrollEvent(InputEvent.MouseScrollEvent event){
        boolean invert = ConfigHandler.CLIENT.invertDirection.get();
        boolean direction = event.getScrollDelta() == -1.0;
        PlayerEntity player = Minecraft.getInstance().player;

        if (invert)
            direction = !direction;
        if(player.isSneaking())
            if (Util.findItem(Registration.ROIC_ITEM, player) != ItemStack.EMPTY){
                PacketHandler.sendToServer(new PacketSwapItems(direction && invert));
                event.setCanceled(true);
            }

    }
}
