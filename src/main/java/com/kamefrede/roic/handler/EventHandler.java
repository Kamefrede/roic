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

    public static final String TAG_LAST_POS1 = "roic:lastpos1";
    public static final String TAG_LAST_POS2 = "roic:lastpos2";

    @SubscribeEvent
    public static void scrollEvent(InputEvent.MouseScrollEvent event){
        PlayerEntity player = Minecraft.getInstance().player;
        if(player.isSneaking())
            if (Util.findItem(Registration.ROIC_ITEM, player) != ItemStack.EMPTY){
                int pos1 = player.inventory.currentItem;
                int pos2 = pos1 + 9;
                if(player.getPersistentData().contains(TAG_LAST_POS1) && player.getPersistentData().getInt(TAG_LAST_POS1) == pos1){
                    pos2 = player.getPersistentData().getInt(TAG_LAST_POS2) + 9;
                    if(pos2 > 3 * 9 + pos1){
                        pos2 = pos1 + 9;
                    }
                }
                ItemStack stack1 = player.inventory.getCurrentItem();
                ItemStack stack2 = player.inventory.getStackInSlot(pos2);
                player.getPersistentData().putInt(TAG_LAST_POS1, pos1);
                player.getPersistentData().putInt(TAG_LAST_POS2, pos2);
                PacketHandler.sendToServer(new PacketSwapItems(stack1, stack2, pos1, pos2));
                event.setCanceled(true);
            }

    }
}
