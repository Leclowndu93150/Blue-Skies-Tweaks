package com.leclowndu93150.bstweaks;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(BSTweaks.MODID)
public class BSTweaks {
    public static final String MODID = "bstweaks";
    public static final Logger LOGGER = LogUtils.getLogger();

    public BSTweaks() {
        //IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //FMLJavaModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SkiesSpawnConfig.SPEC);
        //RECIPE_TYPES.register(modEventBus);
        //RECIPE_SERIALIZERS.register(modEventBus);
    }
}
