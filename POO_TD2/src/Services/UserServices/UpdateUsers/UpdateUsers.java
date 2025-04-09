package Services.UserServices.UpdateUsers;

import Models.UsersModel;
import Services.DatabaseServices.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateUsers {
    Connection connection;
    UsersModel user;
    PreparedStatement pst;
    ResultSet rsl;
    String sql;

    public UpdateUsers(UsersModel user){
        this.user=user;
        connection = DatabaseConnection.getInstance().getConnection();
    }


    public boolean updateUser(){
        String requete="UPDATE Users SET nom=?,prenom=?,email=?,numtel=?,address=? WHERE id_user=?";
        try(PreparedStatement stmt=connection.prepareStatement(requete)){
            stmt.setInt(6,user.getId());
            stmt.setString(1,user.getNom());
            stmt.setString(2,user.getPrenom());
            stmt.setString(3,user.getEmail());
            stmt.setString(4,user.getNumtel());
            stmt.setString(5,user.getAddress());
            stmt.executeUpdate();
            return  true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
