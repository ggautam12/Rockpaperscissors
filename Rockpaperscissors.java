//Gautam Gudavalli
//CIS 3090.01
//Project 1 
import java.util.Scanner;
import java.util.Random;
public class RockPaperScissorsGame 
{
   public static void main (String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      String computer, user;
      char keepPlaying;
      do  {
         computer = computerChoice();
         user = userChoice();
         System.out.println("The computer's choice was " + computer);
         System.out.println("The user's choice was " + user);
         determineWinner(computer, user);
         while (computer.equals(user)) {
            computer = computerChoice();
            user = userChoice();
            System.out.println("The computer's choice was " + computer);
            System.out.println("The user's choice was " + user);
            determineWinner(computer, user);
         }
         System.out.println("\n" + "Play again? (y/n)");
         keepPlaying = keyboard.nextLine().toLowerCase().charAt(0);
         while ( keepPlaying != 'y' && keepPlaying != 'n' )
         {
            System.out.println("Invalid input, please enter (y/n)");
            keepPlaying = keyboard.nextLine().toLowerCase().charAt(0);
         }
      } while (keepPlaying == 'y');
   }
   public static String computerChoice() {
      String[] choice = {"rock","paper","scissors"};
      Random rand = new Random();
      int computerChoice = rand.nextInt(3);
      return choice[computerChoice];
   }
   public static String userChoice() {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Enter rock, paper, or scissors: ");
      String choice = keyboard.nextLine();
      isValidChoice(choice);
      return choice;
   }
   public static boolean isValidChoice (String choice) {
      Scanner keyboard = new Scanner(System.in);
      while (!(choice.equalsIgnoreCase("rock")) && !(choice.equalsIgnoreCase("paper")) && !(choice.equalsIgnoreCase("scissors")))
    {
       System.out.print("Invalid input, enter rock, paper, or scissors: ");
       choice = keyboard.nextLine();
    }
       return true;
    }
    public static void determineWinner(String computer, String user) {
       if (computer.equalsIgnoreCase("rock") && user.equalsIgnoreCase("paper"))
          System.out.println("\n" + "Paper wraps rock.\nThe user wins!");
       else if (computer.equalsIgnoreCase("rock") && user.equalsIgnoreCase("scissors"))
          System.out.println("\n" + "Rock smashes scissors.\nThe computer wins!");
       else if (computer.equalsIgnoreCase("paper") && user.equalsIgnoreCase("rock"))
          System.out.println("\n" + "Paper wraps rock.\nThe computer wins!");
       else if (computer.equalsIgnoreCase("paper") && user.equalsIgnoreCase("scissors"))
          System.out.println("\n" + "Scissors cuts paper.\nThe user wins!");
       else if (computer.equalsIgnoreCase("scissors") && user.equalsIgnoreCase("rock"))
          System.out.println("\n" + "Rock smashes scissors.\nThe user wins!");
       else if (computer.equalsIgnoreCase("scissors") && user.equalsIgnoreCase("paper"))
          System.out.println("\n" + "Scissors cuts paper.\nThe computer wins!");
       else if (computer.equalsIgnoreCase(user))
          System.out.println("\n" + "The game is tied!\nGet ready to play again...");
    }   
}