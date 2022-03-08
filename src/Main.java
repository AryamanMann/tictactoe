import java.util.Scanner;

public class Main {

    public static int[] userInput = new int[2];
    public static String[][] gameGrid = {
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", " ", " "}
    };
    public static String userChar = "X";
    public static int count = 0;
    public static void display(String[][] grid) {
        System.out.println("---------");
        System.out.println("| " + grid[0][0] + " " + grid[0][1] + " " + grid[0][2] + " |");
        System.out.println("| " + grid[1][0] + " " + grid[1][1] + " " + grid[1][2] + " |");
        System.out.println("| " + grid[2][0] + " " + grid[2][1] + " " + grid[2][2] + " |");
        System.out.println("---------");
    }

    public static void promptUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the coordinates: ");
        try {
            userInput[0] = scanner.nextInt();
            userInput[1] = scanner.nextInt();
            if (userInput[0] > 3 || userInput[0] < 1 || userInput[1] > 3 || userInput[1] < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                promptUser();
            } else {
                putChar(gameGrid, userInput);
            }
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            promptUser();
        }
        scanner.close();
    }

    public static void putChar(String[][] grid, int[] coordinates) {
        if (!grid[coordinates[0] - 1][coordinates[1] - 1].equals(" ")) {
            System.out.println("The cell is occupied! Choose another one!");
            promptUser();
        } else {
            grid[coordinates[0] - 1][coordinates[1] - 1] = userChar;
            count();
            display(gameGrid);
        }
        switch (userChar) {
            case "X" -> userChar = "O";
            case "O" -> userChar = "X";
        }
        if (count == 9 && !checkWinnerO() && !checkWinnerX()) {
            System.out.println("Draw");
        } else if (checkWinnerO()) {
            System.out.println("O wins");
        } else if (checkWinnerX()) {
            System.out.println("X wins");
        } else {
            promptUser();
        }
    }

    public static void count() {
        count++;
    }

    public static boolean checkWinnerX() {
        boolean isWinnerX = gameGrid[0][0].equals("X") && gameGrid[0][0].equals(gameGrid[1][1]) && gameGrid[1][1].equals(gameGrid[2][2]);
        if (gameGrid[0][2].equals("X") && gameGrid[0][2].equals(gameGrid[1][1]) && gameGrid[1][1].equals(gameGrid[2][0])) isWinnerX = true;
        int rowCounterX = 0;
        int colCounterX = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                boolean rowEqualX = gameGrid[i][j].equals("X") && gameGrid[i][(j + 1)].equals("X");
                boolean colEqualX = gameGrid[j][i].equals("X") && gameGrid[(j + 1)][i].equals("X");
                rowCounterX = rowEqualX ? rowCounterX + 1 : 0;
                colCounterX = colEqualX ? colCounterX + 1 : 0;
                if (rowCounterX == 2 || colCounterX == 2) {
                    isWinnerX = true;
                    break;
                }
            }
        }
        return isWinnerX;
    }

    public static boolean checkWinnerO() {
        boolean isWinnerO = gameGrid[0][0].equals("O") && gameGrid[0][0].equals(gameGrid[1][1]) && gameGrid[1][1].equals(gameGrid[2][2]);
        if (gameGrid[0][2].equals("O") && gameGrid[0][2].equals(gameGrid[1][1]) && gameGrid[1][1].equals(gameGrid[2][0])) isWinnerO = true;
        int rowCounterO = 0;
        int colCounterO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                boolean rowEqualO = gameGrid[i][j].equals("O") && gameGrid[i][(j + 1)].equals("O");
                boolean colEqualO = gameGrid[j][i].equals("O") && gameGrid[(j + 1)][i].equals("O");
                rowCounterO = rowEqualO ? rowCounterO + 1 : 0;
                colCounterO = colEqualO ? colCounterO + 1 : 0;
                if (rowCounterO == 2 || colCounterO == 2) {
                    isWinnerO = true;
                    break;
                }
            }
        }
        return isWinnerO;
    }

    public static void main(String[] args) {
        display(gameGrid);
        promptUser();
    }
}




