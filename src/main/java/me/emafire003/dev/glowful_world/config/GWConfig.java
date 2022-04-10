package me.emafire003.dev.glowful_world.config;

import com.mojang.datafixers.util.Pair;

import static me.emafire003.dev.glowful_world.GlowfulWorld.LOGGER;
import static me.emafire003.dev.glowful_world.GlowfulWorld.MOD_ID;

public class GWConfig {
    public static SimpleConfig CONFIG;
    private static GWConfigProvider configs;

    public static boolean GLOW_POT;
    public static boolean SHULKER_GLOW;
    public static boolean ALL_GLOW;

    public static void registerConfigs() {
        configs = new GWConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(MOD_ID + "_config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("enable_glow_potion", true), "If true there will be an item for the glowing potion effect. Will need a restart.");
        configs.addKeyValuePair(new Pair<>("enable_shulker_bullet_glow", true), "If true a shulker bullet will also set you glowing");
        configs.addKeyValuePair(new Pair<>("all_entities_glow", false), "If true every entity will perpetually glow. Will need a restart.");

    }

    private static void assignConfigs() {
        GLOW_POT = CONFIG.getOrDefault("enable_glow_potion", true);
        SHULKER_GLOW = CONFIG.getOrDefault("enable_shulker_bullet_glow", true);
        ALL_GLOW = CONFIG.getOrDefault("all_entities_glow", false);

        LOGGER.info("All " + configs.getConfigsList().size() + " have been set properly");
    }
}

