import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int want = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		long min = 1;
		long max = arr[n - 1];
		long answer = 0;

		while (min <= max) {
			int sum = 0;
			long mid = (max + min) / 2;

			for (int i = 0; i < n; i++) {
				sum += (arr[i] / mid);
			}

			if (sum >= want) {
				min = mid + 1;
				answer = mid;
			} else {
				max = mid - 1;
			}
		}

		sb.append(answer);
		System.out.println(sb);
	}
}