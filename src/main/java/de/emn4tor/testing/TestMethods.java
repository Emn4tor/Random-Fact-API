package de.emn4tor.testing;

/*
 *  @author: Emn4tor
 *  @created: 23.03.2025
 */

import static de.emn4tor.security.ApiKeyGenerator.generateApiKey;

public class TestMethods {

    public void newUser(String username, String password) {
        System.out.println("TestMethods newUser");
    }

    public void deleteUser(String username) {
        System.out.println("TestMethods deleteUser");
    }

    public void NewAPIKey() {
        String apiKey = generateApiKey();
        System.out.println(apiKey);

    }


}
