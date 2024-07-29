package Javaproject.classes;

import java.util.Scanner;

import Javaproject.src.Reference;

public class book {
    static int id = 1;
    String BookName;
    String AuthorName;
    int bookID;
    int units;

    public book() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the book name : ");
        String bookName = sc.nextLine();
        System.out.println("enter the author name : ");
        String authorName = sc.nextLine();
        // System.out.println("enter the no. of units : ");
        int units = validators.validatePositiveNumber("units");

        this.BookName = bookName;
        this.AuthorName = authorName;
        this.bookID = id;
        this.units = units;
        id++;
    }

    public book(String bookName,String authorName,int units) {
        this.BookName = bookName;
        this.AuthorName = authorName;
        this.bookID = id;
        this.units = units;
        id++;
    }


    void print() {
        System.out.println("Book name : " + this.BookName);
        System.out.println("author name : " + this.AuthorName);
        System.out.println("Book id : " + this.bookID);
        System.out.println("Avialiable units : " + this.units);
    }

    static public book findByname(String name, String auhtor) {
        for (int i = 0; i < Reference.bookArray.size(); i++) {
            book tempBook = Reference.bookArray.get(i);
            if (tempBook.AuthorName.equals(auhtor) && tempBook.BookName.equals(name))
                return tempBook;
        }
        return null;
    }

    public void decrementUnits() {
        this.units = this.units - 1;
    }

    public boolean equals(book book1,book book2){
        return(book1.bookID == book2.bookID);
    }

        

    static public book getDetailsAndFindBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the name of book ");
        String bookName = sc.nextLine();
        System.out.println("enter the author of book  ");
        String author = sc.nextLine();
        book getBook = book.findByname(bookName, author);
        return getBook;
    }
}
