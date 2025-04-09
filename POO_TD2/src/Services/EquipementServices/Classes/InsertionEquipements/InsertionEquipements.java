package Services.EquipementServices.Classes.InsertionEquipements;

import Models.EquipementsModel;
import Services.DatabaseServices.DatabaseConnection;
import Services.EquipementServices.Interfaces.InsertionInterfaces.InsertionInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertionEquipements implements InsertionInterface {

    Connection connection ;
    EquipementsModel equipement;
    PreparedStatement pst;
    ResultSet rsl;
    String sql;

    public InsertionEquipements(EquipementsModel equipement) {
        this.equipement = equipement;
        connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public void Insertion() throws SQLException {

        String requet = "insert into Equipements(address_MAC,IdProprietaire,etat_Materiel,Nom,Marque,Modele,memoire_ROM,memoi_RAM,numero_serie) values (?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = DatabaseConnection.getInstance().getConnection().prepareStatement(requet)) {
            stmt.setString(1,equipement.getAddress_MAC());
            stmt.setInt(2,equipement.getIdProprietaire());
            stmt.setString(3,equipement.getCouleur());
            stmt.setString(4,equipement.getEtat_Materiel());
            stmt.setString(5,equipement.getNom());
            stmt.setString(6,equipement.getMarque());
            stmt.setString(7,equipement.getModele());
            stmt.setFloat(8,equipement.getMemoire_ROM());
            stmt.setFloat(9,equipement.getMemoire_RAM());
            stmt.setString(10,equipement.getNumero_serie());
            stmt.executeUpdate();
        } catch (SQLException ex) {
                ex.printStackTrace();
        }
    }
}
