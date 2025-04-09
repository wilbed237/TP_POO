package Services.EquipementServices.Classes.DeletePhones;

import Models.EquipementsModel;
import Models.PhonesModel;
import Services.DatabaseServices.DatabaseConnection;
import Services.EquipementServices.Interfaces.DeleteInterfaces.DeleteInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeletePhones implements DeleteInterface {
    Connection connection ;
    PhonesModel phone;
    PreparedStatement pst;
    ResultSet rsl;
    String sql;

    public DeletePhones(PhonesModel phone) {
        this.phone = phone;
        connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public String delete(Integer id) throws Exception {
        try{
            sql = "DELETE FROM Phones where IMEI = ?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, phone.getIMEI());
            pst.executeUpdate();
            return (phone.getNom() + " a été supprimé avec success");
        }catch (Exception e){
            throw new SQLException();
        }
    }
}
