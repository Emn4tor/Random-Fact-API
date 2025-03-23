package de.emn4tor.security;

/*
 *  @author: Emn4tor
 *  @created: 23.03.2025
 */

public class ApiKeyChecker {

    public static boolean isValid(String apiKey) {
        if (apiKey == null) {
            return false;
        }
        else if (apiKey.equals("123456")) {
            return true;
        }
        else {
            return false;
        }
    }
}
