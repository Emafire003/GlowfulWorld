package me.emafire003.dev.glowful_world;

import me.emafire003.dev.coloredglowlib.ColoredGlowLib;
import me.emafire003.dev.coloredglowlib.util.Color;
import me.emafire003.dev.glowful_world.commands.GWCommandRegister;
import me.emafire003.dev.glowful_world.config.DataSaver;
import me.emafire003.dev.glowful_world.config.GWConfig;
import me.emafire003.dev.glowful_world.items.GlowPotionItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.EntityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

public class GlowfulWorld implements ModInitializer {
	public static HashMap<String, String> entities_and_colors = new HashMap<>();
	public static HashMap<EntityType, String> entities_colors = new HashMap<>();
	public static final String MOD_ID = "glowful_world";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Path PATH = Path.of(FabricLoader.getInstance().getConfigDir() + "/" + MOD_ID + "/");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		GWConfig.registerConfigs();
		setColorsToMobs();
		entities_and_colors = ColoredGlowLib.convertFromEntityTypeMap(entities_colors);
		DataSaver.createFile();
		try {
			DataSaver.readColorsFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(GWConfig.GLOW_POT){
			GlowPotionItem.registerPotionItems();
		}
		GWCommandRegister.registerCommands();
		if(GWConfig.ALL_GLOW){
			ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
				entity.setGlowing(true);
			});
		}
	}

	public static HashMap<String, String> getMap(){
		return entities_and_colors;
	}

	public static void setColorsToMobs(){
		//Ok there are a lot of mobs in minecraft
		entities_colors.put(EntityType.AXOLOTL, new Color(243, 78, 237).toHEX());
		entities_colors.put(EntityType.BAT, new Color(59, 48, 59).toHEX());
		entities_colors.put(EntityType.SHEEP, new Color(196, 218, 227).toHEX());
		entities_colors.put(EntityType.COW, new Color(111, 47, 4).toHEX());
		entities_colors.put(EntityType.CREEPER, new Color(49, 130, 49).toHEX());
		entities_colors.put(EntityType.SLIME, new Color(23, 205, 23).toHEX());
		entities_colors.put(EntityType.CHICKEN, new Color(239, 229, 41).toHEX());
		entities_colors.put(EntityType.ZOMBIE, new Color(2, 144, 78).toHEX());
		entities_colors.put(EntityType.ZOMBIE_VILLAGER, new Color(16, 88, 39).toHEX());
		entities_colors.put(EntityType.CAVE_SPIDER, new Color(68, 64, 116).toHEX());
		entities_colors.put(EntityType.VILLAGER, new Color(226, 83, 55).toHEX());
		entities_colors.put(EntityType.EVOKER, new Color(144, 35, 212).toHEX());
		entities_colors.put(EntityType.PIG, new Color(253, 92, 226).toHEX());
		entities_colors.put(EntityType.COD, new Color(91, 147, 252).toHEX());

		entities_colors.put(EntityType.ARMOR_STAND, new Color(95, 90, 82).toHEX());
		entities_colors.put(EntityType.ARROW, new Color(72, 82, 44).toHEX());
		entities_colors.put(EntityType.BEE, new Color(238, 219, 15).toHEX());
		entities_colors.put(EntityType.BLAZE, new Color(196, 26, 26).toHEX());
		entities_colors.put(EntityType.CAT, new Color(158, 243, 231).toHEX());
		//entities_colors.put(EntityType.CHEST_MINECART, new Color(gray).toHEX());
		entities_colors.put(EntityType.DOLPHIN, new Color(45, 201, 180).toHEX());
		entities_colors.put(EntityType.DONKEY, new Color(219, 191, 141).toHEX());
		entities_colors.put(EntityType.DROWNED, new Color(18, 201, 162).toHEX());
		//entities_colors.put(EntityType.EGG, new Color().toHEX()); Would this work? And make sense?
		entities_colors.put(EntityType.ELDER_GUARDIAN, new Color(0, 101, 79).toHEX());
		entities_colors.put(EntityType.ENDER_DRAGON, new Color(77, 0, 102).toHEX());
		entities_colors.put(EntityType.ENDERMAN, new Color(93, 28, 114).toHEX());
		entities_colors.put(EntityType.ENDERMITE, new Color(135, 41, 167).toHEX());
		entities_colors.put(EntityType.FOX, new Color(237, 162, 5).toHEX());
		entities_colors.put(EntityType.GHAST, new Color(111, 92, 88).toHEX());
		entities_colors.put(EntityType.GIANT, new Color(16, 88, 39).toHEX());
		entities_colors.put(EntityType.GOAT, new Color(138, 141, 170).toHEX());
		entities_colors.put(EntityType.GUARDIAN, new Color(37, 47, 141).toHEX());
		entities_colors.put(EntityType.HOGLIN, new Color(222, 162, 199).toHEX());
		entities_colors.put(EntityType.HORSE, new Color(243, 190, 111).toHEX());
		entities_colors.put(EntityType.HUSK, new Color(236, 219, 134).toHEX());
		entities_colors.put(EntityType.IRON_GOLEM, new Color(167, 165, 156).toHEX());
		entities_colors.put(EntityType.LLAMA, new Color(229, 166, 95).toHEX());
		entities_colors.put(EntityType.MAGMA_CUBE, new Color(224, 84, 33).toHEX());
		entities_colors.put(EntityType.MOOSHROOM, new Color(198, 37, 12).toHEX());
		entities_colors.put(EntityType.MULE, new Color(79, 62, 34).toHEX());
		entities_colors.put(EntityType.OCELOT, new Color(124, 199, 12).toHEX());
		entities_colors.put(EntityType.PANDA, new Color(200, 248, 88).toHEX());
		entities_colors.put(EntityType.PHANTOM, new Color(35, 81, 125).toHEX());
		entities_colors.put(EntityType.PIGLIN, new Color(234, 199, 21).toHEX());
		entities_colors.put(EntityType.PIGLIN_BRUTE, new Color(193, 167, 40).toHEX());
		entities_colors.put(EntityType.PILLAGER, new Color(163, 87, 16).toHEX());
		entities_colors.put(EntityType.POLAR_BEAR, new Color(83, 173, 208).toHEX());
		entities_colors.put(EntityType.PUFFERFISH, new Color(255, 235, 135).toHEX());
		entities_colors.put(EntityType.RABBIT, new Color(255, 198, 76).toHEX());
		entities_colors.put(EntityType.RAVAGER, new Color(62, 55, 39).toHEX());
		entities_colors.put(EntityType.SALMON, new Color(208, 98, 39).toHEX());
		entities_colors.put(EntityType.SHULKER, new Color(157, 70, 186).toHEX());
		entities_colors.put(EntityType.SILVERFISH, new Color(141, 129, 146).toHEX());
		entities_colors.put(EntityType.SKELETON, new Color(189, 177, 177).toHEX());
		entities_colors.put(EntityType.SKELETON_HORSE, new Color(189, 177, 177).toHEX());
		entities_colors.put(EntityType.SNOW_GOLEM, new Color(201, 255, 243).toHEX());
		entities_colors.put(EntityType.SPIDER, new Color(66, 71, 70).toHEX());
		entities_colors.put(EntityType.SQUID, new Color(59, 94, 87).toHEX());
		entities_colors.put(EntityType.STRAY, new Color(106, 158, 147).toHEX());
		entities_colors.put(EntityType.STRIDER, new Color(255, 119, 0).toHEX());
		entities_colors.put(EntityType.TRADER_LLAMA, new Color(156, 90, 32).toHEX());
		entities_colors.put(EntityType.TURTLE, new Color(41, 234, 57).toHEX());
		entities_colors.put(EntityType.VEX, new Color(0, 199, 183).toHEX());
		//the trader is this color only beacuse it's called "laser lemon" and heheh funni
		entities_colors.put(EntityType.WANDERING_TRADER, new Color(250, 255, 104).toHEX());
		entities_colors.put(EntityType.VINDICATOR, new Color(152, 153, 131).toHEX());
		entities_colors.put(EntityType.WITCH, new Color(230, 0, 255).toHEX());
		entities_colors.put(EntityType.WITHER, new Color(0,0, 0).toHEX());
		entities_colors.put(EntityType.WITHER_SKELETON, new Color(29, 27, 29).toHEX());
		entities_colors.put(EntityType.WOLF, new Color(136, 157, 167).toHEX());
		entities_colors.put(EntityType.ZOGLIN, new Color(149, 180, 142).toHEX());
		entities_colors.put(EntityType.ZOMBIFIED_PIGLIN, new Color(103, 139, 102).toHEX());


        //Rainbows
        entities_colors.put(EntityType.TROPICAL_FISH, "rainbow");
        entities_colors.put(EntityType.ILLUSIONER, "rainbow");
        entities_colors.put(EntityType.PARROT, "rainbow");
        entities_colors.put(EntityType.GLOW_SQUID, "rainbow");
        entities_colors.put(EntityType.GLOW_ITEM_FRAME, "rainbow");
        entities_colors.put(EntityType.COMMAND_BLOCK_MINECART, "rainbow");

		//TODO add configable colors
		//TODO add glowing potion
		//TODO add shulkers that do glowing effect & chance for starys to use spectral arrows?


	}
}
