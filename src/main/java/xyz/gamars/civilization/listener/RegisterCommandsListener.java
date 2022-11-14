package xyz.gamars.civilization.listener;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.capabilities.CivCapabilities;

@Mod.EventBusSubscriber(modid = Civilization.MOD_ID)
public class RegisterCommandsListener {

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(literal("civilization")
                .then(literal("set")
                        .then(argument("username", StringArgumentType.word()).then(literal("age")
                                .then(argument("age", IntegerArgumentType.integer())
                                        .executes(ctx -> {
                                            /* command parameters */
                                            String username = StringArgumentType.getString(ctx, "username");
                                            int wantedAge = IntegerArgumentType.getInteger(ctx, "age");

                                            /* players */
                                            ServerPlayer commandSender = ctx.getSource().getPlayer();
                                            ServerPlayer player = null;

                                            /* loops through players to find the player of said username*/
                                            for (ServerPlayer serverPlayer : ctx.getSource().getServer().getPlayerList().getPlayers()) {
                                                if (serverPlayer.getDisplayName().getString().equals(username)) {
                                                    player = serverPlayer;
                                                }
                                            }

                                            /* checks if the player exists*/
                                            if (player != null) {
                                                /* set the age of the wanted player */
                                                ServerPlayer finalPlayer = player;
                                                player.getCapability(CivCapabilities.AGE).ifPresent(temp -> {
                                                    temp.setAge(wantedAge, finalPlayer);
                                                });
                                                ctx.getSource().sendSuccess(Component.literal("Successfully set " + username + "'s age to " + wantedAge), true);
                                            } else {
                                                if (commandSender != null) {
                                                    /* player does not exist let the user know */
                                                    ctx.getSource().sendFailure(Component.literal("That player is not currently online"));
                                                }
                                            }
                                            return 0;
                                        })))))
                );

    }

    public static LiteralArgumentBuilder<CommandSourceStack> literal(String pName) {
        return LiteralArgumentBuilder.literal(pName);
    }

    public static <T> RequiredArgumentBuilder<CommandSourceStack, T> argument(String pName, ArgumentType<T> pType) {
        return RequiredArgumentBuilder.argument(pName, pType);
    }

}
