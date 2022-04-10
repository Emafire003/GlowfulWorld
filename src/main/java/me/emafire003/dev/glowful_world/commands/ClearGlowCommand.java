package me.emafire003.dev.glowful_world.commands;

import com.google.common.collect.ImmutableList;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import me.emafire003.dev.coloredglowlib.ColoredGlowLib;
import me.emafire003.dev.coloredglowlib.util.Color;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;

import java.util.Collection;
import java.util.Iterator;

import static me.emafire003.dev.coloredglowlib.ColoredGlowLib.updateData;

public class ClearGlowCommand {


    @SuppressWarnings("all")
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean b) {
        dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)CommandManager.literal("clearglow").requires((source) -> {
            return source.hasPermissionLevel(2);
        })).executes((context) -> {
            return execute((ServerCommandSource)context.getSource(), ImmutableList.of(((ServerCommandSource)context.getSource()).getEntityOrThrow()));
        })).then(CommandManager.argument("targets", EntityArgumentType.entities()).executes((context) -> {
            return execute((ServerCommandSource)context.getSource(), EntityArgumentType.getEntities(context, "targets"));
        })));
    }

    private static int execute(ServerCommandSource source, Collection<? extends Entity> targets) {

        for (Entity entity : targets){
            entity.setGlowing(false);
        }
        source.sendFeedback(new LiteralText("Cleared glow!"), true);
        
        return targets.size();
    }

}
