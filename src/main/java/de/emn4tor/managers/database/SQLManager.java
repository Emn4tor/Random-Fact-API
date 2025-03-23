package de.emn4tor.managers.database;

/*
 *  @author: Emn4tor
 *  @created: 23.03.2025
 */

public class SQLManager {
    public void init() {
        System.out.println("SQLManager initialized");
    }

    public void newAPIKey(String apiKey, int userId, int maxUsage) {
        System.out.println("SQLManager newAPIKey");
    }

    public boolean isAPIKeyValidandUsable(String apiKey) {
        System.out.println("SQLManager isAPIKeyValidandUsable");
        return true;
    }

    public void editUsage(String apiKey, int usage, String type) {
        System.out.println("SQLManager editUsage");
    }
}
