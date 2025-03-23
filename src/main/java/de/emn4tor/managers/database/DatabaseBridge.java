package de.emn4tor.managers.database;

/*
 *  @author: Emn4tor
 *  @created: 23.03.2025
 */

import de.emn4tor.managers.ConfigManager;


public class DatabaseBridge {

    public static void initialize() {
        ConfigManager configManager = new ConfigManager();
        String databaseType = configManager.getConfigEntry("database.type", "sqlite");

        if (databaseType.equalsIgnoreCase("sqlite")) {
            new SQliteManager().init();
        } else {
            new SQLManager().init();
        }
    }


    public void newAPIKey(String apiKey, int userId, int maxUsage) {
        ConfigManager configManager = new ConfigManager();
        String databaseType = configManager.getConfigEntry("database.type", "sqlite");

        if (databaseType.equalsIgnoreCase("sqlite")) {
            new SQliteManager().newAPIKey(apiKey, userId, maxUsage);
        } else {
            new SQLManager().newAPIKey(apiKey, userId, maxUsage);
        }
    }

    public boolean isAPIKeyValidandUsable(String apiKey) {
        ConfigManager configManager = new ConfigManager();
        String databaseType = configManager.getConfigEntry("database.type", "sqlite");

        if (databaseType.equalsIgnoreCase("sqlite")) {
            return new SQliteManager().isAPIKeyValidandUsable(apiKey);
        } else {
            return new SQLManager().isAPIKeyValidandUsable(apiKey);
        }

    }
}