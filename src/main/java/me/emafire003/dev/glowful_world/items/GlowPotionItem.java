package me.emafire003.dev.glowful_world.items;

import me.emafire003.dev.glowful_world.GlowfulWorld;
import me.emafire003.dev.potionrecipes.BrewingRecipeRegister;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GlowPotionItem {
    
    public static Potion GLOWING = register("glowing", new Potion(new StatusEffectInstance[]{new StatusEffectInstance(StatusEffects.GLOWING, 900)}));
    public static Potion LONG_GLOWING = register("long_glowing", new Potion("glowing", new StatusEffectInstance[]{new StatusEffectInstance(StatusEffects.GLOWING, 1800)}));
    public static Potion STRONG_GLOWING = register("strong_glowing", new Potion("glowing", new StatusEffectInstance[]{new StatusEffectInstance(StatusEffects.GLOWING, 450, 1)}));
    

    private static Potion register(String name, Potion potion) {
        return (Potion) Registry.register(Registry.POTION, new Identifier(GlowfulWorld.MOD_ID, name), potion);
    }

    public static void registerPotionItems() {
        GlowfulWorld.LOGGER.info("Registering Glow Potion item");
        registerPotionRecipes();
    }

    public static void registerPotionRecipes(){
        BrewingRecipeRegister.registerPotionRecipe(Potions.AWKWARD, Items.GLOW_BERRIES, GlowPotionItem.GLOWING);
        BrewingRecipeRegister.registerPotionRecipe(GlowPotionItem.GLOWING, Items.REDSTONE, GlowPotionItem.LONG_GLOWING);
        BrewingRecipeRegister.registerPotionRecipe(GlowPotionItem.GLOWING, Items.GLOWSTONE_DUST, GlowPotionItem.STRONG_GLOWING);
    }

}
