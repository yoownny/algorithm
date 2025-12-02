import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[6];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		int result = 0;
		for (int i = 0; i < 6; i++) {
			int a = arr[i] / t;
			int b = arr[i] % t;

			if (b == 0) {
				result += a;
			} else {
				result += (a + 1);
			}
		}
		sb.append(result + "\n");

		int a = N / p;
		int b = N % p;
		sb.append(a + " " + b);

		System.out.println(sb);
	}

}
