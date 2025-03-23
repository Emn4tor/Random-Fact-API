package de.emn4tor.security;

/*
 *  @author: Emn4tor
 *  @created: 23.03.2025
 */

import de.emn4tor.managers.database.DatabaseBridge;

import java.security.SecureRandom;
import java.util.Base64;

public class ApiKeyGenerator {

    private static final String PREFIX = "e4_";

    public static String generateApiKey(Integer userID, Integer maxUsage) {
        SecureRandom secureRandom = new SecureRandom();

        byte[] apiKeyBytes = new byte[32];
        secureRandom.nextBytes(apiKeyBytes);

        String finalKey = PREFIX + Base64.getUrlEncoder().withoutPadding().encodeToString(apiKeyBytes);

        new DatabaseBridge().newAPIKey(finalKey, userID, maxUsage);

        return finalKey;
    }
}