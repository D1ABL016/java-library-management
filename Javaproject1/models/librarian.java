package Javaproject.models;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

import Javaproject.src.Reference;
import Javaproject.src.validators;

public class librarian extends user {
    public librarian(String mail, String name, String password) {
        super(mail, name, password);
        designation = "LIBRARIAN";
    }

    void addLibrarian(){
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
        librarian newAdmin = new librarian(mail, name, password);
        Reference.librarianArray.add(newAdmin);
    }

    public void wrappergetHistoryOfUser() {
        user ToFindUser = getUserDetailsAndFind();
        if (ToFindUser == null)
            System.out.println("no user found with particular name and mail");
        // return false;
        else
            getHistoryofParticularuser(ToFindUser);
        // return true;

    }

    public void getHistoryOfLibrarian(librarian Librarian) {
        System.out.println("\n");
        ArrayList<issue_book> response = HistoryofParticularLibrarian(Librarian);
        if ((response.size() == 0)) {
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

    public ArrayList<issue_book> HistoryofParticularLibrarian(librarian Librarian) {
        ArrayList<issue_book> ans = new ArrayList<issue_book>();
        for (int i = 0; i < Reference.issueBookArray.size(); i++) {
            issue_book temp = Reference.issueBookArray.get(i);
            if (equals(temp.issuedBy, Librarian))
                ans.add(temp);
        }
        return ans;
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
        System.out.println("9. Logout");
        int choice = validators.validatePositiveNumber("choice");
        return choice;
    }

    public void LoggedInUserInterface(librarian lib) {
        int choice = getLoggedIn();
        boolean validchoice = true;
        boolean execCompleted = false;
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
                case 9:
                    execCompleted = true;
                    break;
                default:
                    System.out.println("enter a valid choice");
                    // break;
            }
            validchoice = false;
        }
    }

    public void issueBook(librarian lib) {
        System.out.println("\n");
        user ToFindUser = getUserDetailsAndFind();
        if (ToFindUser == null) {
            System.out.println("no user found with particular name and mail");
            System.out.println("\n");
            return;
        } else {
            book getBook = book.getDetailsAndFindBook();
            if (getBook == null) {
                System.out.println("no book with specified details");
                System.out.println("\n");
                return;

            } else {
                issue_book record = new issue_book(lib, ToFindUser, getBook);
                getBook.decrementUnits();
                Reference.issueBookArray.add(record);
                System.out.println("book issued succesfully");
                System.out.println("\n");
            }
        }
    }

    public void returnBook() {
        System.out.println("\n");
        user ToFindUser = getUserDetailsAndFind();
        if (ToFindUser == null) {
            System.out.println("no user found with particular name and mail");
            System.out.println("\n");
            return;
        }
        else {
            book getBook = book.getDetailsAndFindBook();
            if (getBook == null) {
                System.out.println("no book with specified details");
                System.out.println("\n");
                return;

            } else {
                issue_book rec = issue_book.findRecord(ToFindUser, getBook);
                if (rec == null){
                    System.out.println("No record found");
                    System.out.println("\n");

                }
                else {
                    if(rec.returnDate == null){
                        rec.returnDate = LocalDate.now();
                        System.out.println("book returned succesfully");
                        System.out.println("\n");
                    }
                    else{
                        System.out.println("book is already returned");
                        System.out.println("\n");
                    }
                }
            }
        }
    }

    public void addBook(librarian lib) {
        System.out.println("\n");
        book addedBook = new book();
        Reference.bookArray.add(addedBook);
        Add_book rec = new Add_book(addedBook, lib);
        Reference.AddBookArray.add(rec);
        System.out.println("book added succesfully");
        System.out.println("\n");
    }

    public void getHistoryofAddedBook(librarian Librarian) {
        ArrayList<Add_book> response = HistoryofAddedBook(Librarian);
        if ((response.size() == 0)) {
            System.out.println("No Records Found");
            System.out.println("\n");
            return;

        }
        for (int i = 0; i < response.size(); i++) {
            Add_book temp = response.get(i);
            System.out.println(i + " => ");
            temp.print();
            System.out.println("\n");
        }
    }

    public ArrayList<Add_book> HistoryofAddedBook(librarian Librarian) {
        ArrayList<Add_book> ans = new ArrayList<Add_book>();
        for (int i = 0; i < Reference.AddBookArray.size(); i++) {
            Add_book temp = Reference.AddBookArray.get(i);
            if (equals(temp.addedBy, Librarian))
                ans.add(temp);
        }
        return ans;
    }

    public librarian getLibrarianDetailAndFind() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the name of user ");
        String userName = sc.nextLine();
        System.out.println("enter the mail ");
        String mail = sc.nextLine();
        librarian ToFindUser = findLibrarianByName(userName, mail);
        return ToFindUser;
    }

    public librarian findLibrarianByName(String name, String mail) {

        for (int i = 0; i < Reference.librarianArray.size(); i++) {
            librarian tempArr = Reference.librarianArray.get(i);
            if (name.equals(tempArr.name) && mail.equals(tempArr.mail))
                return tempArr;
        }
        return null;
    }

}
