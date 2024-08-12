package Javaproject.Model;

// import java.lang.reflect.Array;
// package libraryManagement;
import java.time.LocalDate;


public class Add_book {
    book addedBook; // book type
    librarian addedBy;// user type    
    LocalDate addedDate;
    

    Add_book(book added_book, librarian addedBy) {
        this.addedBook = added_book;
        this.addedBy = addedBy;
        this.addedDate = LocalDate.now();        
    }
}
