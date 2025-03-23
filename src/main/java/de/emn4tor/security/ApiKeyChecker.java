package de.emn4tor.security;

/*
 *  @author: Emn4tor
 *  @created: 23.03.2025
 */

import de.emn4tor.managers.database.DatabaseBridge;

public class ApiKeyChecker {

    public static boolean isValid(String apiKey) {
        if (apiKey == null) {
            return false;
        }
        else {
            return new DatabaseBridge().isAPIKeyValidandUsable(apiKey);
        }
    }
}
