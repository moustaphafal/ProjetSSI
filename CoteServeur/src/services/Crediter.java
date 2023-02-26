package services;

import java.sql.SQLException;

public class Crediter {
    public static void credit(int accountNumber, double amount) throws SQLException {
        // V�rifiez si le compte existe
        if (Account.exists(accountNumber)) {
            // R�cup�rez le solde actuel
            double currentBalance = Account.getBalance(accountNumber);
            // Ajoutez le montant � cr�diter au solde actuel
            double newBalance = currentBalance + amount;
            // Mettez � jour le solde
            Account.updateBalance(accountNumber, newBalance);
        } else {
            System.out.println("Le compte n'existe pas.");
        }
    }
}
