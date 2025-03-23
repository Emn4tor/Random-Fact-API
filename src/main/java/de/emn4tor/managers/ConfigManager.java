package de.emn4tor.managers;

/*
 *  @author: Emn4tor
 *  @created: 23.03.2025
 */

import de.emn4tor.managers.database.DatabaseBridge;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


public class ConfigManager {

    public String getConfigEntry(String key, String defaultValue) {

        Yaml yaml = new Yaml();
        InputStream inputStream = null;

        try {
            inputStream = ConfigManager.class.getClassLoader().getResourceAsStream("configuration.yml");

            if (inputStream == null) {
                return defaultValue;
            }

            Map<String, Object> data = yaml.load(inputStream);
            if (data == null) {
                return defaultValue;
            }

            Map<String, Object> database = (Map<String, Object>) data.get("database");
            if (database == null) {
                return defaultValue;
            }

            String type = (String) database.getOrDefault("type", defaultValue);
            return type;

        } catch (Exception e) {
            return defaultValue;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                }
            } else {
            }
        }
    }
}