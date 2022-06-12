package me.emafire003.dev.glowful_world.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.emafire003.dev.coloredglowlib.ColoredGlowLib;
import me.emafire003.dev.glowful_world.config.DataSaver;
import me.emafire003.dev.glowful_world.config.GWConfig;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import java.io.IOException;

public class UpdateGWConfigsCommand {
    @SuppressWarnings("all")
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder) CommandManager.literal("updategwconfigs").requires((source) -> {
            return source.hasPermissionLevel(2);
        })).executes((context) -> {
            ServerCommandSource serverCommandSource = (ServerCommandSource)context.getSource();
            MinecraftServer minecraftServer = serverCommandSource.getServer();

            try {
                GWConfig.registerConfigs();
                DataSaver.createFile();
                DataSaver.readColorsFile();
                ColoredGlowLib.updateData(minecraftServer);
                serverCommandSource.sendFeedback(Text.literal("Updated to new colors from the config file!"), false);
            } catch (IOException e) {
                e.printStackTrace();
                serverCommandSource.sendError(Text.literal("Something went wrong with updating to new colors. Check the file and the log for possible errors."));
            }

            return 0;
        }));
    }
}