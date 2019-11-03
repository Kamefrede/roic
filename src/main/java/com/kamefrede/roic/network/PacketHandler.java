package com.kamefrede.roic.network;

import com.kamefrede.roic.ROIC;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import org.omg.CORBA.ObjectHolder;

public class PacketHandler {
    private static final String PROTOCOL = "1";
    public static final SimpleChannel NETWORK = NetworkRegistry.newSimpleChannel(new ResourceLocation(ROIC.MODID, "channel"),
            () -> PROTOCOL,
            PROTOCOL::equals,
            PROTOCOL::equals);

    public static void init(){
        int id = 0;
        NETWORK.registerMessage(id++, PacketSwapItems.class, PacketSwapItems::encode, PacketSwapItems::decode, PacketSwapItems::handle);
    }

    public static void sendToServer(Object msg){
        NETWORK.sendToServer(msg);
    }
}
