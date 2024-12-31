package com.leclowndu93150.bstweaks;

public class FreezingSerializer extends CustomCookingSerializer<CustomCookingRecipe> {
    public FreezingSerializer(int defaultCookingTime) {
        super((id, group, input, output, exp, time) ->
                        new CustomCookingRecipe(id, group, input, output, exp, time,
                                BSTweaks.SNOWCAP_FREEZING_SERIALIZER.get(),
                                BSTweaks.SNOWCAP_FREEZING.get()),
                defaultCookingTime);
    }
}
