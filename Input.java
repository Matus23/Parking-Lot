import java.util.Scanner;
import javax.swing.JOptionPane;

public class Input
{
    private static Scanner javaInput = new Scanner (System.in); 
                                                                 
    public static int inputInt (String s) {
        System.out.print(s);
        return Integer.parseInt(javaInput.nextLine().trim()); 
    }
    
    public static double inputDouble (String s) {
        System.out.print(s);
        return Double.parseDouble(javaInput.nextLine().trim());
    }
    
    public static String inputString (String s) {
        System.out.print(s);
        return javaInput.nextLine();
    }
    
    public static int JOptionPaneInt (String message) {
        String valueString = JOptionPane.showInputDialog(null, message , "Input", JOptionPane.PLAIN_MESSAGE);
        return Integer.parseInt(valueString.trim());
    }
    
    public static double JOptionPaneDouble (String message) {
        String valueString = JOptionPane.showInputDialog(null, message , "Input", JOptionPane.PLAIN_MESSAGE);
        return Double.parseDouble(valueString.trim());
    }
    
    public static String JOptionPaneString (String message) {
        String valueString = JOptionPane.showInputDialog(null, message, "Input", JOptionPane.PLAIN_MESSAGE);
        return valueString;
    }
}

