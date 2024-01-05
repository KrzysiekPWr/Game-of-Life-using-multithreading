package GoL;

import java.util.ArrayList;

public class Validator {
    public static boolean validateConfig(ArrayList<String> config){
        if(config == null){
            System.out.println("Config file does not exist");
            return false;
        }
        else if(config.size() < 4){
            System.out.println("Not enough arguments");
            return false;
        }
        else if(!config.get(0).matches("[0-9]+")){
            System.out.println("First config argument must be a number");
            return false;
        }
        else if(!config.get(1).matches("[0-9]+")){
            System.out.println("Second config argument must be a number");
            return false;
        }
        else if(!config.get(2).matches("[0-9]+")){
            System.out.println("Third config argument must be a number");
            return false;
        }
        for (int i = 3; i < config.size(); i++) {
            String[] coordinates = config.get(i).split(" ");
            if(!coordinates[0].matches("[0-9]+")){
                System.out.println("X coordinate in line " + (i+1) + " must be a number");
                return false;
            }
            else if(!coordinates[1].matches("[0-9]+")){
                System.out.println("Y coordinate in line " + (i+1) + " must be a number");
                return false;
            }
        }
        return true;
    }

    public static boolean validateArgs(String[] args){
        if(args.length < 3 || args.length > 6){
            System.out.println("Invalid number of arguments");
            return false;
        }
        else if(args.length == 3){
            return checkFileConfig(args);
        }
        else if (args.length == 6){
            return checkInlineConfig(args);
        }
        return true;
    }

    private static boolean checkInlineConfig(String[] args) {
        for (int i = 0; i < 1; i++) {
            if(!args[i].matches("[0-9]+")){
                System.out.println("Invalid grid size");
                return false;
            }
        }

        if(!args[2].matches("[0-9]+")) {
            System.out.println("Invalid number of generations");
            return false;
        }
        if (!isValidDensity(args[3])){
            System.out.println("Invalid density");
            return false;
        }
        else if (!args[4].matches("gui|console")){
            System.out.println("Invalid visualization type");
            return false;
        }
        else if (!args[5].matches("[0-9]+")){
            System.out.println("Invalid number of threads");
            return false;
        }
        return true;
    }


    private static boolean checkFileConfig(String[] args){
        if(!args[0].matches(".+\\.txt")){
            System.out.println("Invalid config file path");
            return false;
        }
        else if (!args[1].matches("gui|console")){
            System.out.println("Invalid visualization type");
            return false;
        }
        else if (!args[2].matches("[0-9]+")){
            System.out.println("Invalid number of threads");
            return false;
        }
        return true;
    }
    private static boolean isValidDensity(String density) {
        if(!density.matches("[0-9]+")){
            return false;
        }
        else if (Integer.parseInt(density) < 0 || Integer.parseInt(density) > 100){
            return false;
        }
        return true;
    }



}
