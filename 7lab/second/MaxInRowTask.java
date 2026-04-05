package second;

public class MaxInRowTask implements Runnable {
    private final int[] row;
    private int max;

    public MaxInRowTask(int[] row) {
        this.row = row;
    }

    @Override
    public void run() {
        max = row[0];
        for (int val : row) {
            if (val > max) max = val;
        }
    }

    public int getMax() {
        return max;
    }
}