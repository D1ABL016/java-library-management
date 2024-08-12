package Javaproject.Model;

public class librarian extends user {
    public librarian(String mail, String name, String password) {
        super(mail, name, password);
        designation = "LIBRARIAN";
    }
}
