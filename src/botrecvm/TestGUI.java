/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botrecvm;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;

public class TestGUI {
    public static void main(String [] args) {
        new TestGUI().start();
    }
    private void start() {
        MainWindow m = new MainWindow();
     }
} // ExampleAppStarter

class MainWindow implements Observer, ActionListener {
    private JLabel label;
    private JButton stopButton;        
    private JButton smallButton;
    private JButton bigButton;
    private JButton canButton;
    private JButton conveyor;
    private JLabel title;
    private JLabel ticket;
    JFrame frame;
    JLabel ctext;
    String place;
    JPanel titlePanel;

     Motor motor = new Motor(this);  
    Controller controller = new Controller(this);
    LightSensor lightSensor = new LightSensor(motor, controller);
    MoveSensor moveSensor = new MoveSensor(motor, controller);

    @Override // Observer interface's implemented method
    public void update(Observable o, Object data) {
        Event event = (Event)data;
        switch(event.getType()) {
            case Constants.EVENT_MOTOR_START:  conveyor.setText((String)"     RUNNING");
            ctext.setHorizontalAlignment(CENTER);
            ticket.setText("<html><body><br>Empty!");
                frame.validate();
                frame.repaint();
                break;
            case Constants.EVENT_MOTOR_STOP:  conveyor.setText((String)"     STOPPED");
            ctext.setHorizontalAlignment(CENTER);
                frame.validate();
                frame.repaint();
                break;
            case Constants.EVENT_SHOW_SUM: 
                float euros = (float)event.getData();
                //String mystr = Float.toString(euros);
                String.format("%.2f",euros);
                title.setText("<html><body><br>Sum:<br> " + String.format("%.2f",euros) + "e" );
                title.setHorizontalAlignment(CENTER);
                frame.repaint();
                break;
            case Constants.EVENT_PRINT_TICKET: 
                lightSensor.setFirst();
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                euros = (float)event.getData();
                place = "Prisma Limingatulli";
                ticket.setText("<html><body>Place: " + place + "<br>Date: " + dateFormat.format(date) + "<br>Sum: " + String.format("%.2f",euros) + "e<br>Thank you!");
                frame.repaint();
                break;
       }
    }
    MainWindow() {	
        frame = new JFrame("Main Window");
        frame.getRootPane().setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20));
         frame.setPreferredSize(new Dimension(300, 200));
         frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
         stopButton = new JButton(new ImageIcon("press.png"));        
         smallButton = new JButton(new ImageIcon("small.png"));
         bigButton = new JButton(new ImageIcon("big.png"));
         canButton = new JButton(new ImageIcon("can.png"));
         JButton arrowLButton = new JButton(new ImageIcon("arrowLeft.jpg"));
         arrowLButton.setEnabled(false);
         JButton arrowRButton = new JButton(new ImageIcon("arrowRight.jpg"));
         arrowRButton.setEnabled(false);
 
         JLabel label1 = new JLabel("20 cents"); 
         String text = "    STOPPED";
         conveyor = new JButton(new ImageIcon("conveyor.png"));
         conveyor.setText("STOPPED");
         ctext = new JLabel(text, CENTER);
         Font dispFont = new Font("Tahoma", Font.BOLD, 22);
         Font ticketFont = new Font("Tahoma", Font.BOLD, 12);

         titlePanel = new JPanel();
         float sum = 0.0f;
         title = new JLabel("<html><body><br>Sum:<br> " + sum + "e");
         title.setFont(dispFont);
         title.setForeground(Color.YELLOW);
         titlePanel.setBackground(Color.blue);
         titlePanel.add(title);
 
         JPanel ticketPanel = new JPanel();
          
         ticket = new JLabel("<html><body><br>Empty!");
         ticket.setFont(ticketFont);
         ticket.setForeground(Color.BLACK);
         ticketPanel.add(ticket);
         ticketPanel.setBorder(BorderFactory.createLineBorder(Color.black));

         smallButton.addActionListener(this);
         smallButton.setText("20");
         canButton.addActionListener(this);
         canButton.setText("15");
         bigButton.addActionListener(this);
         bigButton.setText("30");
         stopButton.addActionListener(this);
         stopButton.setText("Ready");
         
         conveyor.setEnabled(false);
         GridLayout grid = new GridLayout(0,3);
         frame.setLayout(grid);
         frame.add(smallButton);
         frame.add(bigButton);
         frame.add(canButton);
         frame.add(conveyor);
         frame.add(titlePanel);
         frame.add(stopButton);
         frame.add(arrowRButton);
         frame.add(ticketPanel);
         frame.add(arrowLButton);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(700, 400);
         frame.setLocation(200, 200);
         frame.setVisible(true);
    }
     public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String str = button.getText();
            if(str == "Ready")
            {
              moveSensor.buttonPressed();

            }
            else {
                int value = Integer.parseInt(str);
                lightSensor.checkBottle(value);
            }
        }

} // MainWindow
