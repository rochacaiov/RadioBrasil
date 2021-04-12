package io.codigorocha.radiobrasil;

import io.codigorocha.radiobrasil.commands.CommandManager;
import io.codigorocha.radiobrasil.commands.HelpCommand;
import io.codigorocha.radiobrasil.commands.SetupCommand;
import io.codigorocha.radiobrasil.services.ChatService;
import io.codigorocha.radiobrasil.services.DomainException;
import io.codigorocha.radiobrasil.services.chat.ChatImpl;
import io.codigorocha.radiobrasil.services.chat.events.listeners.OnMessageReceivedListener;
import io.codigorocha.radiobrasil.utils.Configuration;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.util.Properties;

public class Main {
    private static final ChatService chatService = new ChatImpl();

    public static void main(String[] args) {
        CommandManager.add(new HelpCommand());
        CommandManager.add(new SetupCommand());

        try {
            Properties bot = Configuration.getProperties("bot");
            JDA jda = JDABuilder.createDefault(bot.getProperty("bot.token"))
                    .setActivity(Activity.listening("@" + bot.getProperty("bot.activity")))
                    .addEventListeners(new OnMessageReceivedListener())
                    .build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public static ChatService getChatService() {
        return chatService;
    }
}
