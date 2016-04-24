package botrecvm;

import java.io.Console;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class MyObserver implements Observer {
     public void update(Observable o, Object data) {
        Event event = (Event)data;
        switch(event.getType()) {
            case Constants.EVENT_MOTOR_START: System.out.println("\nMotor started...");
                break;
            case Constants.EVENT_MOTOR_STOP: System.out.println("\nMotor stopped...");
                break;
            case Constants.EVENT_PRINT_TICKET: 
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                float euros = (float)event.getData();   
                System.out.println("\nPrisma Limingatulli, \nDate: " + dateFormat.format(date) + "\nSum: " + euros + "e \nThank you!"); 
                break;
            case Constants.EVENT_SHOW_SUM: euros = (float)event.getData();              
                    System.out.println("\nTotal: " + euros +  " euros");
        }
    }
}