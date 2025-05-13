package com.leclowndu93150.bstweaks.mixin;

import net.minecraftforge.event.entity.living.MobSpawnEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.legacy.blue_skies.events.SkiesEvents;

@Mixin(SkiesEvents.class)
public abstract class SkiesEventsMixin {

    @Inject(
            method = "onEntityCheckSpawn",
            at = @At("HEAD"),
            cancellable = true,
            remap = false
    )
    private static void removeSpawnBlocker(MobSpawnEvent.FinalizeSpawn event, CallbackInfo ci) {
        ci.cancel();
    }
}