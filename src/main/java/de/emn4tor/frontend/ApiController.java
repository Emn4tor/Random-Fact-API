package de.emn4tor.frontend;

/*
 *  @author: Emn4tor
 *  @created: 23.03.2025
 */


import org.springframework.web.bind.annotation.*;

import static de.emn4tor.security.ApiKeyGenerator.generateApiKey;


@RestController
public class ApiController {

    @RequestMapping("/apii")
    public String genQuickAPIKey() {
        Integer userID = 1;
        Integer maxUsage = 10;
        String apiKey = generateApiKey(userID, maxUsage);
        return "{\"apiKey\":\"" + apiKey + "\"}";
    }
}