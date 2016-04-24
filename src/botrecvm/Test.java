package botrecvm;

import java.io.Console;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class Test {
   private static Scanner reader = new Scanner(System.in);
   public static void main(String[] args) {
      MyObserver myobs = new MyObserver();
      Motor motor = new Motor(myobs);  
      Controller controller = new Controller(myobs);
      LightSensor lightSensor = new LightSensor(motor, controller);
      MoveSensor moveSensor = new MoveSensor(motor, controller);

      int answer = Menu();
      while (answer != 9) {
            switch (answer) {
                case 1:
                     System.out.println("\nGive bottle: small(20), big(30), can(30)");
                    int bottle = reader.nextInt();
                    lightSensor.checkBottle(bottle);
                     break;
                case 2:
                    moveSensor.buttonPressed();
                     break;
                case 9:
            }
            answer = Menu();
        }
    }

    public static int Menu() {
        int answer = 0;
        System.out.println("\n********** MENU ************");
        System.out.println("1. Enter bottle");
        System.out.println("2. Press button");
        System.out.println("9. Quit");
        answer = reader.nextInt();
        return (answer);
    }
}
