package Javaproject.src;

import Javaproject.classes.Admin;
import Javaproject.classes.librarian;
import Javaproject.classes.user;

public class loginSession {
    // boolean loginSucess;
    user Userlogged = null;
    librarian Librarianlogged = null;
    Admin Adminlogged = null;

    // ArrayList<user> upadteArrayList;
    loginSession() {
        boolean validchoice = true;
        boolean loginSuccess = false;
        boolean loginAttempt = false;
        int choice = login.takeInputChoice();
        while (true) {
            if (loginSuccess && loginAttempt)
                break;
            if (!validchoice)
                choice = login.takeInputChoice();
            switch (choice) {
                case 1:
                    wrapper ansWrapper = login.validateLogin();
                    loginSuccess = ansWrapper.valid;
                    if (loginSuccess) {
                        if (ansWrapper.designation.equals("USER"))
                            this.Userlogged = Reference.userArray.get(ansWrapper.index);
                        else if (ansWrapper.designation.equals("LIBRARIAN"))
                            this.Librarianlogged = Reference.librarianArray.get(ansWrapper.index);
                        else
                            this.Adminlogged = Reference.adminArray.get(ansWrapper.index);
                        loginAttempt = true;
                    }
                    break;
                case 2:
                    // sign-up
                    user newUser = user.create();
                    Reference.userArray.add(newUser);
                    this.Userlogged = newUser;
                    loginSuccess = true;
                    loginAttempt = true;
                    break;
                case 3:
                    loginSuccess = true;
                    loginAttempt = true;
                    break;
                default:
                    System.out.println("enter a valid choice");
                    validchoice = false;                    
            }
        }
    }
}
