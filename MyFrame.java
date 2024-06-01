 
package digital.clock;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MyFrame extends JFrame{
    
    Calendar calendar;
    SimpleDateFormat timeformat;
    SimpleDateFormat dayformat;
    JLabel timelabel;
    JLabel daylabel;
    String time;
    String day;
    
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Digital Clock");
        this.setLayout(new FlowLayout());
        // default window size
        this.setSize(400,200);
        // make true if you want to resize
        this.setResizable(false);
        
        // Check out Java SimpleDateFormat's to change the display formats
        timeformat = new SimpleDateFormat("hh:mm:ss a");
        dayformat = new SimpleDateFormat("EEEE");

        timelabel = new JLabel();
        timelabel.setFont(new Font("Verdana",Font.PLAIN,55));
        timelabel.setForeground(new Color(0x010000));
        timelabel.setBackground(new Color(0x86b685));
        timelabel.setOpaque(true);
        
        daylabel = new JLabel();
        daylabel.setFont(new Font("Verdana",Font.PLAIN,35));
        
        
        this.add(timelabel);
        this.add(daylabel);
        this.setVisible(true);
        
        setTime();
    }
    
    public void setTime(){
        
        while(true){
        time = timeformat.format(Calendar.getInstance().getTime());
        timelabel.setText(time);
        day = dayformat.format(Calendar.getInstance().getTime());
        daylabel.setText(day);
        
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }



}
