package de.emn4tor.managers.database;

/*
 *  @author: Emn4tor
 *  @created: 23.03.2025
 */

import de.emn4tor.managers.ConfigManager;

import java.sql.*;


public class SQliteManager {
    String databaseName = "datanase";

    private ConfigManager configManager = new ConfigManager();

    public void init() {
        System.out.println("SQliteManager initialized");
        createAPIandUserTables();



    }

    // API & Users

    private void createAPIandUserTables() {
        String url = "jdbc:sqlite:" + databaseName + ".db";
        String sql = "CREATE TABLE IF NOT EXISTS api_keys (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	api_key text NOT NULL\n"
                + "user_id integer NOT NULL\n"
                + "usage integer NOT NULL\n"
                + "max_usage integer NOT NULL\n"
                + ");";

    }

    public void newAPIKey(String apiKey, int userId, int maxUsage) {
        String databaseName = configManager.getConfigEntry("database.database", "database");
        String url = "jdbc:sqlite:" + databaseName + ".db";
        String sql = "INSERT INTO api_keys(api_key, user_id, usage, max_usage) VALUES(?,?,?,?)";
    }

    public boolean isAPIKeyValidandUsable(String apiKey) {
        String databaseName = configManager.getConfigEntry("database.database", "database");
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
}
