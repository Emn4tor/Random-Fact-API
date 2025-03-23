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

    Integer noAccount = 10;
    Integer standard = 1000;
    Integer Premium = 1000000;
    Integer Eneterprise = 1000000000;


    public void NewAPIKey(Integer userID, Integer maxUsage) {
        String apiKey = generateApiKey(userID, maxUsage);
        System.out.println(apiKey);

    }


}
