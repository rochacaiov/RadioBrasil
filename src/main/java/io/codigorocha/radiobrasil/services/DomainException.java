package io.codigorocha.radiobrasil.services;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;

public class DomainException extends Exception {
    public DomainException() {
        super();
    }

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, TextChannel textChannel) {
        super(message);
        EmbedBuilder embed = new EmbedBuilder()
                .setColor(Color.ORANGE)
                .setDescription(":x:┇ " + message);
        textChannel.sendMessage(embed.build()).queue();
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
