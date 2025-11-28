package first;

public class TwoThreadArraySum {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        int middle = arr.length / 2;

        SumThread t1 = new SumThread(arr, 0, middle);
        SumThread t2 = new SumThread(arr, middle, arr.length);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        int totalSum = t1.getPartialSum() + t2.getPartialSum();

        System.out.println("Сумма массива = " + totalSum);
    }
}
