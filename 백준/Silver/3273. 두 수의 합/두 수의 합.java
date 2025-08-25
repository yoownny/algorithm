import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int n = Integer.parseInt(br.readLine());

		Arrays.sort(num);
		int start = 0;
		int end = num.length - 1;

		int cnt = 0;
		while (start < end) {
			if (num[start] + num[end] == n) {
				cnt++;
				start++;
			} else if (num[start] + num[end] > n) {
				end--;
			} else {
				start++;
			}
		}

		System.out.println(cnt);
	}
}
