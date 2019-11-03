package com.kamefrede.roic.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import top.theillusivec4.curios.api.capability.ICurio;
import top.theillusivec4.curios.common.capability.CapCurioItem;

import javax.annotation.Nullable;

public class ROICItem extends Item {

    public ROICItem(Item.Properties props) {
        super(props);
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
        return CapCurioItem.createProvider(new ICurio() {
            @Override
            public void onCurioTick(String identifier, int index, LivingEntity livingEntity) {
                //no-op
            }

            @Override
            public void playEquipSound(LivingEntity livingEntity) {
                livingEntity.playSound(SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 1.0f, 1.0f);
            }

            @Override
            public boolean canRightClickEquip() {
                return true;
            }
        });
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

}
