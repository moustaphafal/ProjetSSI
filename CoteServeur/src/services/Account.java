public class Account {
    public static boolean exists(int accountNumber) {
        // Connectez-vous � la base de donn�es
        Connection connection = Database.getConnection();
        // Ex�cutez une requ�te pour v�rifier si le compte existe
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM accounts WHERE account_number = ?");
        statement.setInt(1, accountNumber);
        ResultSet result = statement.executeQuery();
        // Retourne vrai si un r�sultat est trouv�, faux sinon
        return result.next();
    }
    // ...
}
