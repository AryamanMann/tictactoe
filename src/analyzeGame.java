import java.util.Scanner;
public class analyzeGame {

    static String[][] grid = new String[3][3];
    static String arr;
    static final char elementX = 'X';
    static final char elementO = 'O';
    static boolean winnerX;
    static boolean winnerO;

    public static void main(String[] args) {
        printGrid();
        winnerX = checkWinnerX();
        winnerO = checkWinnerO();
        boolean impossible = checkImpossible();
        boolean spacesOrUnderscores = checkSpaces();

        if (!impossible) {
            if (spacesOrUnderscores && !winnerO && !winnerX) System.out.print("Game not finished");
            if (!spacesOrUnderscores && !winnerO && !winnerX) System.out.print("Draw");
            if (winnerX) {
                System.out.print("X wins");
            } else if (winnerO) {
                System.out.print("O wins");
            }
        } else {
            System.out.print("Impossible");
        }
    }

    public static void printGrid() {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter cells: ");
            arr = scanner.next().toUpperCase();
            int counter = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] = Character.toString(arr.charAt(counter));
                    counter++;
                }
            }
            System.out.println("---------");
            System.out.println("| " + grid[0][0] + " " + grid[0][1] + " " + grid[0][2] + " |");
            System.out.println("| " + grid[1][0] + " " + grid[1][1] + " " + grid[1][2] + " |");
            System.out.println("| " + grid[2][0] + " " + grid[2][1] + " " + grid[2][2] + " |");
            System.out.println("---------");
        }
    }

    public static boolean checkWinnerX() {
        boolean isWinnerX = false;
        if (grid[0][0].equals("X") && grid[0][0].equals(grid[1][1]) && grid[1][1].equals(grid[2][2])) isWinnerX = true;
        if (grid[0][2].equals("X") && grid[0][2].equals(grid[1][1]) && grid[1][1].equals(grid[2][0])) isWinnerX = true;
        int rowCounterX = 0;
        int colCounterX = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                boolean rowEqualX = grid[i][j].equals("X") && grid[i][(j + 1)].equals("X");
                boolean colEqualX = grid[j][i].equals("X") && grid[(j + 1)][i].equals("X");
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
        boolean isWinnerO = false;
        if (grid[0][0].equals("O") && grid[0][0].equals(grid[1][1]) && grid[1][1].equals(grid[2][2])) isWinnerO = true;
        if (grid[0][2].equals("O") && grid[0][2].equals(grid[1][1]) && grid[1][1].equals(grid[2][0])) isWinnerO = true;
        int rowCounterO = 0;
        int colCounterO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                boolean rowEqualO = grid[i][j].equals("O") && grid[i][(j + 1)].equals("O");
                boolean colEqualO = grid[j][i].equals("O") && grid[(j + 1)][i].equals("O");
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

    public static boolean checkImpossible() {
        boolean isImpossible = false;
        int countX = 0;
        int countO = 0;
        if (winnerO && winnerX) isImpossible = true;
        for (int i = 0; i < arr.length(); i++) {
            if (arr.charAt(i) == elementX) countX++;
            if (arr.charAt(i) == elementO) countO++;
        }
        if (countO - countX >= 2 || countX - countO >= 2) isImpossible = true;
        return isImpossible;
    }

    public static boolean checkSpaces() {
        return arr.contains(" ") || arr.contains("_");
    }
}



