/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botrecvm;

/**
 *
 * @author vvaisan
 */
public class MoveSensor {

    MoveSensor(Motor motor, Controller controller) {
            
    }
    //TODO 1:
    //Create private members Motor and Controller objects. 
    //Create constructor and set private members as parameter values (Associations)
    
    //TODO 3:
    //Create method buttonPressed()
    //The method calls stop() method of Motor object and buttonPressed() method of Controller object

    void buttonPressed() {
        Motor.stop();
        Controller.buttonPressed();
    }
      
}
