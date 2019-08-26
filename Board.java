class Board
{
    //Creates 2D char array of 3 rows and 3 columns
    char[][] grid = new char[3][3];

    /**Constructor Board(). When new Board obj is created, populate grid[][] with 1-9.**/
    public Board()
    {
        //Counter variable that increments by 1 with every iteration
        int c = 0;

        //Iterates through grid[][]
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                //Assigns grid[i][j] to number characters 1-9
                grid[i][j] = (char) ('1' + c);
                //Increments counter
                c++;

            } //for(j)

        } //for(i)

    } //constructor Board()

    /**Method draw(). Prints grid[][] to the console in an organized fashion.**/
    public void draw()
    {
        //Prints top horizontal line
        System.out.println("\n|=-=|=-=|=-=|");
        //Iterates through grid[][]
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                //Prints horizontal line with numbers in row
                System.out.print("| " + grid[i][j] + " ");

            } //for(j)

            //Prints end "|", then goes down a line and prints a horizontal line
            System.out.println("|\n|=-=|=-=|=-=|");

        } //for(i)
        //Creates a space
        System.out.print("\n");
    } //draw()

    /**Method placeChar(char turn, char gridNum). Places the character of turn ('X' or 'O') in the grid space that corresponds with gridNum. Returns true if successful, returns false if unsuccesful.**/
    public boolean placeChar(char turn, char gridNum)
    {
        //Iterates through grid[][]
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                //Checks if grid[i][j] and input gridNum are the same
                if (gridNum == grid[i][j])
                {
                    //Assigns grid[i][j] the input value of turn
                    grid[i][j] = turn;
                    //Returns true because the input was valid
                    return true;

                } //if(matching grid num)

            } //for(j)

        } //for(i)

        //Returns false if gridNum doesn't match anything
        return false;

    } //placeChar(turn, gridNum)

    //Method checkWin(char checkFor). Iterates through grid[][] to see if 'checkFor' has won
    public boolean checkWin(char checkFor)
    {
        //number of 'X's in column
        int colCount = 0;
        //number of 'X's in row
        int rowCount = 0;
        //number of 'X's in downwards diagonal
        int downDiagCount = 0;
        //number of 'X's in upwards diagonal
        int upDiagCount = 0;

        //Iterates through grid[][] and adds to counters when it finds corresponding chars to 'checkFor'
        for (int i = 0; i < 3; i++)
        {
            //Resets counters
            colCount = 0;
            rowCount = 0;
            downDiagCount = 0;
            upDiagCount = 0;

            for (int j = 0; j < 3; j++)
            {
                //Checks for matching char in column
                colCount = (grid[j][i] == checkFor) ? colCount + 1 : 0;
                if (colCount == 3) return true;

                //Checks for matching char in row
                rowCount = (grid[i][j] == checkFor) ? rowCount + 1 : 0;
                if (rowCount == 3) return true;

                //Checks for matching char in downwards diagonal
                downDiagCount = (grid[j][j] == checkFor) ? downDiagCount + 1 : 0;
                if (downDiagCount == 3) return true;

                //Checks for matching char in upwards diagonal
                upDiagCount = (grid[2-j][j] == checkFor) ? upDiagCount + 1 : 0;
                if (upDiagCount == 3) return true;
            } //for(j)
        } //for(i)

        //Returns false if 'checkFor' hasn't won
        return false;
        
    } //checkWin()
} //Board