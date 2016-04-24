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
public class Display extends Observable {
    public Display(Observer o) {
        this.addObserver(o);
    }
    public void show(float sum) {
        setChanged(); // the two methods of Observable class
        Event event = new Event(Constants.EVENT_SHOW_SUM,new Float(sum));
        notifyObservers((Object)event);
    }
}
