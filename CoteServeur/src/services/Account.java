package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.Connexion;

public class Account {

    // Connectez-vous � la base de donn�es
    private static Connection connection =  Connexion.getInstance();
    // Ex�cutez une requ�te pour v�rifier si le compte existe
    private static PreparedStatement statement ;

    public static boolean exists(int accountNumber){
        try {
            statement = connection.prepareStatement("SELECT * FROM accounts WHERE account_number = ?");
            statement.setInt(1, accountNumber);
            ResultSet result = statement.executeQuery();
            // Retourne vrai si un r�sultat est trouv�, faux sinon
            return result.next();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false; 
    }
    // ...

    public static double getBalance(int accountNumber) {
        double balance = 0;
        try {
            statement = connection.prepareStatement("SELECT balance FROM accounts WHERE account_number = ?");
            statement.setInt(1, accountNumber);
            ResultSet result = statement.executeQuery();
            // Récupérez le solde si un résultat est trouvé
            if (result.next()) {
                balance = result.getDouble("balance");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return balance;
    }
    
    public static void updateBalance(int accountNumber, double newBalance) {
        try {
            statement = connection.prepareStatement("UPDATE accounts SET balance = ? WHERE account_number = ?");
            statement.setDouble(1, newBalance);
            statement.setInt(2, accountNumber);
            int rowsAffected = statement.executeUpdate();
            // Vérifiez le nombre de lignes affectées par la mise à jour
            if (rowsAffected != 1) {
                System.out.println("Une erreur est survenue lors de la mise à jour du solde du compte.");
            }
        } catch (SQLException e) {
            System.err.println(" [Error] : "e.getMessage());
            e.printStackTrace();
        }
    }
    
}
