import java.util.Scanner;

public class Main {

    public static int[] userInput = new int[2];
    public static String[][] gameGrid = {
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", " ", " "}
    };

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
            grid[coordinates[0] - 1][coordinates[1] - 1] = "X";
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter cells: ");
            String arr = scanner.nextLine().toUpperCase();
            int counter = 0;
            for (int i = 0; i < gameGrid.length; i++) {
                for (int j = 0; j < gameGrid[i].length; j++) {
                    String str = Character.toString(arr.charAt(counter));
                    String cell = str.equals("_") ? " " : str;
                    gameGrid[i][j] = cell;
                    counter++;
                }
            }

            display(gameGrid);
            promptUser();
            display(gameGrid);
        }
    }
}


