public class Transfer {
    public static void transfer(int senderAccountNumber, int receiverAccountNumber, double amount) {
        // V�rifiez si les comptes existent
        if (Account.exists(senderAccountNumber) && Account.exists(receiverAccountNumber)) {
            // R�cup�rez le solde actuel du compte de l'exp�diteur
            double senderCurrentBalance = Account.getBalance(senderAccountNumber);
            // V�rifiez si le solde est suffisant pour effectuer le transfert
            if (senderCurrentBalance >= amount) {
                // D�bitez le compte de l'exp�diteur
                Debit.debit(senderAccountNumber, amount);
                // Cr�ditez le compte du destinataire
                Credit.credit(receiverAccountNumber, amount);
                // Enregistrez l'historique de transaction
                saveTransactionHistory(senderAccountNumber, receiverAccountNumber, amount);
                System.out.println("Transfert effectu� avec succ�s.");
            } else {
                System.out.println("Solde insuffisant pour effectuer le transfert.");
            }
        } else {
            System.out.println("Un ou plusieurs comptes n'existent pas.");
        }
    }
    private static void saveTransactionHistory(int senderAccountNumber, int receiverAccountNumber, double amount) {
        // Connectez-vous � la base de donn�es
        Connection connection = Database.getConnection();
        // Ins�rez les d�tails de la transaction dans la table de l'historique des transactions
        PreparedStatement statement = connection.prepareStatement("INSERT INTO transaction_history (sender_account_number, receiver_account_number, amount, timestamp) VALUES (?, ?, ?, ?)");
        statement.setInt(1, senderAccountNumber);
        statement.setInt(2, receiverAccountNumber);
        statement.setDouble(3, amount);
        statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
        statement.executeUpdate();
    }
}
