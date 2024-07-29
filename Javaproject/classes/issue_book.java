package Javaproject.classes;

// package libraryManagement;
import java.time.LocalDate;

import Javaproject.src.Reference;

public class issue_book {
    user issuedBy;
    user issuedTo;
    book addedBook;
    LocalDate issuedDate;
    LocalDate returnDate = null;

    issue_book(user issuedBy, user issuedTo, book addedBook) {
        this.issuedBy = issuedBy;
        this.issuedTo = issuedTo;
        this.addedBook = addedBook;
        issuedDate = LocalDate.now();
    }

    public void print() {
        System.out.println("Issued By => " + this.issuedBy.name);
        System.out.println("Issued To => " + this.issuedTo.name);
        System.out.println("Book => " + this.addedBook.BookName);
        System.out.println("Issued Date => " + this.issuedDate);
        System.out.println("Return Date => " + this.returnDate);
    }

    static public issue_book findRecord(user issuedTo, book BookIsssued) {
        for (int i = 0; i < Reference.issueBookArray.size(); i++) {
            issue_book tempRecord = Reference.issueBookArray.get(i);
            if ((issuedTo.equals(issuedTo, tempRecord.issuedTo))
                    && (BookIsssued.equals(BookIsssued, tempRecord.addedBook))) {
                        return tempRecord;
            }
        }
        return null;
    }
}
