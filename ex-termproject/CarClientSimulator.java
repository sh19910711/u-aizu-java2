
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CarClientSimulator extends JFrame  
{
  JLabel client_title;
  JTextField name_field;
  JButton create_button;

  public CarClientSimulator() {
    // TODO
    client_title = new JLabel("Client Thread Name:");
    client_title.setSize(180, 24);
    client_title.setLocation(1, 1+24*0);

    name_field = new JTextField();
    name_field.setSize(180, 24);
    name_field.setLocation(1, 1+24*1);

    create_button = new JButton("Create");
    create_button.setSize(180, 24);
    create_button.setLocation(1, 1+24*2);
    create_button.addActionListener(new ButtonListener());

    setLayout(null);
    add(client_title);
    add(name_field);
    add(create_button);
  }

  class ButtonListener implements ActionListener { 
    public void actionPerformed(ActionEvent e) {
      String thread_title = name_field.getText();
      CarClientThread cct = new CarClientThread(thread_title);

      cct.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          System.exit(0);
        }
      });

      cct.setTitle("Car Client Thread");
      cct.setSize(500,300);
      cct.setVisible(true);
    }
  }

  public static void main (String args[]) {
    CarClientSimulator f = new CarClientSimulator();
    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {System.exit(0);}
    });

    f.setTitle("Car Client Simulator");
    f.setSize(200,150);
    f.setVisible(true);
  }
} // end of CarClientSimulator

class CarClientThread extends JFrame implements Runnable {
  String clientThreadName;
  int request_number = 0;
  EngineType et = null;
  private static CarRegistryServer crsvr = new CarRegistryServer();

  // TODO
  JButton startbutton;
  JTextArea contentsarea;
  JTextField numberOfRiders;
  Thread thread;

  public CarClientThread(String cname) {
    startbutton = new JButton("Create Thread&Start");
    contentsarea = new JTextArea(10,40);
    contentsarea.setCaretPosition(contentsarea.getDocument().getLength());  
    contentsarea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(contentsarea,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    // TODO
    setLayout(null);

    numberOfRiders = new JTextField();
    numberOfRiders.setSize(200, 40);
    numberOfRiders.setLocation(1 + 200, 1);

    startbutton.setSize(200, 40);
    startbutton.setLocation(1 + 200, 1 + 100);

    thread = new Thread(this);
    startbutton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("CarClientThread: start thread");
        et = EngineType.DIESEL_ENGINE;
        request_number = Integer.parseInt(numberOfRiders.getText());
        thread.start();
      }
    });

    contentsarea.setSize(600, 200);
    contentsarea.setLocation(1, 1 + 200);

    add(numberOfRiders);
    add(startbutton);
    add(contentsarea);
    add(scrollPane);

    setTitle("Car Client Thread");
    setSize(640, 480);
    setVisible(true);

  } // CarClientThread  constructor

  public void run() {
    // TODO: ............................
    System.out.println("CarClientThread#run");
    Random r = new Random((System.currentTimeMillis()));
    for(;;) {
      try {
        Thread.sleep( (int) (r.nextDouble() * 1000) );
        System.out.println("before request: " + request_number);
        Car cobj = crsvr.request(et,request_number);
        if(cobj == null) { 
          System.out.println("Error in finding suitable car");
          contentsarea.append("Error in finding suitable car\n");
          return;
        }
        // TODO: .......................
        contentsarea.append(new String(clientThreadName + ": I rent the next car ==> \n")); 
        contentsarea.append("         " + cobj.toString() + "\n"); 

        Thread.sleep( (int) (r.nextDouble() * 1000) );

        // TODO: .......................
        contentsarea.append(new String("[" + clientThreadName + "] After having used the next car, I get it back to the registry ==> \n")); 
        contentsarea.append("         " + cobj.toString() + "\n"); 

        crsvr.getback(cobj);
      } catch(InterruptedException e) {}
    }  // for loop

  } // end of run

  // TODO: ...........................

} // end of CarClientThread class

