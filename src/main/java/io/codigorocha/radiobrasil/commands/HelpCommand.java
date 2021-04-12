package io.codigorocha.radiobrasil.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.time.Instant;
import java.util.stream.Collectors;

public class HelpCommand implements Command {
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Lista todos os comandos";
    }

    @Override
    public boolean doCommand(String[] args, GuildMessageReceivedEvent e) {
        String commands = CommandManager.getAll().entrySet().stream()
                .filter(entry -> !entry.getValue().getName().equals("help"))
                .map(entry -> "`~" + entry.getKey() + "`" + " • " + entry.getValue().getDescription())
                .collect(Collectors.joining("\n"));
        EmbedBuilder embed = new EmbedBuilder()
                .setAuthor("┇  @Rádio Brasil", "https://discord.gg/rFhGcUZ", "https://imgur.com/FRg7cKo.gif")
                .setThumbnail("https://imgur.com/8EDvw08.png")
                .addField("\nLista de Comandos\n", commands, false)
                .setFooter("io.codigorocha")
                .setTimestamp(Instant.now())
                .setColor(Color.YELLOW);
        e.getChannel().sendMessage(embed.build()).queue();
        return false;
    }
}
