import java.util.*;

public class Email{
  Scanner input=new Scanner(System.in);
  
/*
legend for what screen matches what screenstate

screenstate....

1=login screen
2=main menu
3=inbox menu
4=spam menu
5=logout menu

6=inbox message #1
7=inbox message #2
8=inbox message #3
9=inbox message #4

10=spam message #1
11=spam message#2
12=spam message#3
  
 
 
 
 */
  public int screenState;//keep track where the user is in the program 
  public String email;//store email user inputs
  public String password;//store password user inputs
  public int choice;//store the choice the user inputs(the result will differ depending on the screenstate)
  public boolean  valid1=false;//for screen choice
  public boolean valid2=false;//verify email adress
  public boolean valid3=false;//verify email password
  
  
  public int screenChoice;
  
  public int getChoice(){//used to make sure the choice the user inputs is an int 
    try{//get user to input an int
     screenChoice=input.nextInt();
    }
    catch(InputMismatchException e){//if anthign other than an int is inputed, it prompts to input another int 
      input.next();
    }
    return screenChoice;//is the int the user inputed 
    
  }
  
  public boolean validateScreenChoice(){//see if the choice the user makes[from getChoice()] is a vailid one, based on the screen they are currently on
    if(screenState==2 && choice>0 && choice<4){//for main menu to see that it is a valid choice 
       valid1=true;
       }  
    else if(screenState==3 && choice>0 && choice<6){//for inbox menu to see that they select a valid email or option 
       valid1=true;
       }  
    else if(screenState==4 && choice>0 && choice<6){//for spam menu to see that they select a valid email or option
       valid1=true;
      }   
    else if(screenState>=6 && screenState<=12 && choice==1){//so only you can choose to return to the main menu in an email
       valid1=true;
      }   
   else if(screenState==5 && (choice==1||choice==0)){//the choices avalable on the logout screen 
       valid1=true;
      }   
    else{
      valid1=false;//if what the user has inputted does not match any valid option return a false value 
       }
    return valid1;
  }
  
  public int nextChoice(){
      choice=getChoice();//prompt to get an int, and make sure it is an int(try/catch)
      validateScreenChoice();//make sure the int actually corrosponds to a valid choice
    while(valid1==false){//if it is not a valid choice make the user reinput a choice untill a valid one shows up 
      System.out.println("enter a valid choice");
       choice=getChoice();
      validateScreenChoice();
    }
    
    valid1=false;
    return choice;//return the valid choice to the main method 
   }
  
  
  public int loginScreen(){
    System.out.println("enter email adress");
    email=input.next();//promt user to input their email
    System.out.println("enter password");
    password=input.next();//prompt user to input their password(can be anything that is 5-10 chars long)
    screenState=1;
    return screenState;    
  }
  
     public boolean verifyEmailAdress(String previousEmail){
       if(email.equals(previousEmail)){//if the email==the previouly entered one...
         valid2=true; //make the validator true
       }
       else{
         valid2=false; //keep the value of the validator false
         System.out.println("your email is incorrect");
         email=input.next();//if it wasnt the correct email prompt them to re-enter a new one 
       }
       return valid2;//return the result of the validility of the email they entered 
     }
   
     public boolean verifyEmailPass(){
       if(password.matches("(.{5,10})")){//make sure the password they enter has between 5 and 10 characters
         valid3=true; //if it follows the criteria make the password a valid one
       }
       else{
         valid3=false; //make the validility false
         System.out.println("your password is incorrect(5-10 characters)");
         password=input.next();//prompt for a new one
      }
       return valid3;
     }
  
  public int emailMainMenu(){//displays options avalble on the main menu 
   System.out.println("\n\n\n-----------------------------------------");
   System.out.println("\t\tMain Menu");
   System.out.println("-----------------------------------------");
    System.out.println("\nWelcome to your email please select an option:\n");
    System.out.printf("%-10s%15s","Inbox","1\n");
    System.out.printf("%-10s%15s","Spam","2\n");
    System.out.printf("%-10s%15s","Log Out","3\n");
    screenState=2;//keeps track of where the program is
    return screenState;
  }
  
  int spam(){//display the diffrent messages in the spam inbox 
   System.out.println("\n\n\n---------------------------------------");
   System.out.println("\t\tSpam");
   System.out.println("---------------------------------------");
   System.out.println("\n1.You’ve been chosen!!! ");
   System.out.println("2. YOU HAVE UNPAID TAXES!!!!!");
   System.out.println("3. OMG! 143 Million Americans Didn't Expect This....");
   System.out.println("\n\n4. To Exit To Email Main Menu");
   screenState=4;//keep track as to where the program is 
   return screenState;
    
  }
  int inbox(){//displays the messages in the inbox
      System.out.println("\n\n\n---------------------------------------");
   System.out.println("\t\tInbox");
   System.out.println("---------------------------------------");
   System.out.println("\n\nSelect message(1-4)");
   System.out.println("1. Your quiz results");
   System.out.println("2. Canada Post-package Confirmation");
   System.out.println("3. Reddit-Confirmation of account");
   System.out.println("4. CIBC-Suspected Credit Fraud");
   System.out.println("\n\n5. To Exit To Email Main Menu\n\n");
   screenState=3;//keep track as to where the program is 
    return screenState;
  }
  
  int logout(){//displays the message as to if the user is SURE to exit the program/email
   System.out.println("\n\nare you sure you want to logout?(0=No, 1=Yes)\n");
   screenState=5;//keep track as to where the program is 
    return screenState;
  }
  

  
//text and message of the emails(just the actual text that is displayed in the actual emails)
  
  public int email1(){//email #1(quiz results) 
    System.out.println("\n\n\n----------------------------------------------------------------");
    System.out.println("Subject:Your Quiz Results are In!! ");
    System.out.println("----------------------------------------------------------------  ");
    screenState=6;
    return screenState;
  }
  
  public int email2(){//email #2 (about a package)
    System.out.println("\n\n\n----------------------------------------------------------------");
    System.out.println("Subject:Canada Post-package Confirmation  ");
    System.out.println("----------------------------------------------------------------  ");
    System.out.println("This email is to confirm we have recived your package and it is in transit to it's desintation    ");
    System.out.println("Ship To:  ");
    System.out.println("   H&L Returns  ");
    System.out.println("   568 Main Street  ");
    System.out.println("   Mississauga ON  L6W 4L2  ");
    System.out.println("   CANADA  ");
    System.out.println("Service Type: Expedited Parcels  ");
    System.out.println("Delivery Standard:  June 26, 2017  ");
    System.out.println("\n\n1. To Exit To Email Main Menu\n\n");
    screenState=7;
    return screenState;
  }
  
  public int email3(){// email #3 (about a confirmation of a Reddit account)
    System.out.println("\n\n\n----------------------------------------------------------------");
    System.out.println("Subject:Reddit-Confirmation of account  ");
    System.out.println("----------------------------------------------------------------  ");
    
    System.out.println("\n\n1. To Exit To Email Main Menu\n\n");
    screenState=8;
    return screenState;
  }
  
  public int email4(){//email #4 (about a suspended credit card)
    System.out.println("\n\n\n----------------------------------------------------------------");
    System.out.println("Subject:CIBC-Suspected Credit Fraud  ");
    System.out.println("----------------------------------------------------------------  ");
    
    System.out.println("\n\n1. To Exit To Email Main Menu\n\n");
    screenState=9;
    return screenState;
  }
  
    public int spam1(){// spam email #1 (about 'winning' something)
    System.out.println("\n\n\n----------------------------------------------------------------");
    System.out.println("Subject: You’ve been chosen!!!  ");
    System.out.println("----------------------------------------------------------------  ");
    
    System.out.println("\n\n1. To Exit To Email Main Menu\n\n");
    screenState=10;
    return screenState;
  }
    
    public int spam2(){// spam email #2 (about having unpaid taxes to the CRA)
    System.out.println("\n\n\n----------------------------------------------------------------");
    System.out.println("Subject:YOU HAVE UNPAID TAXES!!!!!  ");
    System.out.println("----------------------------------------------------------------  ");
    
    System.out.println("\n\n1. To Exit To Email Main Menu\n\n");
    screenState=11;
    return screenState;
  }
    
    public int spam3(){//spam email #3 (clickbait)
    System.out.println("\n\n\n----------------------------------------------------------------");
    System.out.println("Subject:OMG! 143 Million Americans Didn't Expect This....  ");
    System.out.println("----------------------------------------------------------------  ");
    
    System.out.println("\n\n1. To Exit To Email Main Menu\n\n");
    screenState=12;
    return screenState;
  }
 
}//end of class
