package io.codigorocha.radiobrasil.services.chat.events.listeners;

import io.codigorocha.radiobrasil.Main;
import io.codigorocha.radiobrasil.commands.CommandManager;
import io.codigorocha.radiobrasil.utils.Command;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class OnMessageReceivedListener extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String raw = event.getMessage().getContentRaw();

        if (raw.startsWith("~")) {
            String command = Command.getCommandFromRaw(raw);
            String[] args = Command.getArgsFromRaw(raw);

            if (event.getAuthor().isBot() || event.getMessage().isWebhookMessage()) {
                //throw domain
                return;
            }

            if (!CommandManager.exists(command)) {
                //throw new DomainException();
                return;
            }

            boolean commandResponse = Main.getChatService().handleCommand(command, args, event);

            if (!commandResponse) {
                // throw domain with help
                return;
            }
            //chatService.handleCommand(command, args, event);
        }
    }
}
