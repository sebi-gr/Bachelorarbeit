public class Main {
    public boolean loginUser(String username, String plainTextPassword) {
        // Abrufen des gespeicherten gehashten Passworts für 'username' aus Ihrer Datenbank
        String storedHashedPassword = ""; // Angenommen, dies kommt aus Ihrer Datenbank

        return PasswordHandler.checkPassword(plainTextPassword, storedHashedPassword);
    }

    public void registerUser(String username, String plainTextPassword) {
        String hashedPassword = PasswordHandler.hashPassword(plainTextPassword);
        // Speichern Sie hier 'username' und 'hashedPassword' in Ihrer Datenbank
    }

}
