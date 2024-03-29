public class Historique_client {
    public static void historique(int accountNumber) {
        // V�rifiez si le compte existe
        if (Account.exists(accountNumber)) {
            // Connectez-vous � la base de donn�es
            Connection connection = Database.getConnection();
            // Ex�cutez une requ�te pour r�cup�rer l'historique des transactions pour le compte donn�
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM transaction_history WHERE sender_account_number = ? OR receiver_account_number = ?");
            statement.setInt(1, accountNumber);
            statement.setInt(2, accountNumber);
            ResultSet result = statement.executeQuery();
            // Affiche les r�sultats
            while (result.next()) {
                int senderAccountNumber = result.getInt("sender_account_number");
                int receiverAccountNumber = result.getInt("receiver_account_number");
                double amount = result.getDouble("amount");
                Timestamp timestamp = result.getTimestamp("timestamp");
                String senderOrReceiver = (senderAccountNumber == accountNumber) ? "Exp�diteur" : "Destinataire";
                System.out.println(senderOrReceiver + ": " + senderAccountNumber + " | " + receiverAccountNumber + " | " + amount + " | " + timestamp);
            }
        } else {
            System.out.println("Le compte n'existe pas.");
        }
    }
}
