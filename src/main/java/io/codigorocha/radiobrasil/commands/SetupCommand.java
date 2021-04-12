package io.codigorocha.radiobrasil.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class SetupCommand implements Command{
    @Override
    public String getName() {
        return "setup";
    }

    @Override
    public String getDescription() {
        return "Cria um canal para solicitar músicas";
    }

    @Override
    public boolean doCommand(String[] args, GuildMessageReceivedEvent e) {


        return false;
    }
}
