package me.emafire003.dev.glowful_world.commands;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

import static me.emafire003.dev.coloredglowlib.ColoredGlowLib.LOGGER;

public class GWCommandRegister {
    public static void registerCommands() {
        LOGGER.info("Registering commands...");
        CommandRegistrationCallback.EVENT.register(UpdateGWConfigsCommand::register);
        LOGGER.info("Done!");
    }
}
