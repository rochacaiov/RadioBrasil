package io.codigorocha.radiobrasil.services;

import io.codigorocha.radiobrasil.commands.CommandManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public interface ChatService {

    // createChannel();

    void sendResponse();

    default boolean handleCommand(String command, String[] args, GuildMessageReceivedEvent e) {
        e.getChannel().sendTyping().queue();
        return CommandManager.get(command).doCommand(args, e);
    }
}
