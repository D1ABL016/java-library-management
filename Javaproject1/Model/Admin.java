package Javaproject.Model;



public class Admin extends librarian {
    public Admin(String mail, String name, String password) {
        super(mail, name, password);
        designation = "ADMIN";
    }
}
