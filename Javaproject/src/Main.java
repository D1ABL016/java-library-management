package Javaproject.src;

// import Javaproject.classes.Admin;
// import Javaproject.classes.book;
// import Javaproject.classes.librarian;
// import Javaproject.classes.user;
import Javaproject.classes.*;
import Javaproject.models.Admin;
import Javaproject.models.book;
import Javaproject.models.librarian;
import Javaproject.models.user;

public class Main {

    static void populateDb() {
        Admin a1 = new Admin("admin@gmail.com", "admin", "1234");
        Reference.adminArray.add(a1);

        librarian l1 = new librarian("l1@gmail.com", "lakshay", "1234");
        Reference.librarianArray.add(l1);

        user u1 = new user("u1@gmail.com", "aryan", "1234");
        Reference.userArray.add(u1);

        book b1 = new book("god of small things", "arunndhati roy", 14);
        book b2 = new book("autobiography of a yogi", "paramahansa yogananda", 13);
        Reference.bookArray.add(b1);
        Reference.bookArray.add(b2);

    }

    public static void main(String[] args) {
        populateDb();
        loginSession session = new loginSession();
        boolean exitLoop = false;
        while (true) {
            if (session.Userlogged == null && session.Librarianlogged == null && session.Adminlogged == null) {
                // exit the loop
                exitLoop = true;
                break;
            } else if (session.Userlogged == null && session.Librarianlogged == null) {
                // Admin is logged in
                Admin loggedInAdmin = session.Adminlogged;
                loggedInAdmin.LoggedInUserInterface(loggedInAdmin);
            } else if (session.Userlogged == null && session.Adminlogged == null) {
                // Librarian is logged in
                librarian loggedInLibrarian = session.Librarianlogged;
                loggedInLibrarian.LoggedInUserInterface(loggedInLibrarian);
            } else {
                // User is logged in
                user loggedinuser = session.Userlogged;
                loggedinuser.LoggedInUserInterface(loggedinuser);
            }
            if (exitLoop)
                break;
            session = new loginSession();
        }
    }
}