package GoL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConfigInterpreter {
    public static ArrayList<String> pullConfigFromFile(String configFileName) {
        ArrayList<String> config = new ArrayList<>();

        File configFile = new File(configFileName);
        //check if file exists
        if (!configFile.exists()) {
            return null;
        } else {
            try {
                Scanner fileScanner = new Scanner(configFile);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    config.add(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                System.exit(112);
            }
        }
        return config;
    }
    //the config file consists of:
    // 30 - a line with the width of the grid
    // 30 - a line with the height of the grid
    // 100 - a line with the number of generations to simulate
    // 3 - a line with the number of cells to be alive at the start
    // 0 0 - a line with the x and y coordinate of the first cell to be alive
    // 1 8 - a line with the x and y coordinate of the second cell to be alive
    // 24 13 - a line with the x and y coordinate of the third cell to be alive
}
