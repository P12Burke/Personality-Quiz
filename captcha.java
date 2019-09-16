import javax.swing.*;
import java.awt.*;

public class captcha extends JFrame {
  
  public captcha() {
    
   //set properties of frame
    setTitle("CAPTCHA");
    setSize(600,400);
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setVisible(true);
    
  }
  
  //method for drawing captcha
  public void paint (Graphics g) {
    
    //repaints
    super.paint(g);
    //Graphics2D object
    Graphics2D g2 = (Graphics2D) g;
    ImageIcon imgCaptcha = new ImageIcon("newcaptcha.png");
    g2.drawImage(imgCaptcha.getImage(),80,120,this);
       
  } // end method paint
    
    
  ///////////////////////////test  

  public static void main (String [] args) {
    
    new captcha();
    
  } // end main method 
} // end public class captcha