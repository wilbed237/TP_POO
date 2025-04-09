package Services.EquipementServices.Classes.DeleteEquipements;

import Models.EquipementsModel;
import Services.DatabaseServices.DatabaseConnection;
import Services.EquipementServices.Interfaces.DeleteInterfaces.DeleteInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteEquipements implements DeleteInterface {

    Connection connection ;
    EquipementsModel equipement;
    PreparedStatement pst;
    ResultSet rsl;
    String sql;

    public DeleteEquipements(EquipementsModel equipement) {
        this.equipement = equipement;
        connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public String delete(Integer id) throws Exception {
        try{
            sql = "DELETE FROM Equipements where address_MAC = ?";
            pst = connection.prepareStatement(sql);
            pst.setString(1,equipement.getAddress_MAC());
            pst.executeUpdate();
            return (equipement.getNom() + " a été supprimé avec success");
        }catch (Exception e){
            throw new SQLException();
        }
    }
}
