package Databases;

import POJO.AlgorAction;
import com.mysql.jdbc.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlgDosTable {

    private static final String TABLE_ALG_DOS = "alg_dos";
    private static Statement stat;

    public static ArrayList<AlgorAction> getAllColumn (){
        ArrayList<AlgorAction> arrActionOnIncident= new ArrayList<AlgorAction>();
        try {
            stat = (Statement) MySQLClassDB.Conn().createStatement();
            ResultSet resultSet = stat.executeQuery("select id, action, time from " + TABLE_ALG_DOS);
            while(resultSet.next()){
                arrActionOnIncident.add(new AlgorAction(resultSet.getInt("id"), resultSet.getString("action"), resultSet.getString("time")));
            }
            resultSet.close();
            stat.close();
            MySQLClassDB.CloseDB();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    return arrActionOnIncident;
    }
}
