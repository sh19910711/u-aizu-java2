     // Dialog Box
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

............................

       }

       class ButtonListener implements ActionListener { 
        public void actionPerformed(ActionEvent e) {
           String thread_title = name_field.getText();
           CarClientThread cct = new CarClientThread(thread_title);

           cct.addWindowListener(new WindowAdapter() {
             public void windowClosing(WindowEvent e) {System.exit(0);}
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
          
          .........................
      

       public CarClientThread(String cname) {
	    startbutton = new JButton("Create Thread&Start");
            contentsarea = new JTextArea(10,40);
	    contentsarea.setCaretPosition(contentsarea.getDocument().getLength());  
	    contentsarea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(contentsarea,
		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
..........................

        } // CarClientThread  constructor

        public void run() {
............................
         Random r = new Random((System.currentTimeMillis()));
         for(;;) {
          try {
            Thread.sleep( (int) (r.nextDouble() * 1000) );
            Car cobj = crsvr.request(et,request_number);
            if(cobj == null) { 
               System.out.println("Error in finding suitable car");
               contentsarea.append("Error in finding suitable car\n");
	       return;
            }
.......................
            contentsarea.append(new String(clientThreadName + ": I rent the next car ==> \n")); 
            contentsarea.append("         " + cobj.toString() + "\n"); 

            Thread.sleep( (int) (r.nextDouble() * 1000) );

.......................
            contentsarea.append(new String("[" + clientThreadName + "] After having used the next car, I get it back to the registry ==> \n")); 
            contentsarea.append("         " + cobj.toString() + "\n"); 

            crsvr.getback(cobj);
         } catch(InterruptedException e) {}
        }  // for loop

       } // end of run

...........................

     } // end of CarClientThread class
     
