package GoL;

public class ConsoleViewer {
    public static void printGrid(Cell[][] grid){
        System.out.println("+" + "-".repeat(grid[0].length) + "+");
        for (int row = 0; row < grid.length; row++) {
            System.out.print("|");
            for (int col = 0; col < grid[0].length; col++) {
                if(grid[row][col].getState() == 1){
                    System.out.print("X");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        System.out.println("+" + "-".repeat(grid[0].length) + "+");
    }
}
