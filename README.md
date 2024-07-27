# Game-of-Life-using-multithreading

This project was study-related (3rd semester). My task was to write a simple ![John Conway's Game of Life](https:*en.wikipedia.org/wiki/Conway%27s_Game_of_Life)  implementation with GUI presentation form.

## Detailed info
*   To run the application user must provide run argumets such as:
    * | name_of_config_file | visualisation_type (gui/console) | number_of_threads |
    <br> <br>
    or
    <br><br>
    * | width_of_game_panel | height_of_game_panel | number_of_generations (number of simulation steps) | density_of_alive_cells | visualisation_type (gui or console) | number_of_threads |
*   The .txt config file **must** consist of (numbers are shown as a possible input):

    * 30 - a line with the width of the grid
    * 30 - a line with the height of the grid
    * 100 - a line with the number of generations to simulate
    * 3 - a line with the number of cells to be alive at the start
    * 0 0 - a line with the x and y coordinate of the first cell to be alive
    * 1 8 - a line with the x and y coordinate of the second cell to be alive
    * 24 13 - a line with the x and y coordinate of the third cell to be alive
    
*   The application GUI is written in Java Swing and is easily resizeable while running (I used a BufferedImage as a game panel)
*   The application is multithreaded (each thread processes different rows in the game panel)
*   Every single user input is validated by the application
*   There are additional files with some of the interesting structures that can be build in Conway's Game of Life already included by me in this project:
    * glider.txt
    * glider_gun.txt
    * oscillators.txt
    * still_lifes.txt  

## Quick Demo
https://github.com/user-attachments/assets/712ea857-d573-4c5d-b443-779845f0b039

