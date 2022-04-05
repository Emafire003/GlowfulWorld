package me.emafire003.dev.glowful_world;

import me.emafire003.dev.coloredglowlib.ColoredGlowLib;
import me.emafire003.dev.coloredglowlib.util.Color;
import me.emafire003.dev.glowful_world.items.GlowPotionItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.EntityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlowfulWorld implements ModInitializer {
	public static final String MOD_ID = "glowful_world";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		FabricLoader.getInstance().isModLoaded("coloredglowlib");

		setColorsToMobs();
		GlowPotionItem.registerPotionItems();
	}

	public static void setColorsToMobs(){
		//Ok there are a lot of mobs in minecraft
		ColoredGlowLib.setColorToEntityType(EntityType.AXOLOTL, new Color(243, 78, 237));
		ColoredGlowLib.setColorToEntityType(EntityType.BAT, new Color(59, 48, 59));
		ColoredGlowLib.setColorToEntityType(EntityType.SHEEP, new Color(196, 218, 227));
		ColoredGlowLib.setColorToEntityType(EntityType.COW, new Color(111, 47, 4));
		ColoredGlowLib.setColorToEntityType(EntityType.CREEPER, new Color(49, 130, 49));
		ColoredGlowLib.setColorToEntityType(EntityType.SLIME, new Color(23, 205, 23));
		ColoredGlowLib.setColorToEntityType(EntityType.CHICKEN, new Color(239, 229, 41));
		ColoredGlowLib.setColorToEntityType(EntityType.ZOMBIE, new Color(2, 144, 78));
		ColoredGlowLib.setColorToEntityType(EntityType.ZOMBIE_VILLAGER, new Color(16, 88, 39));
		ColoredGlowLib.setColorToEntityType(EntityType.CAVE_SPIDER, new Color(68, 64, 116));
		ColoredGlowLib.setColorToEntityType(EntityType.VILLAGER, new Color(226, 83, 55));
		ColoredGlowLib.setColorToEntityType(EntityType.EVOKER, new Color(144, 35, 212));
		ColoredGlowLib.setColorToEntityType(EntityType.PIG, new Color(253, 92, 226));
		ColoredGlowLib.setColorToEntityType(EntityType.COD, new Color(91, 147, 252));

		ColoredGlowLib.setColorToEntityType(EntityType.ARMOR_STAND, new Color(95, 90, 82));
		ColoredGlowLib.setColorToEntityType(EntityType.ARROW, new Color(72, 82, 44));
		ColoredGlowLib.setColorToEntityType(EntityType.BEE, new Color(238, 219, 15));
		ColoredGlowLib.setColorToEntityType(EntityType.BLAZE, new Color(196, 26, 26));
		ColoredGlowLib.setColorToEntityType(EntityType.CAT, new Color(158, 243, 231));
		//ColoredGlowLib.setColorToEntityType(EntityType.CHEST_MINECART, new Color(gray));
		ColoredGlowLib.setColorToEntityType(EntityType.DOLPHIN, new Color(45, 201, 180));
		ColoredGlowLib.setColorToEntityType(EntityType.DONKEY, new Color(219, 191, 141));
		ColoredGlowLib.setColorToEntityType(EntityType.DROWNED, new Color(18, 201, 162));
		//ColoredGlowLib.setColorToEntityType(EntityType.EGG, new Color()); Would this work? And make sense?
		ColoredGlowLib.setColorToEntityType(EntityType.ELDER_GUARDIAN, new Color(0, 101, 79));
		ColoredGlowLib.setColorToEntityType(EntityType.ENDER_DRAGON, new Color(77, 0, 102));
		ColoredGlowLib.setColorToEntityType(EntityType.ENDERMAN, new Color(93, 28, 114));
		ColoredGlowLib.setColorToEntityType(EntityType.ENDERMITE, new Color(135, 41, 167));
		ColoredGlowLib.setColorToEntityType(EntityType.FOX, new Color(237, 162, 5));
		ColoredGlowLib.setColorToEntityType(EntityType.GHAST, new Color(111, 92, 88));
		ColoredGlowLib.setColorToEntityType(EntityType.GIANT, new Color(16, 88, 39));
		ColoredGlowLib.setColorToEntityType(EntityType.GOAT, new Color(138, 141, 170));
		ColoredGlowLib.setColorToEntityType(EntityType.GUARDIAN, new Color(37, 47, 141));
		ColoredGlowLib.setColorToEntityType(EntityType.HOGLIN, new Color(222, 162, 199));
		ColoredGlowLib.setColorToEntityType(EntityType.HORSE, new Color(243, 190, 111));
		ColoredGlowLib.setColorToEntityType(EntityType.HUSK, new Color(236, 219, 134));
		ColoredGlowLib.setColorToEntityType(EntityType.IRON_GOLEM, new Color(167, 165, 156));
		ColoredGlowLib.setColorToEntityType(EntityType.LLAMA, new Color(229, 166, 95));
		ColoredGlowLib.setColorToEntityType(EntityType.MAGMA_CUBE, new Color(224, 84, 33));
		ColoredGlowLib.setColorToEntityType(EntityType.MOOSHROOM, new Color(198, 37, 12));
		ColoredGlowLib.setColorToEntityType(EntityType.MULE, new Color(79, 62, 34));
		ColoredGlowLib.setColorToEntityType(EntityType.OCELOT, new Color(124, 199, 12));
		ColoredGlowLib.setColorToEntityType(EntityType.PANDA, new Color(200, 248, 88));
		ColoredGlowLib.setColorToEntityType(EntityType.PHANTOM, new Color(35, 81, 125));
		ColoredGlowLib.setColorToEntityType(EntityType.PIGLIN, new Color(234, 199, 21));
		ColoredGlowLib.setColorToEntityType(EntityType.PIGLIN_BRUTE, new Color(193, 167, 40));
		ColoredGlowLib.setColorToEntityType(EntityType.PILLAGER, new Color(163, 87, 16));
		ColoredGlowLib.setColorToEntityType(EntityType.POLAR_BEAR, new Color(83, 173, 208));
		ColoredGlowLib.setColorToEntityType(EntityType.PUFFERFISH, new Color(255, 235, 135));
		ColoredGlowLib.setColorToEntityType(EntityType.RABBIT, new Color(255, 198, 76));
		ColoredGlowLib.setColorToEntityType(EntityType.RAVAGER, new Color(62, 55, 39));
		ColoredGlowLib.setColorToEntityType(EntityType.SALMON, new Color(208, 98, 39));
		ColoredGlowLib.setColorToEntityType(EntityType.SHULKER, new Color(157, 70, 186));
		ColoredGlowLib.setColorToEntityType(EntityType.SILVERFISH, new Color(141, 129, 146));
		ColoredGlowLib.setColorToEntityType(EntityType.SKELETON, new Color(189, 177, 177));
		ColoredGlowLib.setColorToEntityType(EntityType.SKELETON_HORSE, new Color(189, 177, 177));
		ColoredGlowLib.setColorToEntityType(EntityType.SNOW_GOLEM, new Color(201, 255, 243));
		ColoredGlowLib.setColorToEntityType(EntityType.SPIDER, new Color(66, 71, 70));
		ColoredGlowLib.setColorToEntityType(EntityType.SQUID, new Color(59, 94, 87));
		ColoredGlowLib.setColorToEntityType(EntityType.STRAY, new Color(106, 158, 147));
		ColoredGlowLib.setColorToEntityType(EntityType.STRIDER, new Color(255, 119, 0));
		ColoredGlowLib.setColorToEntityType(EntityType.TRADER_LLAMA, new Color(156, 90, 32));
		ColoredGlowLib.setColorToEntityType(EntityType.TURTLE, new Color(41, 234, 57));
		ColoredGlowLib.setColorToEntityType(EntityType.VEX, new Color(0, 199, 183));
		//the trader is this color only beacuse it's called "laser lemon" and heheh funni
		ColoredGlowLib.setColorToEntityType(EntityType.WANDERING_TRADER, new Color(250, 255, 104));
		ColoredGlowLib.setColorToEntityType(EntityType.VINDICATOR, new Color(152, 153, 131));
		ColoredGlowLib.setColorToEntityType(EntityType.WITCH, new Color(230, 0, 255));
		ColoredGlowLib.setColorToEntityType(EntityType.WITHER, new Color(0,0, 0));
		ColoredGlowLib.setColorToEntityType(EntityType.WITHER_SKELETON, new Color(29, 27, 29));
		ColoredGlowLib.setColorToEntityType(EntityType.WOLF, new Color(136, 157, 167));
		ColoredGlowLib.setColorToEntityType(EntityType.ZOGLIN, new Color(149, 180, 142));
		ColoredGlowLib.setColorToEntityType(EntityType.ZOMBIFIED_PIGLIN, new Color(103, 139, 102));


        //Rainbows
        ColoredGlowLib.setRainbowColorToEntityType(EntityType.TROPICAL_FISH, true);
        ColoredGlowLib.setRainbowColorToEntityType(EntityType.ILLUSIONER, true);
        ColoredGlowLib.setRainbowColorToEntityType(EntityType.PARROT, true);
        ColoredGlowLib.setRainbowColorToEntityType(EntityType.GLOW_SQUID, true);
        ColoredGlowLib.setRainbowColorToEntityType(EntityType.GLOW_ITEM_FRAME, true);
        ColoredGlowLib.setRainbowColorToEntityType(EntityType.COMMAND_BLOCK_MINECART, true);

		//TODO add configable colors
		//TODO add glowing potion
		//TODO add shulkers that do glowing effect & chance for starys to use spectral arrows?


	}
}
