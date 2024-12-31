package com.leclowndu93150.bstweaks;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class CustomCookingRecipe extends AbstractCookingRecipe {
    private final RecipeSerializer<?> serializer;
    private final RecipeType<?> type;

    public CustomCookingRecipe(ResourceLocation id, String group, Ingredient input, ItemStack output, float exp, int time, RecipeSerializer<?> serializer, RecipeType<?> type) {
        super(type, id, group, input, output, exp, time);
        this.serializer = serializer;
        this.type = type;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return this.serializer;
    }

    @Override
    public RecipeType<?> getType() {
        return this.type;
    }
}
