package com.kamefrede.roic.network;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;


public class PacketSwapItems {
    boolean direction;
    boolean hotbar;


    public PacketSwapItems(boolean direction, boolean hotbar) {
        this.direction = direction;
        this.hotbar = hotbar;
    }

    public static void encode(PacketSwapItems msg, PacketBuffer buf){
        buf.writeBoolean(msg.direction);
        buf.writeBoolean(msg.hotbar);
    }

    public static PacketSwapItems decode(PacketBuffer buf){
        return new PacketSwapItems(buf.readBoolean(), buf.readBoolean());
    }

    public static void handle(PacketSwapItems msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() ->{
            PlayerEntity playerEntity = ctx.get().getSender();
            if (playerEntity != null) {
                if (msg.hotbar) {
                    for (int i = 0; i <= 8; i++) {
                        cycle(msg.direction, i, playerEntity);
                    }
                } else {
                    cycle(msg.direction, playerEntity.inventory.currentItem, playerEntity);
                }
            }


        });


    }

    public static void cycle(boolean direction, int pos1, PlayerEntity playerEntity) {
        int pos2 = pos1 + 9;
        int pos3 = pos2 + 9;
        int pos4 = pos3 + 9;

        ItemStack stack1 = playerEntity.inventory.getStackInSlot(pos1);
        ItemStack stack2 = playerEntity.inventory.getStackInSlot(pos2);
        ItemStack stack3 = playerEntity.inventory.getStackInSlot(pos3);
        ItemStack stack4 = playerEntity.inventory.getStackInSlot(pos4);

        playerEntity.inventory.setInventorySlotContents(pos1, ItemStack.EMPTY);
        playerEntity.inventory.setInventorySlotContents(pos2, ItemStack.EMPTY);
        playerEntity.inventory.setInventorySlotContents(pos3, ItemStack.EMPTY);
        playerEntity.inventory.setInventorySlotContents(pos4, ItemStack.EMPTY);

        if (direction) {
            playerEntity.inventory.setInventorySlotContents(pos1, stack4);
            playerEntity.inventory.setInventorySlotContents(pos2, stack1);
            playerEntity.inventory.setInventorySlotContents(pos3, stack2);
            playerEntity.inventory.setInventorySlotContents(pos4, stack3);
        } else {
            playerEntity.inventory.setInventorySlotContents(pos1, stack2);
            playerEntity.inventory.setInventorySlotContents(pos2, stack3);
            playerEntity.inventory.setInventorySlotContents(pos3, stack4);
            playerEntity.inventory.setInventorySlotContents(pos4, stack1);
        }
    }
}
