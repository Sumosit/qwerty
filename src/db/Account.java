package db;

public class Account {
    private static String email = null;
    private static String name = null;
    private static String pass = null;

    public Account(){ }

    public Account(String email, String name, String pass) {
        Account.email = email;
        Account.name = name;
        Account.pass = pass;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Account.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Account.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        Account.pass = pass;
    }
}
