public class Transfer {
    public static void transfer(int senderAccountNumber, int receiverAccountNumber, double amount) {
        // Vérifiez si les comptes existent
        if (Account.exists(senderAccountNumber) && Account.exists(receiverAccountNumber)) {
            // Récupérez le solde actuel du compte de l'expéditeur
            double senderCurrentBalance = Account.getBalance(senderAccountNumber);
            // Vérifiez si le solde est suffisant pour effectuer le transfert
            if (senderCurrentBalance >= amount) {
                // Débitez le compte de l'expéditeur
                Debit.debit(senderAccountNumber, amount);
                // Créditez le compte du destinataire
                Credit.credit(receiverAccountNumber, amount);
                // Enregistrez l'historique de transaction
                saveTransactionHistory(senderAccountNumber, receiverAccountNumber, amount);
                System.out.println("Transfert effectué avec succès.");
            } else {
                System.out.println("Solde insuffisant pour effectuer le transfert.");
            }
        } else {
            System.out.println("Un ou plusieurs comptes n'existent pas.");
        }
    }
    private static void saveTransactionHistory(int senderAccountNumber, int receiverAccountNumber, double amount) {
        // Connectez-vous à la base de données
        Connection connection = Database.getConnection();
        // Insérez les détails de la transaction dans la table de l'historique des transactions
        PreparedStatement statement = connection.prepareStatement("INSERT INTO transaction_history (sender_account_number, receiver_account_number, amount, timestamp) VALUES (?, ?, ?, ?)");
        statement.setInt(1, senderAccountNumber);
        statement.setInt(2, receiverAccountNumber);
        statement.setDouble(3, amount);
        statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
        statement.executeUpdate();
    }
}
