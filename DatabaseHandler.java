import java.sql.*;

public class DatabaseHandler {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/webpaydb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String DB_USER = "root"; // Replace with your MySQL username
    private static final String DB_PASSWORD = "abhi"; // Replace with your MySQL password

    public Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }


    public boolean registerUser(String username, String email, String password) {
        String checkEmailSql = "SELECT COUNT(*) FROM users WHERE email = ?";
        String insertSql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement checkStmt = conn.prepareStatement(checkEmailSql);
             PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {

            // Check if email already exists
            checkStmt.setString(1, email);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("DEBUG: Email already exists in the database.");
                return false; // Email already exists
            }

            // Insert new user
            insertStmt.setString(1, username);
            insertStmt.setString(2, email);
            insertStmt.setString(3, password);

            int rowsInserted = insertStmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("DEBUG: Registration successful for " + email);
                return true;
            } else {
                System.out.println("DEBUG: Registration failed.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean loginUser(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Returns true if a match is found
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
