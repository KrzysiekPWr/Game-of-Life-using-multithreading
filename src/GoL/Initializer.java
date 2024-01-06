package GoL;

import java.util.ArrayList;
import java.util.Random;

public class Initializer {
    public static Cell[][] initializeGrid(ArrayList<String> config){
        int gridWidth = Integer.parseInt(config.get(0));
        int gridLength = Integer.parseInt(config.get(1));
        Cell[][] grid = new Cell[gridLength][gridWidth];

        for (int i = 3; i < (config.size()); i++) {
            String[] coordinates = config.get(i).split(" ");
            int x = Integer.parseInt(coordinates[1]);
            int y = Integer.parseInt(coordinates[0]);
            grid[x][y] = new Cell(1, x, y);
        }

        for (int row = 0; row < gridLength; row++) {
            for (int col = 0; col < gridWidth; col++) {
                if(grid[row][col] == null){
                    grid[row][col] = new Cell(0, row, col);
                }
            }
        }

        return grid;
    }

    public static Cell[][] initializeGrid(int gridWidth, int gridLength, double density){
        Cell[][] grid = new Cell[gridLength][gridWidth];
        density = density/100;

        //INITIALIZE BY RANDOM VALUES
        for (int row = 0; row < gridLength; row++) {
            for (int col = 0; col < gridWidth; col++) {
                Random rand = new Random();
                double randomNum = rand.nextDouble();
                if(randomNum <= density){
                    grid[row][col] = new Cell(1, row, col);
                }
                else{
                    grid[row][col] = new Cell(0, row, col);
                }
            }
        }
        return grid;
    }

}
