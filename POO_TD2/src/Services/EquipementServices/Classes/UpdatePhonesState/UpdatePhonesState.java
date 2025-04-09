package Services.EquipementServices.Classes.UpdatePhonesState;

import Models.MaterielsModel;
import Models.PhonesModel;
import Models.UsersModel;
import Services.DatabaseServices.DatabaseConnection;
import Services.EquipementServices.Interfaces.UpdateStateInterface.UpdateStateInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdatePhonesState implements UpdateStateInterface {

    Connection connection;
    PhonesModel phone;
    PreparedStatement pst;
    ResultSet rsl;
    String sql;

    public UpdatePhonesState(PhonesModel phone) {
        this.phone = phone;
        connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public String UpdateState(String Emei) throws Exception {
        String requete="UPDATE Phones SET etat_Materiel = ? WHERE IMEI=?";
        try(PreparedStatement stmt=connection.prepareStatement(requete)){
            stmt.setString(2,Emei);
            stmt.setString(1,"retrouvé");
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return "";
    }
}
