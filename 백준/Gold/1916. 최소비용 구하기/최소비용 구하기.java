import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[][] bus = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(bus[i], 100001);
			bus[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			bus[start - 1][end - 1] = Math.min(bus[start - 1][end - 1], cost);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;
		int end = Integer.parseInt(st.nextToken()) - 1;

		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		boolean[] isVisited = new boolean[N];
		queue.add(new int[] { start, 0 });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int loc = cur[0];
			int cost = cur[1];

			if (isVisited[loc])
				continue;
			isVisited[loc] = true;

			if (loc == end) {
				System.out.println(cost);
				return;
			}
			for (int i = 0; i < N; i++) {
				if (!isVisited[i] && bus[loc][i] <= 100000) {
					queue.add(new int[] { i, cost + bus[loc][i] });
				}
			}
		}
	}

}
