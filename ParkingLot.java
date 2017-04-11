import java.util.Scanner;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class ParkingLot extends JFrame
{
    private String name;
    private int capacity;
    private Car[] places;
    private int numOfOccupied;
    private int[] numbers;
    
    private JButton enter, pay, leave, clear, exit, display;
    private JTextField inputName, inputCapacity;
    private JTextArea area1;
    private JScrollPane panelName, panelCapacity;
    
    public ParkingLot (String s, int c) {
        name = s;
        capacity = c;
        numOfOccupied = 0;
        places = new Car[capacity];
        numbers = new int[capacity];
    }

    public int getRandom()
    {
        int random;
        do {
            random = new Random().nextInt(places.length);
        } while (places[random] != null);
        return random;
    }
    
    public void enter() {
        if(numOfOccupied < capacity) {
            System.out.println("You can enter.");
            int number = getRandom();
            numbers[number] = number;
            System.out.println("Your number is: " + number);
            numOfOccupied++;
            places[number] = new Car(Input.inputInt("Enter date: "), Input.inputDouble("Enter time: "));
            
        }
        else{
            System.out.println("The Parking is full.");
        }    
    }
    
    public void pay (int numOfCar) {
        try{
            places[numOfCar].pay(Input.inputInt("Enter date when you leave: "), Input.inputDouble("Enter time when you leave: "));
            places[numOfCar].setPrice(0);
            System.out.println("You have paid. You can leave now");
            }
        catch(NullPointerException npe){
           System.out.println("No such car in the ParkingLot.");
        }
        catch(ArrayIndexOutOfBoundsException aioobe){
            System.out.println("No such car in the ParkingLot.");
        }
    }
    
    public void leave (int numOfCar) {
         try{
            if(places[numOfCar] != null && places[numOfCar].canLeave(Input.inputInt("Enter date when you leave: "), Input.inputDouble("Enter time when you leave: "))) {           
                places[numOfCar] = null;
                numOfOccupied--;
                System.out.println("You left the ParkingLot.");
            }
            else{
                System.out.println("You have to pay at first.");
            }
        }
        catch(NullPointerException npe){
            System.out.println("No such car in the ParkingLot.");
        }
        catch(ArrayIndexOutOfBoundsException aioobe){
            System.out.println("No such car in the ParkingLot.");
        }
    }
    
    
    public void menu() {
        int input;
        do {
            input = Input.inputInt("Choose an option from the menu: ");
            
            if (input == 1) {
                enter(); 
            }
            
            else if (input == 2) {
                leave(Input.inputInt("Fill in a number of your car: "));
            }
            
            else if (input == 3) {
                pay(Input.inputInt("Fill in a number of your car: "));
            }
            
            else if (input == 4) {
                for (int i=0; i<capacity; i++) {
                    if (places[i] != null) 
                        System.out.println(i + " : " + places[i].toString());
                }
            }   
            
            else if (input == 5) {
                System.out.println("Exit");
            }
            
            else {
                System.out.println("You have filled in a wrong option: ");
            }
        } while (input != 5);
    } 
   
    
    public static void main() {
        ParkingLot frame1 = new ParkingLot(Input.JOptionPaneString("Name of the parking lot"), Input.JOptionPaneInt("Capacity of the parking lot"));
        frame1.setVisible(true);
        frame1.setLocation(100,30);
    }
}
