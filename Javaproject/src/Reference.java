package Javaproject.src;
import java.util.ArrayList;

import Javaproject.classes.*;



public class Reference {
    static public ArrayList<user> userArray = new ArrayList<user>(); // list of all users present in db

    static public ArrayList<librarian> librarianArray = new ArrayList<librarian>(); // list of all users present in db

    static public ArrayList<Admin> adminArray = new ArrayList<Admin>(); // list of all users present in db
    
    
    static public ArrayList<book> bookArray = new ArrayList<book>(); // list of all books present in db
    static public ArrayList<issue_book> issueBookArray = new ArrayList<issue_book>(); // list of all issued books present in db
    static public ArrayList<Add_book> AddBookArray = new ArrayList<Add_book>(); // list of all added books present in db
}
