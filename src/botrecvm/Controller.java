package botrecvm;

import java.util.Observable;
import java.util.Observer;
import static javax.swing.Spring.sum;

public class Controller {

    
    //TODO1:
    //Create private members: sum (float), Display and Printer object members (Associations)
    private float sum;
    Display display = null;
    Printer print = null;
    
    //Create constructor (Observer as parameter)
    
    //In costructor create display and printer objects (private members above), give observer as parameter
    Controller(MyObserver myobs) {
        display = new Display(myobs);
        print = new Printer(myobs);
    }
    
    //TODO 3: 
    //Create buttonPressed() method: Set sum as zero and call printTicket method (printer object)
    void buttonPressed() {
        sum = 0;
        private void printTicket(sum);
    }
    
    //TODO 2:
    //Create bottleAdded() method (bottle as parameters type int)
    //Check the value of bottle parameter: 20  --> 0.2f, 15  --> 0.15f or 30  --> 0.3f (Or then INVALID)
    //Add the value to the sum and call show() method of display object (sum as parameter)
    public void bottleAdded(int bottle){
        float value = 0.0f;
        switch(coin){
            case 20: value = 0.20f;
            break;
            case 15: vlaue = 0.15f;
            break;
            case 30: value = 0.30f;
            break;
            default: value = Constants.INVALID;
        }
        
        show(value);
    }
}
