package Javaproject.Model;

// package Javaproject.models;

// package libraryManagement;
import java.time.LocalDate;



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
}
