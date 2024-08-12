package Javaproject.Model;

public class book {
    static int id = 1;
    String BookName;
    String AuthorName;
    int bookID;
    int units;

    public book(String bookName ,String authorName ,int units) {
        this.BookName = bookName;
        this.AuthorName = authorName;
        this.bookID = id;
        this.units = units;
        id++;
    }
}
