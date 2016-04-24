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
public class Printer extends Observable {
       public Printer(Observer o) {
        this.addObserver(o);
    }
    public void printTicket(float sum) {
        setChanged(); // the two methods of Observable class
        Event event = new botrecvm.Event(Constants.EVENT_PRINT_TICKET,new Float(sum));
        notifyObservers((Object)event);
    }

}
