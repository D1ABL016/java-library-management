package Javaproject.classes;

import java.util.Scanner;

import Javaproject.src.Reference;

public class Admin extends librarian {
    public Admin(String mail, String name, String password) {
        super(mail, name, password);
        designation = "ADMIN";
    }

    public int getLoggedIn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. search a book");
        System.out.println("2. check  the books that were issued to you");
        System.out.println("3. check  the books that were issued to a particular user");
        System.out.println("4. check  the books that were issued by you");
        System.out.println("5. issue a book");
        System.out.println("6. return a book");
        System.out.println("7. add a book");
        System.out.println("8. check  the books that were added by you");
        System.out.println("9. check  the books that were added by particular librarian");
        System.out.println("10. check  the books that were issued by particular librarian");

        System.out.println("11. add a librarian");
        System.out.println("12. add a admin");
        System.out.println("13. Logout");
        int choice = validators.validatePositiveNumber("choice");
        return choice;
    }

    public void LoggedInUserInterface(Admin admin) {
        int choice = getLoggedIn();
        boolean validchoice = true;
        boolean execCompleted = false;
        librarian lib = admin;
        user User = lib;
        while (true) {
            // Scanner sc = new Scanner(System.in);
            if (execCompleted)
                break;
            if (!validchoice)
                choice = getLoggedIn();
            switch (choice) {
                case 1:
                    getsearchBook();
                    break;
                case 2:
                    getHistoryofParticularuser(User);
                    break;
                case 3:
                    wrappergetHistoryOfUser();
                    break;
                case 4:
                    getHistoryOfLibrarian(lib);
                    break;
                case 5:// issue
                    issueBook(lib);
                    break;
                case 6:// returun
                    returnBook();
                    break;
                case 7:// add
                    addBook(lib);
                    break;
                case 8:// add book history
                    getHistoryofAddedBook(lib);
                    break;
                case 9:// add book history
                    wrappergetHistoryofBookAdd();
                    break;
                case 10:// add book history
                    wrappergetHistoryofLibrarian();
                    break;
                case 11:// add librarian
                    addLibrarian();
                    // getHistoryofAddedBook(lib);
                    break;
                case 12:// add admin
                    addAdmin();
                    // getHistoryofAddedBook(lib);
                    break;
                case 13:
                    execCompleted = true;
                    break;
                default:
                    System.out.println("enter a valid choice");
                    // break;
            }
            validchoice = false;
        }
    }

    void wrappergetHistoryofBookAdd() {
        librarian tempLibrarian = getLibrarianDetailAndFind();
        if (tempLibrarian == null)
            System.out.println("no librarian found with specified fields");
        else
            getHistoryofAddedBook(tempLibrarian);

    }

    void wrappergetHistoryofLibrarian() {
        librarian tempLibrarian = getLibrarianDetailAndFind();
        if (tempLibrarian == null)
            System.out.println("no librarian found with specified fields");
        else
            getHistoryOfLibrarian(tempLibrarian);
    }

    void addAdmin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter e-mail : ");
        String mail = sc.nextLine();
        while (!mail.endsWith("@gmail.com")) {
            System.out.println("enter a valid mail");
            System.out.print("enter e-mail : ");
            mail = sc.nextLine();
        }
        System.out.print("enter password : ");
        String password = sc.nextLine();

        System.out.print("enter name : ");
        String name = sc.nextLine();
        id++;
        Admin newAdmin = new Admin(mail, name, password);
        Reference.adminArray.add(newAdmin);
        // Reference.userArray.add(newUser);
        // return newUser;
    }
}
