/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botrecvm;

import java.util.Observer;

/**
 *
 * @author vvaisan
 */
public class LightSensor {
    //TODO 1:
    //Create private members for Motor and Controller objects. Also Boolean type member first (Init as true, This to know if the bottle was first)
    
    Motor motor = null;
    Controller controller = null;
    
    //Create constructor (Parameters Motor and Controller objects)
    public LightSensor(Observer o){
        motor = new Motor(o);
        
    }
    //In costructor set associations (set private member values as parameter object as value)

    LightSensor(Motor motor, Controller controller) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    //TODO 2: 
    //Create checkBottle method (bottle as parameter, type int)
    //Check if it was 1st bottle (member first)
    //If first then call start() method of object motor
    //Set first as false
    //Call bottleAdded method of Controller object (bottle as parameter)
    
    public void checkBottle(){
        int bottle;
        boolean first = false;
        if (first == true){
            Motor.start(){
                first = false;
                Controller.bottleAdded(o);
        }else{
        setFirst();}   
        }
    }
 
    public void setFirst() {
        this.first = true;
    }

    void checkBottle(int bottle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
