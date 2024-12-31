package com.leclowndu93150.bstweaks;

public class ForgeSerializer extends CustomCookingSerializer<CustomCookingRecipe> {
    public ForgeSerializer(int defaultCookingTime) {
        super((id, group, input, output, exp, time) ->
                        new CustomCookingRecipe(id, group, input, output, exp, time,
                                BSTweaks.HORIZONITE_FORGING_SERIALIZER.get(),
                                BSTweaks.HORIZONITE_FORGING.get()),
                defaultCookingTime);
    }
}
