package de.emn4tor.security;

/*
 *  @author: Emn4tor
 *  @created: 23.03.2025
 */

import java.security.SecureRandom;
import java.util.Base64;

public class ApiKeyGenerator {

    public static String generateApiKey() {
        SecureRandom secureRandom = new SecureRandom();

        byte[] apiKeyBytes = new byte[32];
        secureRandom.nextBytes(apiKeyBytes);

        return Base64.getUrlEncoder().withoutPadding().encodeToString(apiKeyBytes);
    }

}