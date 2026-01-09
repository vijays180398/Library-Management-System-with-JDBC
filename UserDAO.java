import java.sql.*;

public class UserDAO {

    public void addUser(String name, String email) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.executeUpdate();

            System.out.println("User added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
