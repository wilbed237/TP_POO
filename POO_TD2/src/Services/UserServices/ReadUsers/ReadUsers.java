package Services.UserServices.ReadUsers;


import Models.UsersModel;
import Services.DatabaseServices.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadUsers {
    Connection connection;
    PreparedStatement pst;
    ResultSet rsl;
    String sql;

    public ReadUsers() {
        connection = DatabaseConnection.getInstance().getConnection();
    }


    public ResultSet read(Integer id) throws Exception {

        try {
            sql = "SELECT * FROM Users WHERE id_user = ?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rsl = pst.executeQuery();

            return rsl;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Erreur lors de la lecture des users: " + e.getMessage());
        }


    }
}