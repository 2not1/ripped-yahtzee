import java.util.*;

import javax.xml.transform.Source;

public class rollDaDice {

    public static final int DICENUM = 5;
    public static void main(String[] args) {

        ArrayList<ArrayList<String>> setOfDice = defineDice();
        ArrayList<Integer> diceResult = new ArrayList<>();

        char playStatus = 'y';

        System.out.println("Do you want to roll the dice? y/n");

        int rollCount = 0;

        Scanner console = new Scanner(System.in);

        String response = console.next();


        while(response.equals( "y")) {
            
            diceResult = new ArrayList<>();

            for(int i = 0; i < DICENUM; i ++) {

            int result = rollDice();
        
            diceResult.add(result);
            }
            printDice(setOfDice, diceResult);

            drawLine();

            rollCount++;
            

            if(matchDice(diceResult) == true) {
                
                System.out.println("The dices match");

                System.out.println("You have rolled: " + rollCount + " times!");
                rollCount = 0;

                System.out.println("Do you want to keep rolling? y/n");

                response = console.next();
            } else {
                System.out.println("The dices don't match...");
            }

        }

    }

    public static ArrayList<ArrayList<String>> defineDice() {

        String border = " ------- ";
        String space = "|       |";
        String oneDotLeft = "| *     |";
        String oneDotMiddle = "|   *   |";
        String oneDotRight = "|     * |";
        String twoDots = "| *   * |";

        ArrayList<ArrayList<String>> setOfDice = new ArrayList<>();

        ArrayList<String> diceOne = new ArrayList<>();
        diceOne.add(border);
        diceOne.add(space);
        diceOne.add(oneDotMiddle);
        diceOne.add(space);
        diceOne.add(border);
        setOfDice.add(diceOne);

        ArrayList<String> diceTwo = new ArrayList<>();
        diceTwo.add(border);
        diceTwo.add(space);
        diceTwo.add(twoDots);
        diceTwo.add(space);
        diceTwo.add(border);
        setOfDice.add(diceTwo);

        ArrayList<String> diceThree = new ArrayList<>();
        diceThree.add(border);
        diceThree.add(oneDotLeft);
        diceThree.add(oneDotMiddle);
        diceThree.add(oneDotRight);
        diceThree.add(border);   
        setOfDice.add(diceThree); 

        ArrayList<String> diceFour = new ArrayList<>();
        diceFour.add(border);
        diceFour.add(twoDots);
        diceFour.add(space);
        diceFour.add(twoDots);
        diceFour.add(border);
        setOfDice.add(diceFour);

        ArrayList<String> diceFive = new ArrayList<>();
        diceFive.add(border);
        diceFive.add(twoDots);
        diceFive.add(oneDotMiddle);
        diceFive.add(twoDots);
        diceFive.add(border);
        setOfDice.add(diceFive);

        ArrayList<String> diceSix = new ArrayList<>();
        diceSix.add(border);
        diceSix.add(twoDots);
        diceSix.add(twoDots);
        diceSix.add(twoDots);
        diceSix.add(border);
        setOfDice.add(diceSix);

        return setOfDice;

    }

    public static int rollDice() {
        Random rand = new Random(); //instance of random class
      
        int upperbound = 6;
        //generate random values from 0-5
        int int_random = rand.nextInt(upperbound); 

      return int_random + 1;
    }
    
    public static void printDice(ArrayList<ArrayList<String>> setOfDice, ArrayList<Integer> resultSet) {
        
        for(int i = 0; i < setOfDice.get(0).size(); i++) {
            horizontal(setOfDice, resultSet, i);
            System.out.print("\n");
        }
    }
    private static void horizontal(ArrayList<ArrayList<String>> setOfDice, ArrayList<Integer> resultSet, int lineNumber) {
        
        for(int i = 0; i < resultSet.size(); i ++) {
        
        System.out.print(setOfDice.get(resultSet.get(i) - 1).get(lineNumber));
        System.out.print(" ");

        }
        
    }

    public static boolean matchDice(ArrayList<Integer> dice) {

        for(int i = 1; i < dice.size(); i ++) {
            if (dice.get(i) != dice.get(0)) {
                return false;
            } 
        }
        return true;
    }

    public static void drawLine() {
        System.out.println("--------------------------------------------------------");
    
    }
    
}
