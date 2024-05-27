package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionDB {
    /*
     * Classe para conexão e operações envolvendo o banco de dados.
     * Requer que haja uma instância MySQL configurada de acordo com
     * os parâmetros especificados no método connect.
     */

    public Connection connect() throws SQLException {

        System.out.println("Chamou a função");

        String driver = "com.mysql.cj.jdbc.Driver";
        String error_msg = "Erro na Conexão com o BD: ";

        String server = "localhost";
        String port = "3306";
        String database = "projetosemestral";
        String user = "user_termo";
        String password = "termooo";

        try {
            Class.forName(driver);
            System.out.println("Conseguiu conectar");
            return DriverManager.getConnection(
                    "jdbc:mysql://" + server + ":" + port + "/" + database + "?user=" + user + "&password=" + password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(error_msg + e);
        }

    }

    public static void disconect(Connection conn) throws SQLException {

        System.out.println("Fechando a conexão");
        conn.close();
    }

    public static String getWord(Connection conn) throws SQLException {

        String getWordQuery = "SELECT palavra FROM dicionario ORDER BY RAND() LIMIT 1;";

        PreparedStatement stmt = null;
        try {

            stmt = conn.prepareStatement(getWordQuery);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString(1);
                }

            } catch (Exception e) {
            }
            conn.close();

        } catch (SQLException sqle) {
            System.out.println(sqle.getStackTrace());
        }

        System.err.println(stmt.executeQuery().getString("palavra"));

        return stmt.executeQuery().getString("palavra");
    }

    public void populate_db(Connection conn, ArrayList<String> words) {

        /*
         * words => ArrayList contendo as palavras a serem inseridas no BD.
         * 
         * conn => Conexão para o Banco de Dados
         */

        /*
         * String populateQuery = "INSERT INTO " + table_name + " VALUES ('BRENO')";
         * PreparedStatement stmt = conn.prepareStatement(populateQuery);
         * stmt.executeQuery();
         */
        String populateQuery = "INSERT INTO dicionario(palavra) VALUES (?)";

        PreparedStatement stmt = null;
        try {
            for (String word : words) {
                stmt = conn.prepareStatement(populateQuery);
                stmt.setString(1, word);
                stmt.execute();
            }
            conn.close();

        } catch (SQLException sqle) {
            System.out.println(sqle.getStackTrace());
        }

    }

}
