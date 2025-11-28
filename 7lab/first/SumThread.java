package first;

public class SumThread extends Thread {
    private int[] arr;
    private int start;
    private int end;
    private int partialSum;

    public SumThread(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            partialSum += arr[i];
        }
    }

    public int getPartialSum() {
        return partialSum;
    }
}
