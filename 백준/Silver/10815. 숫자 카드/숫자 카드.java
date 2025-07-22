import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> num = new HashSet<>();
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			num.add(n);
		}
		int M = Integer.parseInt(br.readLine());
		int[] result = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (num.contains(n))
				result[i] = 1;
			else
				result[i] = 0;
		}
		for (int i = 0; i < M; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
