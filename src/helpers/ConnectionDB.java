package helpers;

import  java.sql.Connection;
import  java.sql.DriverManager;
import  java.sql.PreparedStatement;
//import  java.sql.ResultSet;

import  java.sql.SQLException;
import java.util.ArrayList;



public class ConnectionDB {
    /*
     * Classe para conexão e operações envolvendo o banco de dados. 
     * Requer que haja uma instância MySQL configurada de acordo com
     * os parâmetros especificados no método connect.
     */

    public Connection connect() throws SQLException{

        System.out.println("Chamou a função");
        
        String driver = "com.mysql.cj.jdbc.Driver";
        String error_msg = "Erro na Conexão com o BD: ";

        String server = "localhost";
        String port = "3306";
        String database = "projeto-semestral";
        String user = "user_termo";
        String password = "termooo";

        try{
            Class.forName(driver);
            System.out.println("Conseguiu conectar");
            return DriverManager.getConnection("jdbc:mysql://"+server+":"+port+"/"+database+"?user="+user+"&password="+password);
        }
        catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(error_msg + e);
        }
        

    }

    public static void disconect(Connection conn) throws SQLException{

        System.out.println("Fechando a conexão");
        conn.close();
    }

    public void populate_db(Connection conn, ArrayList<String> words){
       
        /*
         * words => ArrayList contendo as palavras a serem inseridas no BD.
         * 
         * conn => Conexão para o Banco de Dados
         */

    String table_name = "dicionario";

    String populateQuery = "INSERT INTO "+table_name+"(palavra) VALUES (?)";

    try (PreparedStatement stmt = conn.prepareStatement(populateQuery);){

        for(String word : words){

            stmt.setString(1, word);
            stmt.executeUpdate();

        }
        System.out.println("Banco de dados povoado!");

    }
    catch (SQLException sqle){
        System.out.println(sqle.getStackTrace());
    }

    }

    // public void insert(Connection conn){
        
    //     String table_name = "dicionario";

    //     String insertQuery = "INSERT INTO "+table_name+"(id, palavra) VALUES (?, ?)";

    //     try(PreparedStatement stmt = conn.prepareStatement(insertQuery);){
    //         stmt.set

    //     }
    //     catch{

    //     }
    //     finally{
    //         disconect(conn);
    //     }

    // }
}
