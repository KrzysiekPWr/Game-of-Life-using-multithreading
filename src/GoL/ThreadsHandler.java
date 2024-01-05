package GoL;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class ThreadsHandler {
    static ArrayList<Thread> countThreads = new ArrayList<>();
    static ArrayList<Thread> writeThreads = new ArrayList<>();
    static CountDownLatch countLatch;
    static CountDownLatch writeLatch;

    public static void createThreads(int gridHeight, int gridWidth, int threadCount){
        if (threadCount > gridHeight) {
          threadCount = gridHeight;
        }
        int minRowsPerThread = gridHeight / threadCount;

        // Calculate how many threads need to process one extra row
        int extraRows = gridHeight % threadCount;

        createCountThreads(threadCount, minRowsPerThread, extraRows, gridWidth);
        createWriteThreads(threadCount, minRowsPerThread, extraRows, gridWidth);
    }

    public static void startThreads(){
        for (Thread thread : countThreads) {
            thread.start();
        }
        try {
            countLatch.await();
        } catch (InterruptedException e) {
            System.out.println("Count latch interrupted");
        }

        for (Thread thread : writeThreads) {
            thread.start();
        }
        try {
            writeLatch.await();
        } catch (InterruptedException e) {
            System.out.println("Write latch interrupted");
        }
        resetThreads();
    }

    private static void createCountThreads(int threadCount, int minRowsPerThread, int extraRows, int gridWidth) {
        int startRow = 0;
        countLatch = new CountDownLatch(threadCount);
        for (int thread = 1; thread <= threadCount; thread++) {
            int rowsForThisThread = minRowsPerThread + (thread <= extraRows ? 1 : 0);

            int endRow = startRow + rowsForThisThread - 1;

            System.out.println("Thread " + thread + " processes rows " + startRow + ":" + endRow + " (" +
                    (endRow - startRow + 1) + ")" + " and cols 0:" + (gridWidth-1));

            int threadStartRow = startRow;
            int threadEndRow = endRow;
            startRow = endRow + 1;

            //Count threads creation
            Thread countThread = new Thread(() -> {
                for (int row = threadStartRow; row <= threadEndRow; row++) {
                    for (int column = 0; column < gridWidth; column++) {
                        Cell cell = Simulator.getGrid()[row][column];
                        cell.countNeighbours();
                    }
                }
                countLatch.countDown();
            });
            countThreads.add(countThread);
        }
    }

    private static void createWriteThreads(int threadCount, int minRowsPerThread, int extraRows, int gridWidth){
        int startRow = 0;
        writeLatch = new CountDownLatch(threadCount);
        for (int thread = 1; thread <= threadCount; thread++) {
            int rowsForThisThread = minRowsPerThread + (thread <= extraRows ? 1 : 0);

            int endRow = startRow + rowsForThisThread - 1;

            System.out.println("Thread " + thread + " processes rows " + startRow + ":" + endRow + " (" +
                    (endRow - startRow + 1) + ")" + " and cols 0:" + (gridWidth-1));

            int threadStartRow = startRow;
            int threadEndRow = endRow;
            startRow = endRow + 1;

            //Write threads creation
            Thread writeThread = new Thread(() -> {
                for (int row = threadStartRow; row <= threadEndRow; row++) {
                    for (int column = 0; column < gridWidth; column++) {
                        Cell cell = Simulator.getGrid()[row][column];
                        cell.evaluateNeighbors();
                    }
                }
                writeLatch.countDown();
            });
            writeThreads.add(writeThread);
        }
    }

    private static void resetThreads(){
        countThreads.clear();
        writeThreads.clear();
    }
}
