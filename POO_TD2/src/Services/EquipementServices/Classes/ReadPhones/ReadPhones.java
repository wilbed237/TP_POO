package Services.EquipementServices.Classes.ReadPhones;

import Models.PhonesModel;
import Services.DatabaseServices.DatabaseConnection;
import Services.EquipementServices.Interfaces.ReadInterfaces.ReadInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadPhones implements ReadInterface {
    PhonesModel phone;
    Connection connection;
    PreparedStatement pst;
    ResultSet rsl;
    String sql;

    public ReadPhones(PhonesModel phone) {
        this.phone = phone;
        connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public ArrayList<PhonesModel> read(Integer id) throws Exception {
        ArrayList<PhonesModel> phones = new ArrayList<>();

        try {
            // Requête SQL paramétrée
            sql = "SELECT * FROM Agents WHERE Code = ?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, phone.getIMEI());

            // Exécution de la requête
            rsl = pst.executeQuery();

            // Parcours des résultats et création des objets PhonesModel
            while (rsl.next()) {
                PhonesModel phonesModel = new PhonesModel();
                phonesModel.setIMEI(rsl.getString("MEI"));
                phonesModel.setNom(rsl.getString("nom"));
                phonesModel.setModele(rsl.getString("Modele"));
                phonesModel.setMemoire_ROM(rsl.getFloat("Memoire_ROM"));
                phonesModel.setMemoire_RAM(rsl.getFloat("Memoire_RAM"));
                phonesModel.setNumero_serie(rsl.getString("Memoire_serie"));
                phonesModel.setIdPropretaire(rsl.getInt("IdPropiétaire"));
                phonesModel.setCouleur(rsl.getString("Couleur"));
                phonesModel.setEtat_Materiel(rsl.getString("Etat_Matériel"));

                phones.add(phonesModel); // Ajouter l'objet à la liste
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Erreur lors de la lecture des phones: " + e.getMessage());
        } finally {
            // Fermeture des ressources
            if (rsl != null) rsl.close();
            if (pst != null) pst.close();
        }

        return phones;
    }
}
