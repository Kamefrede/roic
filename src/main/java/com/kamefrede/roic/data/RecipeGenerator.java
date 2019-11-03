package com.kamefrede.roic.data;

import com.kamefrede.roic.ROIC;
import com.kamefrede.roic.core.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.common.data.ForgeRecipeProvider;

import java.util.function.Consumer;

public class RecipeGenerator extends ForgeRecipeProvider implements IConditionBuilder {

    public RecipeGenerator(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(
                        NoRingCondition.INSTANCE
                )
                .addRecipe(ShapedRecipeBuilder.shapedRecipe(Registration.ROIC_ITEM)
                        .key('g', Tags.Items.INGOTS_GOLD)
                        .key('i', Tags.Items.NUGGETS_IRON)
                        .key('l', Tags.Items.GEMS_LAPIS)
                        .patternLine("lgi")
                        .patternLine("g g")
                        .patternLine("igi")
                        .addCriterion("got_gold", hasItem(Tags.Items.INGOTS_GOLD))
                        ::build)
                .build(consumer, new ResourceLocation(ROIC.MODID, "roic"));


    }
}
