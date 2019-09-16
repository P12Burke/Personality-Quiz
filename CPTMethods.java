import java.util.*;
import javax.swing.*;
import java.awt.*;

public class CPTMethods extends JFrame{
  
  public Random rnd = new Random();
  public int quizChoice;
  public int getChoice;
  public boolean human;
  public int a1;
  public int a2;
  public int a3;
  public int a4;
  public int a5;
  public int a6;
  public int sum;
  public int[] getTotal=new int[6];
  public int addUp;
  Scanner s = new Scanner(System.in);
  
  ////method for pressing any key
  public void pressAnyKey() {
    
    try {
     System.in.read(); 
    } 
    catch(Exception a) {}
    
  } // end method pressAnyKey
      
  //method for captcha
  public void captcha() {
    
     ImageIcon imgCaptcha = new ImageIcon("newcaptcha.png");
     new captcha();
    
  } // end method captcha
  
  ////method for quiz choice
  public void qChoice() {
  
    System.out.print("Hello ! Welcome to our program !");
    System.out.print("\nYou will be asked to answer a series of questions, whether you want to or not");
    System.out.print("\n... because there's no way to exit yet");
    System.out.print("\n----------------------------------------------------------------------------");
    System.out.print("\n Press any key to continue: \n");
    pressAnyKey();
    System.out.print("Good ! As long as you are able to press keys, you can pass these questions");
    System.out.print("\n...there is literally no way to mess up");
    System.out.print("\n(If you do though, then congrats you broke the program)");
    System.out.print("\n----------------------------------------------------------------------------");   
    System.out.print("\nBut first, you need to prove you are human! Press any key to continue.");
    System.out.print("\n----------------------------------------------------------------------------\n");
    s.next();
    System.out.print("\nPlease complete this captcha\n");
    captcha();
    s.next();
    System.out.print("\nYeah, we don't know either. We don't care. Now, onto the quiz! Press any key.\n");
    s.next();
    System.out.print("----------------------------------------------------------------------------\n");
  } // end qChoice
  
  
  
    //method for answer choices
  public int getChoice() {
    boolean check = false;
    try{
      getChoice = s.nextInt();
      while (check = false) {
        if (getChoice<1 || getChoice>6) {
         System.out.print("\nEnter a valid number?"); 
        } else {
         check = true; 
        }
      }
    }
    catch(InputMismatchException a) {
     System.out.print("\nEnter a valid number !");
     s.next();
    }
     return getChoice;
  } // end method getChoice
  
  
  
  public int[] getTotal(int x) {
    
    if (getChoice == 1) {
      getTotal[x]=5;
    }
    else if (getChoice == 2) {
      getTotal[x]=10;
    }
    else if (getChoice == 3) {
      getTotal[x]=15;
    }
    else if (getChoice == 4) {
      getTotal[x]=20;
    }
    else if (getChoice == 5) {
     getTotal[x]=25;
    }
    else if (getChoice == 6) {
     getTotal[x]=30;
    }
    else{ 
      
    }
    return getTotal; 
    
  }// end method getTotal
  
  
  //method for quiz 1
  public void QuizOne() {
    
    System.out.print("------------  BEGIN QUIZ  ------------");
    System.out.print("\nWhat is your favorite kind of pizza?");
    System.out.print("\n1. Pepperoni\t\t2. Cheese\n3. Hawaiian\t\t4. Canadian\n5.I don't like pizza\t\t6.I'm lactose intolerant\n");
    getChoice();
    getTotal(0);
    System.out.print("\nWhat is your favorite color?");
    System.out.print("\n1. Blue\t\t2. Red\n3. Pink\t\t4. Green\n5.I'm color blind\t6.I see the world in monochrome\n");
    getChoice();
    getTotal(1);
    System.out.print("\nWhat kind of music do you like?");
    System.out.print("\n1. Rock\t\t2. Classical\n3. R&B\t\t4. Indie\n5.I hate music\t6.I'm deaf and you offended me\n");
    getChoice();
    getTotal(2);
    System.out.print("\nWhat is your favorite flavour?");
    System.out.print("\n1. Sweet\t\t2. Salty\n3. Sour\t\t4. Bitter\n5.Sticky (ew)\t6.I'm a robot I don't need food\n");
    getChoice();
    getTotal(3);
    System.out.print("\nWhat is your best trait?");
    System.out.print("\n1. Face\t\t2. Personality\n3. Wealth\t\t4. Brain\n5. Body\t6.Eyebrows\n");
    getChoice();
    getTotal(4);
    System.out.print("\nWhat bird are you?");
    System.out.print("\n1. Pidgeon\t\t2. Ostritch\n3. Flamingo\t\t4. Owl\n5. Eagle\t6.Pelican\n");
    getChoice();
    getTotal(5);
    
  } // end method QuizOne
  
  /////////////////////////////////////  DETERMINING RESULTS ///////////////////////////////////////////
  public int sum(){
    for(int x=0; x<=getTotal.length; x++){
      sum = sum + getTotal[x]; 
    }
    return sum;
  }
  
  
  public void result() {
    if (sum>=5 && sum<=60) {
     System.out.print("\nYou are Jimmie. \n- big\n- falls asleep on the couch watching tv");
    }
    //do these other ones
    //Rachel - nihilistic - cannot face the reality of death
    //Paul  - eats cereal and milk seperately - cannot do math
    //Wanda - killed a man once - uses the internet a lot
    //Mark - has a fear of being alone - loves memes - hates new age indie memes;
    // Henry - always is screaming - always eat - lots of eat
    // Dark Jimmie - bathes in the blood of the innocent - lactose intolerant
    // Helen - spends a lot of money - is very poor - still spend money
    // Joshua - smells weird - but is still a good and caring freind

    
    
  } // end method result
  ///////////////////////////////////////////////////////
  public static void main (String [] args) {
    
    CPTMethods cpt = new CPTMethods();
    cpt.qChoice();
    cpt.QuizOne();
    cpt.result();
    
  } // end main method
} // end CPTMethods