package helpers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import helpers.ConnectionDB;

public class DBManagement {
    public static void main(String[] args) {

        Connection conn = null;

        ArrayList<String> words = new ArrayList<String>(Arrays.asList(
            "Aarao",
            "abaco",
            "abade",
            "zunam",
            "zunas",
            "zunem",
            "zunes",
            "zunia",
            "zunir",
            "zunis",
            "zuniu",
            "zurra",
            "zurre",
            "zurro"));

            try{
                ConnectionDB db = new ConnectionDB();
                conn = db.connect();
                db.populate_db(conn, words);
            }
            catch(Exception e){
                e.printStackTrace();
                if(conn != null){
                    try{
                        conn.rollback();
                    }
                    catch(SQLException sqle){
                        System.out.println(sqle.getStackTrace());
                    }
                }

            }
            finally{
                if(conn != null){
                    try{
                        conn.close();
                    }
                    catch(SQLException sqle){
                        System.out.println(sqle.getStackTrace());
                    }
                }      

            }
    }
    
}
