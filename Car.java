import java.util.Scanner;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car 
{
    private int entryDate;
    private double entryTime;
    public int endDate;
    public double endTime;
    private double price;
    public static int carNumber;
    
    public Car (int entryD, double entryT) {
        entryDate = entryD;
        entryTime = entryT; 
        price = calculatePrice();
    }
   
    public int getEntryDate() {
        return entryDate;
    }
    
    public double getEntryTime() {
        return entryTime;
    }
    
    public double getPrice() {
        return price;
    }
    
    private void setEndDate (int endD) {
        if (endD >= entryDate) 
            endDate = endD;
    }
    
    private void setEndTime (double endT) {
        if (endT > entryTime || endDate > entryDate) 
            endTime = endT;
    }
    
    public void setPrice (int p) {
        price = p;
    }
    
    public void pay (int endD, double endT) {
        setEndDate(endD);
        setEndTime(endT);       // pouzijeme accessor method set na ziskanie endDate a endTime
        price = calculatePrice();    // vypocitame si cenu potrebnu na zaplatenie, calculatePrice nepotrebuje parametre 
    }
    
    private static int minTime (double time) {
        int h = (int) time;
        int m = (int) (time-h)*100;
        int timeInMin = (h*60) + m;
        return timeInMin;
    }
    
    public double calculatePrice () {
        int entry = minTime(entryTime);
        int end = minTime(endTime);
        int time, halves, difInDays;
        if (entryDate == endDate && end > entry) {
            time = end - entry;
            halves = time/30;
            return halves*0.5;
        }
        else if (endDate > entryDate && end > entry) {
            difInDays = (endDate - entryDate)*24*60;
            time = end - entry + difInDays;
            halves = time/30;
            return halves*0.5;
        }
        
        else if (endDate > entryDate && end < entry) {
            difInDays = (endDate - entryDate)*24*60;
            time = difInDays-(entry-end);
            halves = time/30;
            return halves*0.5;
        }
        return 0;
    }
    
    public boolean canLeave (int currentDate, double currentTime) {
        int entryMin = minTime(entryTime);
        int currentMin = minTime(currentTime);
        int endMin = minTime(endTime);
        if (currentMin - endMin < 10 && endTime != 0) return true; 
        if (currentMin - entryMin < 30) return true;
        return false;
    }
    
    public static double timeSplit() {
        Calendar mojCalendar = Calendar.getInstance();
        String s = mojCalendar.getTime().toString();
        String[] parts = s.split(" ");
        parts = parts[3].split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour + minute/100.0;
    }
    
    public static int dateSplit() {
        Calendar mojCalendar = Calendar.getInstance();
        String s = mojCalendar.getTime().toString();
        String[] parts = s.split(" ");
        int date = Integer.parseInt(parts[2]);
        return date;
    }
}


