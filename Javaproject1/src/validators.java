package Javaproject.src;
import java.util.Scanner;


class unitsValidException extends Exception {}

public class validators {

    static public int validateInt(String str){
        int units = 0;
        Scanner sc = new Scanner(System.in);
        // boolean valid = false;
        while (true) {
            System.out.println("enter "+ str);
            String input = sc.nextLine();
            try {
                units = Integer.parseInt(input);  
                return units;              
            } catch (NumberFormatException e) {
                // TODO: handle exception
                System.out.println("Invalid input! Please enter a valid number.");
            } 
        }
        // return -1;
    }

    static public int validatePositiveNumber(String str){
        while (true) {
            try {
                int n = validateInt(str);
                if(n<=0)    throw new unitsValidException();
                else    return n;
                
            } catch (unitsValidException e) {
                System.out.println("Invalid input! Please enter a positive number. ");
            }
        }
    } 

}
