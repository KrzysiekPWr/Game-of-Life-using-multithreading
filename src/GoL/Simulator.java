package GoL;

import GUI.GUIViewer;
import java.util.ArrayList;
import java.util.Objects;

public class Simulator {
    private static Cell[][] grid;
    private static ArrayList<String> config;
    private static int numberOfThreads;
    private static String visualType;
    private static int numberOfGenerations;
    private static GUIViewer viewer;
    public static void startSimulation(String[] args) {
        //args: config.txt gui 16
        //args: 100 100 1000 40 console 16

        if(!Validator.validateArgs(args)){
            return;
        }
        else {
             prepareSimulation(args);
        }

        //create the viewer if user chose gui
        if(Objects.equals(visualType, "gui")){
            viewer = new GUIViewer();
        }

        //start the simulation
        for (int generation = 0; generation < numberOfGenerations; generation++) {

            ThreadsHandler.createThreads(grid.length, grid[0].length, numberOfThreads);

            if (visualType.equals("gui")) {
                viewer.update();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ThreadsHandler.startThreads();
            }
            else if (visualType.equals("console")) {
                System.out.println("Generation: " + generation);
                ConsoleViewer.printGrid(grid);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ThreadsHandler.startThreads();
            }
        }
    }

    private static void prepareSimulation(String[] args) {
        if(args.length == 3){
            config = ConfigInterpreter.pullConfigFromFile(args[0]);
            if(!Validator.validateConfig(config)){
                System.exit(69);
            }
            numberOfGenerations = Integer.parseInt(config.get(2));
            numberOfThreads = Integer.parseInt(args[2]);
            visualType = args[1];
            grid = Initializer.initializeGrid(config);
        }
        else if (args.length == 6){
            numberOfThreads = Integer.parseInt(args[5]);
            int gridWidth = Integer.parseInt(args[0]);
            int gridLength = Integer.parseInt(args[1]);
            int density = Integer.parseInt(args[3]);
            numberOfGenerations = Integer.parseInt(args[2]);
            visualType = args[4];
            grid = Initializer.initializeGrid(gridWidth, gridLength, density);
        }
    }

    public static Cell[][] getGrid(){
        return grid;
    }
}
