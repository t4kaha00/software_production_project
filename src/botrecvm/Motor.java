/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botrecvm;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author vvaisan
 */
public class Motor extends Observable {

    static void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static void stop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //TODO 1: 
    //Create private member 'state' type int with initial value STOPPED (Use constants in Constants class)
    
    private int state;
    //Create constructor
    public Motor(Observable o) {
        Observer myobs = null;
        this.addObserver(myobs);
        
    }
    //In costructor because Motor inherits Java Observable class you can call method addObserver with parameter 'myobs' given in main

    Motor(MyObserver myobs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //TODO 2: 
    //Create start method
    //Set state as RUNNING, call setChanged(), create Event object with 0 data (Event type EVENT_MOTOR_START) and
    //finally call notifyObservers((Object)event);
    public void start(int state){
        setChanged();
        Event event = new Event(Constants.EVENT_MOTOR_START);
        notifyObservers((Object)event);
        
    }
    
    //TODO 3: 
    //Create stopMotor method: Set state as STOPPED, then call setChanged() method, create Event object with 0 data and call notifyObservers((Object)event);
    public void stopMotor(){
        
        setChanged();
        Event event = new Event(Constants.EVENT_MOTOR_STOP);
        notifyObservers((Object)event);
        
    }
   
}
