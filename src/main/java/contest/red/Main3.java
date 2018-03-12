package contest.red;


import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int sum = 0;
        double maxAvg = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i >= k) {
                sum -= arr[i - k];
                double avg = sum / k;
                if (maxAvg < avg) {
                    maxAvg = avg;
                }
            }
        }
        System.out.println(maxAvg);
    }
}