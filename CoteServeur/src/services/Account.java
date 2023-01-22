public class Account {
    public static boolean exists(int accountNumber) {
        // Connectez-vous à la base de données
        Connection connection = Database.getConnection();
        // Exécutez une requête pour vérifier si le compte existe
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM accounts WHERE account_number = ?");
        statement.setInt(1, accountNumber);
        ResultSet result = statement.executeQuery();
        // Retourne vrai si un résultat est trouvé, faux sinon
        return result.next();
    }
    // ...
}
