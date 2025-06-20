package rockpaperscissor;
import java.util.*;
class game{
    public static void main(String []args){
        Scanner sc= new Scanner(System.in);

        String [] choices = {"rock", "paper", "scissor"};
        String userchoice, computerchoice;

        String playagain  = "yes";
        Random r = new Random();


        do { 
            System.out.println("enter a choice");



        userchoice = sc.nextLine().toLowerCase();



        if(!userchoice.equals("rock") &&
        !userchoice.equals("paper") &&
        !userchoice.equals("scissor")){
            System.out.println("INvalid choice");
            continue;
        }


        computerchoice = choices[r.nextInt(3)];
        System.out.println(computerchoice);


        if (userchoice.equals(computerchoice)) {
            System.out.print("its a tie");
            
        }
        else if ((userchoice.equals("rock")&&computerchoice.equals("paper")) ||
        (userchoice.equals("paper") && computerchoice.equals("scissor"))||
        (userchoice.equals("scissor") && computerchoice.equals("rock"))){
            System.out.println("you lost");
            


        }
        else{
            System.out.println("you won");

        }
        System.out.println("want to play again");


        playagain = sc.nextLine();
        } while (playagain.equals("yes"));



        System.out.println("thanks for playing");




















        



    }
}