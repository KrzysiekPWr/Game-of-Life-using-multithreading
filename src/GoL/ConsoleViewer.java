package GoL;

public class ConsoleViewer {
    public static void printGrid(Cell[][] grid){
        for (int i = 0; i < grid.length; i++) {
            System.out.print("|");
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j].getState() == 1){
                    System.out.print("X");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
    }
}
