package org.openweathermap.helpers;
import com.google.common.base.Strings;
import lombok.SneakyThrows;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PropertyLoader {
    private static final String PROPERTIES_FILE = "/application.properties";
    private static final Properties PROFILE_PROPERTIES = getProfilePropertiesInstance();
    private static final Properties PROPERTIES = getPropertiesInstance();


    public static String loadProperty(String propertyName) {
        String value = tryLoadProperty(propertyName);
        if (null == value) {
            throw new IllegalArgumentException("В файле application.properties не найдено значение по ключу: " + propertyName);
        }
        return value;
    }

    public static String tryLoadProperty(String propertyName) {
        String value = null;
        if (!Strings.isNullOrEmpty(propertyName)) {
            String systemProperty = loadSystemPropertyOrDefault(propertyName, propertyName);
            if (!propertyName.equals(systemProperty)) return systemProperty;
            value = PROFILE_PROPERTIES.getProperty(propertyName);
            if (null == value) {
                value = PROPERTIES.getProperty(propertyName);
            }
        }
        return value;
    }

    public static String loadSystemPropertyOrDefault(String propertyName, String defaultValue) {
        String propValue = System.getProperty(propertyName);
        return propValue != null ? propValue : defaultValue;
    }

    @SneakyThrows(IOException.class)
    private static Properties getProfilePropertiesInstance() {
        Properties instance = new Properties();
        String profile = System.getProperty("profile", "");
        if (!Strings.isNullOrEmpty(profile)) {
            String path = Paths.get(profile).toString();
            URL url = PropertyLoader.class.getClassLoader().getResource(path);
            try (
                    InputStream resourceStream = Objects.requireNonNull(url).openStream();
                    InputStreamReader inputStream = new InputStreamReader(resourceStream, UTF_8)
            ) {
                instance.load(inputStream);
            }
        }
        return instance;
    }

    @SneakyThrows(IOException.class)
    private static Properties getPropertiesInstance() {
        Properties instance = new Properties();
        try (
                InputStream resourceStream = PropertyLoader.class.getResourceAsStream(PROPERTIES_FILE);
                InputStreamReader inputStream =
                        new InputStreamReader(Objects.requireNonNull(resourceStream), UTF_8)
        ) {
            instance.load(inputStream);
        }
        return instance;
    }
}
