package GoL;

public class Cell {
    private int state;
    private final int x;
    private final int y;
    private int neighbors;
    public Cell(int state, int x, int y){
        this.state = state;
        this.x = x;
        this.y = y;
        this.neighbors = 0;
    }

    public void countNeighbours(){
        int neighbors_temp = 0;
        Cell[][] grid = Simulator.getGrid();
        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                if ((i == 0) && (j == 0)){
                    continue;
                }
                int rowLength = grid.length;
                int colLength = grid[0].length;
                int column = (x + i + rowLength) % rowLength;
                int row = (y + j + colLength) % colLength;
                if(grid[column][row].state == 1){
                    neighbors_temp++;
                }
            }
        }
        neighbors = neighbors_temp;
    }

    public void evaluateNeighbors() {
        if (state == 1){
            if (neighbors < 2 || neighbors > 3) {
                state = 0;
            }
        }
        else{
            if (neighbors == 3) {
                state = 1;
            }
        }
    }
    public int getState(){
        return this.state;
    }
}
