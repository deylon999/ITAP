public class ArrayAverage {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        try {
            int sum = 0;
            for (int i = 0; i <= arr.length; i++) {
                sum += arr[i];
            }
            double avg = (double) sum / arr.length;
            System.out.println("Среднее: " + avg);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
