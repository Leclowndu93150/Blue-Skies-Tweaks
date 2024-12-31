package com.leclowndu93150.bstweaks;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;

public class CustomCookingSerializer<T extends CustomCookingRecipe> implements RecipeSerializer<T> {
    private final int defaultCookingTime;
    private final CookieBaker<T> factory;

    public CustomCookingSerializer(CookieBaker<T> factory, int defaultCookingTime) {
        this.defaultCookingTime = defaultCookingTime;
        this.factory = factory;
    }

    @Override
    public T fromJson(ResourceLocation recipeId, JsonObject json) {
        String group = GsonHelper.getAsString(json, "group", "");
        JsonElement ingredient = GsonHelper.isArrayNode(json, "ingredient") ?
                GsonHelper.getAsJsonArray(json, "ingredient") :
                GsonHelper.getAsJsonObject(json, "ingredient");

        Ingredient input = Ingredient.fromJson(ingredient);
        ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
        float experience = GsonHelper.getAsFloat(json, "experience", 0.0F);
        int cookingTime = GsonHelper.getAsInt(json, "cookingtime", this.defaultCookingTime);

        return this.factory.create(recipeId, group, input, output, experience, cookingTime);
    }

    @Override
    public T fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
        String group = buffer.readUtf();
        Ingredient input = Ingredient.fromNetwork(buffer);
        ItemStack output = buffer.readItem();
        float experience = buffer.readFloat();
        int cookingTime = buffer.readVarInt();
        return this.factory.create(recipeId, group, input, output, experience, cookingTime);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buffer, T recipe) {
        buffer.writeUtf(recipe.getGroup());
        recipe.getIngredients().get(0).toNetwork(buffer);
        buffer.writeItem(recipe.getResultItem());
        buffer.writeFloat(recipe.getExperience());
        buffer.writeVarInt(recipe.getCookingTime());
    }

    public interface CookieBaker<T extends CustomCookingRecipe> {
        T create(ResourceLocation id, String group, Ingredient input, ItemStack output, float experience, int cookingTime);
    }
}