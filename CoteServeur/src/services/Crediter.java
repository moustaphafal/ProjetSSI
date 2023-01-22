public class Crediter {
    public static void credit(int accountNumber, double amount) {
        // Vérifiez si le compte existe
        if (Account.exists(accountNumber)) {
            // Récupérez le solde actuel
            double currentBalance = Account.getBalance(accountNumber);
            // Ajoutez le montant à créditer au solde actuel
            double newBalance = currentBalance + amount;
            // Mettez à jour le solde
            Account.updateBalance(accountNumber, newBalance);
        } else {
            System.out.println("Le compte n'existe pas.");
        }
    }
}
