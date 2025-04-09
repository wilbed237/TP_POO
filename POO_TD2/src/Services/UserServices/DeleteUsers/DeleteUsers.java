package Services.UserServices.DeleteUsers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.UsersModel;
import Services.DatabaseServices.DatabaseConnection;

public class DeleteUsers {

    Connection connection;
    UsersModel user;

//    public DeleteUsers(UsersModel user) {
//        this.user = user;
//        connection = DatabaseConnection.getInstance().getConnection();
//    }

    public static boolean deleteUser(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, id);
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
