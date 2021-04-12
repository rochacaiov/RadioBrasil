package io.codigorocha.radiobrasil.commands;

import java.util.HashMap;
import java.util.Map;

public final class CommandManager {
    private static final Map<String, Command> commands = new HashMap<>();

    public static void add(Command command) {
        if (!commands.containsKey(command.getName())) commands.put(command.getName(), command);
    }

    public synchronized static Command get(String command) {
        return commands.get(command);
    }

    public synchronized static Map<String, Command> getAll() {
        return commands;
    }

    public static boolean exists(String name) {
        return commands.containsKey(name);
    }
}
