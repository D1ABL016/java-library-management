package Javaproject.src;
// package libraryManagement;

import java.util.Scanner;

import Javaproject.models.Admin;
import Javaproject.models.librarian;
import Javaproject.models.user;


class wrapper{
    int index;
    boolean valid;
    String designation;
    wrapper(int index ,boolean valid,String designation){
        this.index = index;
        this.valid = valid;
        this.designation = designation;
    }
}

public class login {

    static int takeInputChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. login");
        System.out.println("2. signup");
        System.out.println("3. Exit");
        int choice = validators.validatePositiveNumber("choice");
        // sc.close();
        return choice;
    }

    static wrapper validateLogin() {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("enter email : ");
        String mail = sc.nextLine();
        System.out.print("enter password : ");
        String password = sc.nextLine();
        // int index = -1;
        wrapper   ans;

        for (int i = 0; i < Reference.userArray.size(); i++) {
            user loginUser = Reference.userArray.get(i);
            if (loginUser.validateUser(mail, password, loginUser)) {
                System.out.println("welcome to library " + loginUser.getName());
                ans = new wrapper(i, true,"USER");
                return ans;
            }
        }
        for (int i = 0; i < Reference.librarianArray.size(); i++) {
            librarian loginUser = Reference.librarianArray.get(i);
            if (loginUser.validateUser(mail, password, loginUser)) {
                System.out.println("welcome to library " + loginUser.getName());
                ans = new wrapper(i, true,"LIBRARIAN");
                return ans;
            }
        }
        for (int i = 0; i < Reference.adminArray.size(); i++) {
            Admin loginUser = Reference.adminArray.get(i);
            if (loginUser.validateUser(mail, password, loginUser)) {
                System.out.println("welcome to library " + loginUser.getName());
                ans = new wrapper(i, true,"ADMIN");
                return ans;
            }
        }
        System.out.println("enter a valid mail or password or signup the user");
        ans = new wrapper(-1, false,null);
        return ans;
    }

}
