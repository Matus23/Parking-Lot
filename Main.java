import java.util.Scanner;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static double inputScan(String s1, String s2) {
        Scanner javaInput = new Scanner(System.in);
        int a;
        double b;
        System.out.print(s1);
        a = Integer.parseInt(s1);
        System.out.print(s2);
        b = Double.parseDouble(s2);
        return a*b;
    }
    
    public static void main() {
        Car CarA = new Car (193003, 8.00);
        Car CarB = new Car (201605, 16.00);
        int input;
        
        input = Input.inputInt("Whatever");
        
        CarA.pay(193505, 10.00);
        
        System.out.print("The price is = " + CarA.calculatePrice());
    }
}
