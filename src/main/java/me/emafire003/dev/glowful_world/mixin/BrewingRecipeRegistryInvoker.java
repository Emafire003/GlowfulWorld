package me.emafire003.dev.glowful_world.mixin;

import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BrewingRecipeRegistry.class)
public interface BrewingRecipeRegistryInvoker {
    @Invoker("registerPotionRecipe")
    public static void registerPotionRecipe(Potion input, Item item, Potion output) {
        throw new AssertionError();
    }
}
