package Javaproject.Model;

public class user {
    // variabels
    static int id = 1;
    public int user_id;
    public String mail;
    public String password;
    public String name;
    public String designation;

    // cosntructor
    public user(String mail, String name, String password) {
        this.mail = mail;
        this.user_id = id;
        this.password = password;
        this.name = name;
        this.designation = "USER";
    }
}
