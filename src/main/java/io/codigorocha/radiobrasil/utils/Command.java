package io.codigorocha.radiobrasil.utils;

import java.util.ArrayList;
import java.util.Arrays;

public final class Command {

    public static String getCommandFromRaw(String contentRaw) {
        return Arrays.asList(contentRaw.split(" ")).get(0).replace("~", "");
    }

    public static String[] getArgsFromRaw(String contentRaw) {
        ArrayList<String> args = new ArrayList<>(Arrays.asList(contentRaw.split(" ")));
        args.remove(0);
        return args.toArray(new String[0]);
    }
}
