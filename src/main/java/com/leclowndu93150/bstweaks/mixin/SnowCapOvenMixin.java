package com.leclowndu93150.bstweaks.mixin;

import com.leclowndu93150.bstweaks.BSTweaks;
import com.legacy.blue_skies.block_entity.SnowcapOvenBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = SnowcapOvenBlockEntity.class, remap = false)
public class SnowCapOvenMixin {
    @Shadow public RecipeType<SmeltingRecipe> ovenRecipeType;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void injectCustomRecipeType(BlockPos pos, BlockState state, CallbackInfo ci) {
        ovenRecipeType = (RecipeType<SmeltingRecipe>)(Object)BSTweaks.SNOWCAP_FREEZING.get();
    }

    @ModifyArg(
            method = "ovenServerTick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/crafting/RecipeManager;getRecipeFor(Lnet/minecraft/world/item/crafting/RecipeType;Lnet/minecraft/world/Container;Lnet/minecraft/world/level/Level;)Ljava/util/Optional;"
            ),
            index = 0
    )
    private static RecipeType<?> modifyRecipeType(RecipeType<?> recipeType) {
        return BSTweaks.SNOWCAP_FREEZING.get();
    }

    @ModifyArg(
            method = "getTotalCookTime",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/crafting/RecipeManager;getRecipeFor(Lnet/minecraft/world/item/crafting/RecipeType;Lnet/minecraft/world/Container;Lnet/minecraft/world/level/Level;)Ljava/util/Optional;"
            ),
            index = 0
    )
    private static RecipeType<?> modifyRecipeTypeForCookTime(RecipeType<?> recipeType) {
        return BSTweaks.SNOWCAP_FREEZING.get();
    }
}