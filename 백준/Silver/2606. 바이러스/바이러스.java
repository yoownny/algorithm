import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][n];
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a - 1][b - 1] = 1;
			arr[b - 1][a - 1] = 1;
		}

		// bfs
		int num = 0;
		boolean[] isVisted = new boolean[n];
		ArrayDeque<Integer> queue = new ArrayDeque<>();

		isVisted[0] = true;
		queue.add(0);

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < n; i++) {
				if (isVisted[i] == false && arr[cur][i] == 1) {
					isVisted[i] = true;
					queue.add(i);
					num++;
				}
			}
		}

		System.out.println(num);
	}
}