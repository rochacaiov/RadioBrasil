package io.codigorocha.radiobrasil.utils;

import io.codigorocha.radiobrasil.Main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Configuration {
    public static Properties getProperties(String property) {
        ClassLoader classLoader = Main.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(property + ".properties");
        Properties properties = new Properties();

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
