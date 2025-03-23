package de.emn4tor.controller;

/*
 *  @author: Emn4tor
 *  @created: 23.03.2025
 */

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import de.emn4tor.security.ApiKeyChecker;


@RestController
public class FactController {

    @GetMapping("/api/fact")
    public ResponseEntity<Object> home(
            @RequestHeader(value = "Authorization", required = false) String authHeader,
            @RequestParam(value = "key", required = false) String apiKey,  // Accept API key as a query parameter
            @RequestParam(value = "type", required = false) String type
    ) {
        System.out.println("Received Header: " + authHeader);
        System.out.println("Received Query Key: " + apiKey);
        System.out.println("Received Type: " + type);

        ErrorResponse errorResponse = new ErrorResponse();

        // Use either header or query parameter for API key
        if (authHeader == null && apiKey == null) {
            errorResponse.setMessage("This service requires an API key! Get yours on idkyet.com");
            errorResponse.setCode("API_KEY_MISSING");
            errorResponse.setTimestamp(System.currentTimeMillis());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponse);
        }

        // Determine which key to validate
        String keyToValidate = authHeader != null ? authHeader : apiKey;

        if (ApiKeyChecker.isValid(keyToValidate)) {
            return ResponseEntity.ok("{\"fact\": \"This is a " + (type != null ? type : "random") + " fact\"}");
        } else {
            errorResponse.setMessage("Invalid API Key");
            errorResponse.setCode("API_KEY_INVALID");
            errorResponse.setTimestamp(System.currentTimeMillis());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponse);
        }
    }

    // Error response class
    public static class ErrorResponse {
        private String message;
        private String code;
        private long timestamp;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }
    }
}