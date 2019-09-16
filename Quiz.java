import java.util.*;

public class Quiz{
  public static void main(String[]args){
    Scanner input=new Scanner(System.in);
    
   //import classes 
    Email e=new Email(); 
   
   //variables
    String previousEmail="hello";
    boolean valid1=false;//validate main menu screen choice
    boolean valid2=false;//validate email adress
    boolean valid3=false;//validate email password
    boolean email=true;
    int state=1;
    int choice=0;

  //login screen 


    
   
    while(email==true){//loops so the user can go to a previous menu, only exits when the user logs out of the email causing the 'email' variable to be set to false   
     if(state==1){//automatically start at the login screen 
       state=e.loginScreen();
       
      valid2=e.verifyEmailAdress(previousEmail);//previousEmail is the email adress that was entered at the end of the quiz
        while(valid2==false){//if it was a invalid choice keep prompting them for a valid one
           valid2=e.verifyEmailAdress(previousEmail);//use the method to verify it
         }
       valid3=e.verifyEmailPass();//
       while(valid3==false){//if it was a invalid choice keep prompting them for a valid one
          valid3=e.verifyEmailPass();
       }  
      state=e.emailMainMenu(); //after they succesfully login they are put into the main menu(change the screenstate==2)
       
     }//end of state 1
     
     else if(state==2){//main menu 
       choice=e.nextChoice();//prompt user for a choice(this is verified beforehand)
       if(choice==1){//if they choose '1' they are directed to the inbox
         state=e.inbox();//displays the inxox and changes the state to 3
       }
       else if(choice==2){//if they choose '2' they are directed to the spam inbox
         state=e.spam();//displays the spam inxox and changes the state to 4
       }
       else if(choice==3){//if they choose '3' they are directed to the logout screen/confirm that you want to logout 
         state=e.logout();//screen asking if they are sure they want to log out/ state to 5
       }
     }//end of state2
     else if(state==3){//if the progrms current state is 3 enter the statement 
        choice=e.nextChoice();//get another choice from the user and validate it 
        if(choice==1){//if '1' is entered go to email #1
         state=e.email1();
       }
       else if(choice==2){//same as above
         state=e.email2();
       }
       else if(choice==3){//same as above 
         state=e.email3();
       }
       else if(choice==4){//same as above
         state=e.email4(); 
       }
       else if(choice==5){//if '5' is selecred 
         state=e.emailMainMenu();//display the main menu and set the state back to 2
       }
     }
    else if(state==4){//spam(follows the same principle of int inbox[above])
        choice=e.nextChoice();//get another choice from the user and validate it 
        if(choice==1){
         state=e.spam1();//if '1' is entered go to spam email #1
       }
       else if(choice==2){
         state=e.spam2();
       }
       else if(choice==3){
         state=e.spam3();
       }
       else if(choice==4){//if the user inputs '4'
         state=e.emailMainMenu();//display the main menu and set the state back to 2
       }
     }
     else if(state==5){//logout sequence if the state is 5
         choice=e.nextChoice();//get another choice from the user and validate it( a 1 or 0)
         if(choice==1){//of a '1' is entered it confirms the exit and displays a thank you message
           System.out.println("\n\nThank you for playing");
           email=false; //exit the while loop
         }
         else if(choice==0){//if a 0 is entered 
           System.out.println("\n\n");
           state=e.emailMainMenu();//return back to the main menu and set the state to 2 
         }
     }
     else if(state>=6&&state<=12){//state of all emails
        choice=e.nextChoice();//get another choice from the user and validate it (can only enter a '1')
        if(choice==1){//allows user to get back to main menu from within an email
           state=e.emailMainMenu();
        }
     }
     
  }//end of email==true
     
  }}//end of program 
   
   
                 

