import java.util.Scanner;
import java.util.Random;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        //Creates new Scanner object
        Scanner s = new Scanner(System.in);
        //Creates new Board object
        Board b = new Board();
        
        //Win booleans
        boolean winX = false;
        boolean winO = false;
        //Counts number of turns taken
        int turnCounter = 0;
        //Sets the first turn
        char turn = firstTurn();
        //Initializes input character
        char in;

        //Calls title() method
        title();
        //Sleep thread for 2.5 seconds
        Thread.sleep(2500);
        //Draw the board to the console
        b.draw();

        //Main game loop
        do
        {
            //Input validation loop
            do
            {
                //Initial prompt
                System.out.printf("Choose an open space 1-9 to place your %C.\n", turn);

                //While the user hasn't entered an integer, continue prompting
                while (!s.hasNextInt())
                {
                    //Secondary prompt
                    System.out.println("Please enter a valid integer.");
                    //Keep scanner open for next input
                    s.next();
                } //while(not int)

                //Sets 'in' to the entered number
                in = (char) ('0' + s.nextInt());
                
            } //do while(not valid space)
            while (!b.placeChar(turn, in));

            //Check if the current player has won
            if (b.checkWin(turn))
            {
                //Checks whether 'X' or 'O' won
                if (turn == 'X')
                {
                    winX = true;
                } //if('X')
                else
                {
                    winO = true;
                } //if('O')
            } //if(won)

            //Draw the board to the console
            b.draw();
            //Increment turnCounter
            turnCounter++;
            //Flip turn between 'X' and 'O'
            turn = flipTurn(turn);

        } //do while(no winner and less than 9 turns taken)
        while ((!winX && !winO) && (turnCounter < 9));

        //Checks which exit condition was activated and prints the corresponding message
        if (winO)
        {
            System.out.println("Congratulations, O! You win!");
        } //if('O' won)
        else if (winX)
        {
            System.out.println("Congratulations, X! You win!");
        } //if('X' won)
        else if (turnCounter == 9)
        {
            System.out.println("It's a draw! Nobody wins.");
        } //if(draw)

        s.close();
    } //main()
    
    //Method title(). Prints title and author.
    static void title()
    {
        //Block of print statements that display the title message
        System.out.println("|=-=-=-=-=-=-=-==-=-=-=-=-=-=-=|");
        System.out.println("|=-=-=-=- Tic-Tac-Toe! -=-=-=-=|");
        System.out.println("|=-=-=-=- Java Edition -=-=-=-=|");
        System.out.println("|=-=- Made by earthToAlice -=-=|");
        System.out.println("|=-=-=-=-=-=-=-==-=-=-=-=-=-=-=|");

        //Separator line between title and the rest of the game
        System.out.println("\n- - - - - - - - - - - - - - - - -");

    } //title()

    //Method firstTurn(). Randomly chooses 'X' or 'O' and returns it to the 'turn' variable.
    static char firstTurn()
    {
        //Creates new Random object
        Random r = new Random();

        //Checks if random int is 0
        if (r.nextInt(2) == 0)
        {
            return 'X';
        } //if(0)
        else
        {
            return 'O';
        } //if(1)
    } //firstTurn()

    static char flipTurn(char turn)
    {
        //Checks if turn is 'X' or 'O'
        if (turn == 'X')
        {
            return 'O';
        } //if('X')
        else
        {
            return 'X';
        } //if('O')
    } //flipTurn(turn)

} //Main