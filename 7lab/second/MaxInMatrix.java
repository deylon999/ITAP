package second;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MaxInMatrix {
    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = {
                {3, 5, 9, 1},
                {8, 7, 2, 4},
                {6, 0, 5, 11}
        };
        int rows = matrix.length;

        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        MaxInRowTask[] tasks = new MaxInRowTask[rows];
        
        for (int i = 0; i < rows; i++) {
            tasks[i] = new MaxInRowTask(matrix[i]);
            executor.execute(tasks[i]);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        int globalMax = tasks[0].getMax();

        for (int i = 1; i < tasks.length; i++) { 
            int currentMax = tasks[i].getMax(); 
            if (currentMax > globalMax) {
                globalMax = currentMax;
            }
        }       
        System.out.println("Максимальное значение в матрице: " + globalMax);
    }
}