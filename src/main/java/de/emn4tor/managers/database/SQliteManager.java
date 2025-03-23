package de.emn4tor.managers.database;

/*
 *  @author: Emn4tor
 *  @created: 23.03.2025
 */

import de.emn4tor.managers.ConfigManager;

import java.sql.*;


public class SQliteManager {
    private ConfigManager configManager = new ConfigManager();

    String databaseName = configManager.getConfigEntry("database.database", "database");


    public void init() {
        System.out.println("SQliteManager initialized");
        createAPIandUserTables();



    }

    // API & Users

    private void createAPIandUserTables() {
        String url = "jdbc:sqlite:" + databaseName + ".db";

        // Correct SQL statement for creating the table
        String sql = "CREATE TABLE IF NOT EXISTS api_keys (\n"
                + "id integer PRIMARY KEY,\n"
                + "api_key text NOT NULL,\n"  // Comma added here
                + "user_id integer NOT NULL,\n" // Comma added here
                + "usage integer NOT NULL,\n"   // Comma added here
                + "max_usage integer NOT NULL\n"
                + ");";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void newAPIKey(String apiKey, int userId, int maxUsage) {
        String url = "jdbc:sqlite:" + databaseName + ".db";
        String sql = "INSERT INTO api_keys(user_id, api_key, usage, max_usage) VALUES(?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.setString(2, apiKey);
            statement.setInt(3, 0);
            statement.setInt(4, maxUsage);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isAPIKeyValidandUsable(String apiKey) {
        String url = "jdbc:sqlite:" + databaseName + ".db";
        String sql = "SELECT usage, max_usage FROM api_keys WHERE api_key = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, apiKey);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int usage = resultSet.getInt("usage");
                int maxUsage = resultSet.getInt("max_usage");

                return usage < maxUsage;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public void editUsage(String apiKey, int usage, String type) {
        String url = "jdbc:sqlite:" + databaseName + ".db";
        String sql = "UPDATE api_keys SET usage = ? WHERE api_key = ?";

        if (type.equalsIgnoreCase("add")) {
            sql = "UPDATE api_keys SET usage = usage - ? WHERE api_key = ?";
        } else if (type.equalsIgnoreCase("remove")) {
            sql = "UPDATE api_keys SET usage = usage + ? WHERE api_key = ?";
        } else if (type.equalsIgnoreCase("set")) {
            sql = "UPDATE api_keys SET usage = ? WHERE api_key = ?";
        }

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, usage);
            statement.setString(2, apiKey);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
