import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int len = String.valueOf(n).length();
        int start = Math.max(0, n - 9 * len);

        for (int i = start; i < n; i++) {
            if (i + digitSum(i) == n) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }

    private static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
