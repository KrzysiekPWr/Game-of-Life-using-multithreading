package GoL;

import java.util.ArrayList;
import java.util.Random;

public class Initializer {
    public static Cell[][] initializeGrid(ArrayList<String> config){
        int gridWidth = Integer.parseInt(config.get(0));
        int gridLength = Integer.parseInt(config.get(1));
        Cell[][] grid = new Cell[gridWidth][gridLength];

        for (int i = 3; i < (config.size()); i++) {
            String[] coordinates = config.get(i).split(" ");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            grid[x][y] = new Cell(1, x, y);
        }

        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridLength; j++) {
                if(grid[i][j] == null){
                    grid[i][j] = new Cell(0, i, j);
                }
            }
        }

        return grid;
    }

    public static Cell[][] initializeGrid(int gridWidth, int gridLength, double density){
        Cell[][] grid = new Cell[gridWidth][gridLength];
        density = density/100;

        //INITIALIZE BY RANDOM VALUES
        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridLength; j++) {
                Random rand = new Random();
                double randomNum = rand.nextDouble();
                if(randomNum < density){
                    grid[i][j] = new Cell(1, i, j);
                }
                else{
                    grid[i][j] = new Cell(0, i, j);
                }
            }
        }
        return grid;
    }

}
