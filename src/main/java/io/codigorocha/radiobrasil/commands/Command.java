package io.codigorocha.radiobrasil.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public interface Command {

    String getName();

    String getDescription();

    boolean doCommand(String[] args, GuildMessageReceivedEvent e);
}
