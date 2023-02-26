package services;

import java.sql.SQLException;

public class Debiter {
    public static void debit(int accountNumber, double amount) {
        if (Account.exists(accountNumber)) {
            // R�cup�rez le solde actuel
            double currentBalance = Account.getBalance(accountNumber);
            // Soustrayez le montant � d�biter du solde actuel
            double newBalance = currentBalance - amount;
            // V�rifiez si le solde est suffisant pour effectuer le d�bit
            if (newBalance >= 0) {
                // Mettez � jour le solde
                Account.updateBalance(accountNumber, newBalance);
            } else {
                System.out.println("Solde insuffisant pour effectuer le d�bit.");
            }
        } else {
            System.out.println("Le compte n'existe pas.");
        }
    }
}
