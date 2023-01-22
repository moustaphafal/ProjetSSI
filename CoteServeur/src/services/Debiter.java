public class Debiter {
    public static void debit(int accountNumber, double amount) {
        // Vérifiez si le compte existe
        if (Account.exists(accountNumber)) {
            // Récupérez le solde actuel
            double currentBalance = Account.getBalance(accountNumber);
            // Soustrayez le montant à débiter du solde actuel
            double newBalance = currentBalance - amount;
            // Vérifiez si le solde est suffisant pour effectuer le débit
            if (newBalance >= 0) {
                // Mettez à jour le solde
                Account.updateBalance(accountNumber, newBalance);
            } else {
                System.out.println("Solde insuffisant pour effectuer le débit.");
            }
        } else {
            System.out.println("Le compte n'existe pas.");
        }
    }
}
