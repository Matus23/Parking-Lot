import java.util.Scanner;
import java.util.Random;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GUI extends JFrame implements ActionListener
{
    private String name;
    private int capacity;
    private Car[] places;
    private int numOfOccupied;
    private int[] numbers;
    
    private ImageIcon image1, image2; 
    private JLabel label1, label2;
    
    
    private JButton enter, pay, leave, clear, exit, display;
    private JTextField inputName, inputCapacity;
    private JTextArea area1;
    private JScrollPane panelName, panelCapacity;
    

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
            area1.setText("You can enter.");
            int number = getRandom();
            places[number] = new Car(Car.dateSplit(), Car.timeSplit());
            numbers[number] = number;
            area1.setText("You have entered the Parking. Your number is: " + number + "\n");
            numOfOccupied++;
        }
        else{
            area1.setText("The Parking is full.");
        }    
    }
    
    public void pay (int numOfCar) {
        try{
             places[numOfCar].pay(Input.JOptionPaneInt("Enter date when you leave: "), Input.JOptionPaneDouble("Enter time when you leave: "));
             area1.setText("You have paid  " + places[numOfCar].getPrice() + "$  You can leave now.");
             places[numOfCar].setPrice(0);
        }
        catch(NullPointerException npe){
             area1.setText("No such car in the ParkingLot.");
        }
        catch(ArrayIndexOutOfBoundsException aioobe){
             area1.setText("No such car in the ParkingLot.");
        }
    }
    
    public void leave (int numOfCar) {
         try{
           if (places[numOfCar] != null &&  places[numOfCar].canLeave(Input.JOptionPaneInt("Enter date when you leave: "), Input.JOptionPaneDouble("Enter time when you leave: "))) {
                places[numOfCar] = null;
                numOfOccupied--;
                area1.setText("You left the ParkingLot.");
            }
            else{
                area1.setText("You have to pay at first.");
            }
        }
        catch(NullPointerException npe){
            area1.setText("No such car in the ParkingLot.");
        }
        catch(ArrayIndexOutOfBoundsException aioobe){
            area1.setText("No such car in the ParkingLot.");
        }
    }
    
    public GUI (String heading, int c) {
        super(heading);
        setSize(1200,800);
        setLayout(null);
        
        /*
        setLayout(new FlowLayout());
        image1 = new ImageIcon(getClass().getResource("Brennta.jpg"));
        label1 = new JLabel(image1);
        add(label1);
        image2 = new ImageIcon(getClass().getResource("Brennta2.jpg"));
        label2 = new JLabel(image2);
        add(label2);
        */
        
        
        name = heading;
        capacity = c;
        numOfOccupied = 0;
        places = new Car[capacity];
        numbers = new int[capacity];
        
        
        // text area
        area1 = new JTextArea("");
        area1.setBounds(400, 150, 700, 500);
        add(area1);
        
        //panel
        panelName = new JScrollPane();
        panelName.setBounds(400,400, 500, 150);
        add(panelName);
        
        panelCapacity = new JScrollPane();
        panelCapacity.setBounds(400, 400, 500, 150);
        add(panelCapacity); 
        
        /*
        inputName = new JTextField("Som text field name");
        inputName.setBounds(400,400,500,150);
        add(inputName);
        
        inputCapacity = new JTextField("Som text field capacity");
        inputCapacity.setBounds(400, 400, 500, 150);
        add(inputCapacity);*/
        
        // buttons
        
        enter = new JButton("Enter");
        enter.setBounds(200,100,150,70);
        add(enter);
        
        pay = new JButton("Pay");
        pay.setBounds(200,200,150,70);
        add(pay);
        
        clear = new JButton("Clear");
        clear.setBounds(200, 300, 150, 70);
        add(clear);
        
        leave = new JButton("Leave");
        leave.setBounds(200, 400, 150,70);
        add(leave);
        
        display = new JButton("Display");
        display.setBounds(200,500, 150, 70);
        add(display);
        
        exit = new JButton("Exit");
        exit.setBounds(200, 600, 150, 70);
        add(exit);
        
        
        
        display.addActionListener(this);
        exit.addActionListener(this);
        clear.addActionListener(this);
        enter.addActionListener(this);
        pay.addActionListener(this);
        leave.addActionListener(this);
    }
    
    public void actionPerformed (ActionEvent action) {
        if (action.getSource() == enter) {
            enter();
        }
        else if (action.getSource() == pay) {
            pay(Input.JOptionPaneInt("Fill in number of your car"));
        }
        else if (action.getSource() == leave) {
            leave(Input.JOptionPaneInt("Fill in number of your car"));
        }
        else if (action.getSource() == clear) {
            area1.setText("");
        }
        else if (action.getSource() == display) {
            area1.setText("");
            for (int i =0; i<capacity; i++) {
                if (places[i] != null) {
                    area1.append("Number of your car is: " +  numbers[i] + ", date when you entered: " + places[i].getEntryDate() + ", time when you entered " + places[i].getEntryTime() + "\n");
                }
            }
        }
        else if (action.getSource() == exit) {
            System.exit(0);
        }
    }
   
    
    public static void main() {
        ParkingLot frame1 = new ParkingLot(Input.JOptionPaneString("Name of the parking lot"), Input.JOptionPaneInt("Capacity of the parking lot"));
        frame1.setVisible(true);
        frame1.setLocation(100,30);
        //frame1.pack();
    }
}
