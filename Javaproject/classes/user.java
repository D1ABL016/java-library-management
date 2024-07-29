package Javaproject.classes;
// package libraryManagement;

import java.util.ArrayList;
import java.util.Scanner;

import Javaproject.src.Reference;

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
        // id++;
        this.password = password;
        this.name = name;
        this.designation = "USER";

    }

    // methods
    public boolean validateUser(String mail, String password, user u1) {
        if (mail.equals(u1.mail)) {
            if (password.equals(u1.password))
                return true;
            return false;
        } else
            return false;
    }

    public static user create() {
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
        user newUser = new user(mail, name, password);
        // Reference.userArray.add(newUser);
        return newUser;
    }

    public String getName() {
        return this.name;
    }

    void getsearchBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter book name : ");
        String bookname = sc.nextLine();
        System.out.println("Enter book's author name : ");
        String authorname = sc.nextLine();
        searchBook(bookname, authorname);
    }

    void searchBook(String bookname, String authorname) {
        System.out.println("\n");
        for (int i = 0; i < (Reference.bookArray.size()); i++) {
            book tempBook = Reference.bookArray.get(i);
            if (tempBook.AuthorName.equals(authorname) && tempBook.BookName.equals(bookname)) {
                tempBook.print();
                System.out.println("\n");
                return;
            }
        }
        System.out.println("no book found with specified name and author name");
        System.out.println("\n");
    }

    int getLoggedinUserInterface() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. search a book");
        System.out.println("2. check  the books that were issued to you");
        System.out.println("3. Logout");
        int choice = validators.validatePositiveNumber("choice");
        return choice;
    }

    public void LoggedInUserInterface(user User) {

        int choice = getLoggedinUserInterface();
        boolean validchoice = true;
        boolean execCompleted = false;
        while (true) {
            if (execCompleted)
                break;
            if (!validchoice)
                choice = getLoggedinUserInterface();
            switch (choice) {
                case 1:
                    getsearchBook();
                    // System.out.println("\n");
                    break;
                case 2:
                    getHistoryofParticularuser(User);
                    // System.out.println("\n");
                    break;
                case 3:
                    execCompleted = true;
                    break;
                default:
                    System.out.println("enter a valid choice");
                    // break;
            }
            validchoice = false;
        }
    }

    void getHistoryofParticularuser(user User) {
        System.out.println("\n");
        ArrayList<issue_book> response = HistoryofParticularuser(User);
        if ((response.size() == 0)){
            System.out.println("No Records Found");
            System.out.println("\n");
            return;
        }
        for (int i = 0; i < response.size(); i++) {
            issue_book temp = response.get(i);
            System.out.println(i + " => ");
            temp.print();
            System.out.println("\n");
        }
    }

    ArrayList<issue_book> HistoryofParticularuser(user User) {
        ArrayList<issue_book> ans = new ArrayList<issue_book>();
        for (int i = 0; i < Reference.issueBookArray.size(); i++) {
            issue_book temp = Reference.issueBookArray.get(i);
            if (equals(temp.issuedTo, User))
                ans.add(temp);
        }
        return ans;
    }

    boolean equals(user User1, user User2) {
        if (User1.user_id == User2.user_id)
            return true;
        else
            return false;
    }

    public user findUserByName(String name, String mail) {
        for (int i = 0; i < Reference.userArray.size(); i++) {
            user tempArr = Reference.userArray.get(i);
            if (name.equals(tempArr.name) && mail.equals(tempArr.mail))
                return tempArr;
        }
        return null;
    }

    public user getUserDetailsAndFind() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the name of user ");
        String userName = sc.nextLine();
        System.out.println("enter the mail ");
        String mail = sc.nextLine();
        user ToFindUser = findUserByName(userName, mail);
        return ToFindUser;
    }

}
