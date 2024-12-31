package com.leclowndu93150.bstweaks;

import com.mojang.logging.LogUtils;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(BSTweaks.MODID)
public class BSTweaks {
    public static final String MODID = "bstweaks";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registry.RECIPE_TYPE_REGISTRY, MODID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registry.RECIPE_SERIALIZER_REGISTRY, MODID);

    public static final RegistryObject<RecipeType<CustomCookingRecipe>> HORIZONITE_FORGING = RECIPE_TYPES.register("horizonite_forging", () -> new RecipeType<>() {});
    public static final RegistryObject<RecipeType<CustomCookingRecipe>> SNOWCAP_FREEZING = RECIPE_TYPES.register("snowcap_freezing", () -> new RecipeType<>() {});

    public static final RegistryObject<CustomCookingSerializer<CustomCookingRecipe>> HORIZONITE_FORGING_SERIALIZER = RECIPE_SERIALIZERS.register("horizonite_forging", () -> new ForgeSerializer(200));
    public static final RegistryObject<CustomCookingSerializer<CustomCookingRecipe>> SNOWCAP_FREEZING_SERIALIZER = RECIPE_SERIALIZERS.register("snowcap_freezing", () -> new FreezingSerializer(200));

    public BSTweaks() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        RECIPE_TYPES.register(modEventBus);
        RECIPE_SERIALIZERS.register(modEventBus);
    }
}
