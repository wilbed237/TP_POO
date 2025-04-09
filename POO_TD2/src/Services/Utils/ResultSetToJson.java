package Services.Utils;


import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetToJson {
    public static String usersResultSetToJson(ResultSet rs) throws SQLException {
        StringBuilder jsonBuilder = new StringBuilder("[");

        boolean first = true;
        while (rs.next()) {
            if (!first) {
                jsonBuilder.append(",");
            }
            first = false;

            jsonBuilder.append("{");
            jsonBuilder.append("\"id_user\":").append(rs.getInt("id_user")).append(",");
            jsonBuilder.append("\"nom\":\"").append(rs.getString("nom")).append("\",");
            jsonBuilder.append("\"prenom\":\"").append(rs.getString("prenom")).append("\",");
            jsonBuilder.append("\"email\":\"").append(rs.getString("email")).append("\",");
            jsonBuilder.append("\"numtel\":\"").append(rs.getString("numtel")).append("\",");
            jsonBuilder.append("\"address\":\"").append(rs.getString("address")).append("\"");
            jsonBuilder.append("}");
        }

        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }
}
