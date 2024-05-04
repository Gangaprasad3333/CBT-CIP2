class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter methods
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Method to update password
    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }

    // Method to update profile
    public void updateProfile(String newUsername) {
        this.username = newUsername;
    }
}