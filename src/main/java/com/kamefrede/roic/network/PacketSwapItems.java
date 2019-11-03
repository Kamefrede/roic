package com.kamefrede.roic.network;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;


public class PacketSwapItems {

    private ItemStack stack1;
    private ItemStack stack2;
    private int pos1;
    private int pos2;

    public PacketSwapItems(ItemStack stack1, ItemStack stack2, int pos1, int pos2){
        this.stack1 = stack1;
        this.stack2 = stack2;
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    public static void encode(PacketSwapItems msg, PacketBuffer buf){
        buf.writeItemStack(msg.stack1);
        buf.writeItemStack(msg.stack2);
        buf.writeVarInt(msg.pos1);
        buf.writeVarInt(msg.pos2);
    }

    public static PacketSwapItems decode(PacketBuffer buf){
        return new PacketSwapItems(buf.readItemStack(), buf.readItemStack(), buf.readVarInt(), buf.readVarInt());
    }

    public static void handle(PacketSwapItems msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() ->{
            PlayerEntity playerEntity = ctx.get().getSender();
            playerEntity.inventory.setInventorySlotContents(msg.pos2, msg.stack1);
            playerEntity.inventory.setInventorySlotContents(msg.pos1, msg.stack2);

        });


    }
}
