package Databases;

import POJO.TypeIncd;
import com.mysql.jdbc.Statement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IncidentTable {
    private static final String Table_INCIDENT = "incident";
    private static Statement stat;
    private static PreparedStatement pst = null;

    public static ArrayList<TypeIncd> getAllColumn (){
        ArrayList<TypeIncd> arrIncident = new ArrayList<TypeIncd>();

        try {
            stat = (Statement) MySQLClassDB.Conn().createStatement();
            ResultSet resultSet = stat.executeQuery("SELECT id, shotName, name from " + Table_INCIDENT);
            while(resultSet.next()){
                arrIncident.add(new TypeIncd(resultSet.getInt("id"), resultSet.getString("shotName"),resultSet.getString("name") ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    return arrIncident;
    }

    public static String getIncidNameById (int incidId){
        String incidName = "no value";
        try {
            String sql = "SELECT name from " + Table_INCIDENT + " WHERE id = ?";
            pst = MySQLClassDB.Conn().prepareStatement(sql);
            pst.setInt(1, incidId);
            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next()){
                incidName = resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return incidName;
    }
}
