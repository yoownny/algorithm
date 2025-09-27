import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[][] miro, dist;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		miro = new int[N][M];
		dist = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			Arrays.fill(dist[i], -1);
			for (int j = 0; j < M; j++) {
				miro[i][j] = str.charAt(j) - '0';
			}
		}

		// (0,0) ~ (N-1, M-1)
		bfs(0, 0);

		System.out.println(dist[N - 1][M - 1]);
	}

	public static void bfs(int sy, int sx) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { sy, sx });
		dist[sy][sx] = 1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cy = cur[0];
			int cx = cur[1];

			for (int i = 0; i < 4; i++) {
				int y = cy + dy[i];
				int x = cx + dx[i];

				if ((y < 0) || (y > N - 1) || (x < 0) || (x > M - 1))
					continue;
				if (miro[y][x] != 1 || dist[y][x] != -1)
					continue;

				dist[y][x] = dist[cy][cx] + 1;
				queue.add(new int[] { y, x });
			}
		}
	}
}
