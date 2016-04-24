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
    //TODO 1: 
    //Create private member 'state' type int with initial value STOPPED (Use constants in Constants class)
    //Create constructor
    //In costructor because Motor inherits Java Observable class you can call method addObserver with parameter 'myobs' given in main
    
    //TODO 2: 
    //Create start method
    //Set state as RUNNING, call setChanged(), create Event object with 0 data (Event type EVENT_MOTOR_START) and
    //finally call notifyObservers((Object)event);
    
    //TODO 3: 
    //Create stopMotor method: Set state as STOPPED, then call setChanged() method, create Event object with 0 data and call notifyObservers((Object)event);
   
}
