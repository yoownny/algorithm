import java.util.*;
import java.io.*;

public class Main {
	static int N, M, F;
	static int[][] road;
	static int nrow, ncol;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
	static int[] desC, desR;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 도로 크기 N*N
		N = Integer.parseInt(st.nextToken());
		// 손님 수
		M = Integer.parseInt(st.nextToken());
		// 연료
		F = Integer.parseInt(st.nextToken());
		// 도로 상황 (1은 벽)
		road = new int[N][N];

		desR = new int[M + 2];
		desC = new int[M + 2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				road[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 택시 시작 위치
		st = new StringTokenizer(br.readLine());
		nrow = Integer.parseInt(st.nextToken()) - 1;
		ncol = Integer.parseInt(st.nextToken()) - 1;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			// 손님 위치
			road[a][b] = i + 2;
			// 도착 위치
			desR[i + 2] = c;
			desC[i + 2] = d;
		}

		for (int i = 0; i < M; i++) {
			int num = findCustomer();
			if (num == -1) {
				System.out.println(-1);
				return;
			}
			int num2 = findDestination(num);
			if (num2 == -1) {
				System.out.println(-1);
				return;
			}

		}

		// 운전 완료
		System.out.println(F);
	}

	// 고객찾기 bfs 함수
	public static int findCustomer() {
		boolean[][] isVisited = new boolean[N][N];
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { nrow, ncol, 0 });
		isVisited[nrow][ncol] = true;
		ArrayList<int[]> list = new ArrayList<>();
		int min = -1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			int count = cur[2];

			if (road[r][c] > 1) {
				if (min != -1 && min < count) {
					break;
				}
				list.add(new int[] { r, c, count });
				min = count;
			}

			for (int d = 0; d < 4; d++) {
				int ddr = r + dr[d];
				int ddc = c + dc[d];
				if (ddr < 0 || ddr >= N || ddc < 0 || ddc >= N)
					continue;
				if (road[ddr][ddc] == 1 || isVisited[ddr][ddc] == true)
					continue;
				queue.add(new int[] { ddr, ddc, count + 1 });
				isVisited[ddr][ddc] = true;
			}
		}
		if (min == -1)
			return -1;

		list.sort((a, b) -> {
			if (a[0] != b[0])
				return a[0] - b[0];
			return a[1] - b[1];
		});

		int[] cur = list.get(0);
		int a = cur[0];
		int b = cur[1];
		int c = cur[2];
		int result = road[a][b];
		road[a][b] = 0;
		nrow = a;
		ncol = b;
		F -= c;
		if (F < 0)
			return -1;
		return result;
	}

	// 목적지찾기 bfs 함수
	public static int findDestination(int target) {
		boolean[][] isVisited = new boolean[N][N];
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { nrow, ncol, 0 });
		isVisited[nrow][ncol] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			int count = cur[2];

			if (r == desR[target] && c == desC[target]) {
				F -= count;
				if (F < 0)
					return -1;
				F += 2 * count;
				nrow = r;
				ncol = c;
				return 1;
			}

			for (int d = 0; d < 4; d++) {
				int ddr = r + dr[d];
				int ddc = c + dc[d];
				if (ddr < 0 || ddr >= N || ddc < 0 || ddc >= N)
					continue;
				if (road[ddr][ddc] == 1 || isVisited[ddr][ddc] == true)
					continue;
				queue.add(new int[] { ddr, ddc, count + 1 });
				isVisited[ddr][ddc] = true;
			}
		}
		return -1;
	}
}
