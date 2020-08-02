import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cells = "_________";

        System.out.println("---------");
        System.out.println("| " + cells.charAt(0) + " " + cells.charAt(1) + " " + cells.charAt(2) + " |");
        System.out.println("| " + cells.charAt(3) + " " + cells.charAt(4) + " " + cells.charAt(5) + " |");
        System.out.println("| " + cells.charAt(6) + " " + cells.charAt(7) + " " + cells.charAt(8) + " |");
        System.out.println("---------");    // blank game board

        char[][] charCells = new char [3][3]; // create array
        int charNum = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                charCells[i][j] = cells.charAt(charNum);   // convert blank board to array
                charNum++;
            }
        }

        int checkCon = 0;
        int[][] ttt = new int[3][3];            // int array (needed to check the conditions of victory)
        int sum = 0;

        String solution = "Game not finished";


        while (checkCon != 1) {    // big while loop: each player move and checking all conditions
            int x = 0;
            int y = 0;
            boolean intCheck = true;

            while (intCheck) {  // loop to input coordinates of X char.
                try {           // using try statement to check if the input is a number. Catch: when its not number
                    System.out.print("Enter the coordinates: ");
                    x = sc.nextInt();                           // input first coordinate;
                    y = sc.nextInt();                           // input second coordinate;
                    if (x > 3 || y > 3 || x == 0 || y == 0) {   // check if both input > 3
                         System.out.println ("Coordinates should be from 1 to 3!");
                         continue;
                    }
                    if (charCells[3 - y][x - 1] == '_') {       // check if place on the board is empty
                        charCells[3 - y][x - 1] = 'X';
                        intCheck = false;
                        break;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!"); //result: while it's occupied
                    }

                } catch (InputMismatchException e) {
                    System.out.println("You should enter numbers!"); //result: while the input number is not a number
                }
            } // loop ends when input is correct

            System.out.println("---------");
            System.out.println("| " + charCells[0][0] + " " + charCells[0][1] + " " + charCells[0][2] + " |");
            System.out.println("| " + charCells[1][0] + " " + charCells[1][1] + " " + charCells[1][2] + " |");
            System.out.println("| " + charCells[2][0] + " " + charCells[2][1] + " " + charCells[2][2] + " |");
            System.out.println("---------"); // print board with our input (X) and previous inputs

            for (int i = 0; i < 3; i++) {       // convert char array to int array (result: numbers in array)
                for (int j = 0; j < 3; j++) {
                    ttt[i][j] = charCells[i][j];
                }
            }

            for (int i = 0; i < 3; i++) {       // winning condititon for X: row
                if (ttt[i][0] + ttt[i][1] + ttt[i][2] == 264) {
                    solution = "X wins";
                    checkCon = 1;
                }
            }

            for (int j = 0; j < 3; j++) {       // winning condititon for X: column
                if (ttt[0][j] + ttt[1][j] + ttt[2][j] == 264) {
                    solution = "X wins";
                    checkCon = 1;
                }
            }

            if (ttt[0][0] + ttt[1][1] + ttt[2][2] == 264) {     // winning condititon for X: cross
                solution = "X wins";
                checkCon = 1;
            } else if (ttt[0][2] + ttt[1][1] + ttt[2][0] == 264) {
                solution = "X wins";
                checkCon = 1;
            }

            sum = 0;                                //sum to check draw condititon
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sum += ttt[i][j];
                }
            }

            for (int i = 0; i < 3; i++) {               // draw condititon: sum of all array elements
                for (int j = 0; j < 3; j++) {
                    if (ttt[i][j] != 95 && sum == 756 && checkCon == 0) {
                        solution = "Draw";
                        checkCon = 1;
                    }
                }
            }

            if (checkCon == 1) {                 // when the winning condition for X is reached: BREAK loop
                break;
            }

            int a = 0;
            int b = 0;
            intCheck = true;

            while (intCheck) {              // big while loop: each player move and checking all conditions: as for X
                try {
                    System.out.print("Enter the coordinates: ");
                    a = sc.nextInt();
                    b = sc.nextInt();
                    if (a > 3 || b > 3 || a == 0 || b == 0) {
                        System.out.println ("Coordinates should be from 1 to 3!");
                        continue;
                    }
                    if (charCells[3 - b][a - 1] == '_') {
                        charCells[3 - b][a - 1] = 'O';
                        intCheck = false;
                        break;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("You should enter numbers!");
                }
            }

            System.out.println("---------");
            System.out.println("| " + charCells[0][0] + " " + charCells[0][1] + " " + charCells[0][2] + " |");
            System.out.println("| " + charCells[1][0] + " " + charCells[1][1] + " " + charCells[1][2] + " |");
            System.out.println("| " + charCells[2][0] + " " + charCells[2][1] + " " + charCells[2][2] + " |");
            System.out.println("---------");    // print board with our input(O) and previous inputs

            for (int i = 0; i < 3; i++) {               // convert char array to int array (result: numbers in array)
                for (int j = 0; j < 3; j++) {
                    ttt[i][j] = charCells[i][j];
                }
            }

            for (int i = 0; i < 3; i++) {               // winning condititon for O: row
                if (ttt[i][0] + ttt[i][1] + ttt[i][2] == 237) {
                    solution = "O wins";
                    checkCon = 1;
                }
            }

            for (int j = 0; j < 3; j++) {               // winning condititon for O: column
                if (ttt[0][j] + ttt[1][j] + ttt[2][j] == 237) {
                    solution = "O wins";
                    checkCon = 1;
                }
            }

            if (ttt[0][0] + ttt[1][1] + ttt[2][2] == 237) {     // // winning condititon for O: cross
                checkCon = 1;
                solution = "O wins";
            } else if (ttt[0][2] + ttt[1][1] + ttt[2][0] == 237) {
                checkCon = 1;
                solution = "O wins";
            }

            sum = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sum += ttt[i][j];
                }
            }

            for (int i = 0; i < 3; i++) {               // draw condititon: sum of all array elements
                for (int j = 0; j < 3; j++) {
                    if (ttt[i][j] != 95 && sum == 756 && checkCon == 0) {
                        solution = "Draw";
                        checkCon = 1;
                    }
                }
            }
            if (checkCon == 1) {                // when the winning condition for O is reached: BREAK loop
                break;
            }
        }
        System.out.println(solution);       // OUTPUT: information on who won or draw
    }
}