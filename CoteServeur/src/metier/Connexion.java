package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static Connection conn = null ;
    private final static String URL = "jdbc:postgresql://localhost:5432/ecole";
    private final static String USER = "postgres";
    private final static String PASSWORD = "passer";

    public static Connection getInstance(){
        if(conn == null){
            try{
                Class.forName("org.postgresql.Driver");
                DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connexion à la base de données réussie !");
            } catch(SQLException | ClassNotFoundException e){
                e.printStackTrace();
                System.err.println("Erreur detectée :"+e.getMessage());
            }
        }
        return conn ;
    }

    // PHASE DE TEST
    public static void main(String[] args) {
        Connection conn = Connexion.getInstance();
    }
}
