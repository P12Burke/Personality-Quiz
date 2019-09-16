import java.util.*;

public class Universal{
  Scanner input=new Scanner(System.in);
   public int screenChoice;
  
  public int getChoice(){
    try{//try catch to make sure it is an int
     screenChoice=input.nextInt();
    }
    catch(InputMismatchException e){
      System.out.println("enter a valid choice");
      input.next();
    }
    return screenChoice;
    
  }
  
}
