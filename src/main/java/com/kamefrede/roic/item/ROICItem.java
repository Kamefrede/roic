package com.kamefrede.roic.item;

import com.kamefrede.roic.ROIC;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import top.theillusivec4.curios.api.capability.CuriosCapability;
import top.theillusivec4.curios.api.capability.ICurio;
import top.theillusivec4.curios.common.capability.CapCurioItem;

import javax.annotation.Nullable;

public class ROICItem extends Item {

    public ROICItem(){
        super(new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1).defaultMaxDamage(0));
        this.setRegistryName(ROIC.MODID, "roic");
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
}
