import java.util.Scanner;
import java.util.Random;

public class Craps {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        boolean Cont = true;
        String Input = "";
        String Bad = "";
        //Main Game Loop
        do{
            int Die1 = rand.nextInt(6) + 1;
            int Die2 = rand.nextInt(6) + 1;
            int CrapsRoll = Die1 + Die2;
            Boolean Valid = false;
            int PointIs = 0;
            Boolean Point;
            System.out.println("--------------------------------");
            System.out.printf("%5s %10s %10s\n","Die1","Die2","Sum");
            System.out.printf("%5d %10d %10d\n",Die1,Die2,CrapsRoll);
            System.out.println("--------------------------------");
            //Crap Outs
            if(CrapsRoll == 2 || CrapsRoll == 3 || CrapsRoll == 12){
                System.out.println("You have Crapped out, Sadly you have lost!");
            }
            //Naturals
            else if (CrapsRoll == 7 || CrapsRoll == 11 ){
                System.out.println("You have rolled a natural " + CrapsRoll + " Congratulations!");
            }
            //Point Determination and Rolls
            else{
                PointIs = CrapsRoll;
                Point = false;
                System.out.println("The point is " + PointIs + ". Let's see if you can make it!");
                do{
                    Die1 = rand.nextInt(6) + 1;
                    Die2 = rand.nextInt(6) + 1;
                    CrapsRoll = Die1 + Die2;
                    System.out.println("--------------------------------------");
                    System.out.printf("%5s %10s %10s %10s\n","Die1","Die2","Sum","Point");
                    System.out.printf("%5d %10d %10d %10d\n",Die1,Die2,CrapsRoll,PointIs);
                    System.out.println("---------------------------------------");
                    if(CrapsRoll == PointIs){
                        System.out.println("You have made the point congratulations!");
                        Point = true;
                    }
                    else if(CrapsRoll == 7){
                        System.out.println("You didn't make the point, Sadly you have lost!");
                        Point = true;
                    }
                }while(!Point);
            }

            // User Continue Validation
            do{
                Valid = false;
                System.out.println("Would you like to play again? (Y/N)");
                Input = input.nextLine().toUpperCase();
                if (Input.equals("Y")){
                    Cont = true;
                    Valid = true;
                }
                else if (Input.equals("N")){
                    System.out.println("Thanks for playing Craps!");
                    Cont = false;
                    Valid = true;
                }
                else{
                    Bad = Input;
                    System.out.println("You have entered " + Bad);
                    System.out.println("Please enter a valid selection");
                    Valid = false;
                }
            }while(!Valid);

        }while(Cont);
    }
}