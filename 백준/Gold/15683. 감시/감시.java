
import java.util.*;
import java.io.*;

public class Main{

	static int N, M, min;
	static int[][] room;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static ArrayList<int[]> list;

	static int[][][] directions = { {}, { { 0 }, { 1 }, { 2 }, { 3 } }, { { 0, 2 }, { 1, 3 } },
			{ { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } }, { { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 } },
			{ { 0, 1, 2, 3 } } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		room = new int[N][M];

		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if (room[i][j] != 0 && room[i][j] != 6) {
					list.add(new int[] { room[i][j], i, j });
				}
			}
		}

		findMin(0, room);

		System.out.println(min);
	}

	public static void findMin(int camNum, int[][] newroom) {
		if (camNum == list.size()) {
			min = Math.min(min, cntRoom(newroom));
			return;
		}
		int[] cur = list.get(camNum);
		int d = cur[0];
		int r = cur[1];
		int c = cur[2];

		for (int i = 0; i < directions[d].length; i++) {
			int[][] tempRoom = new int[N][M];
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					tempRoom[x][y] = newroom[x][y];
				}
			}

			for (int j = 0; j < directions[d][i].length; j++) {
				int di = directions[d][i][j];
				int nr = r;
				int nc = c;

				while (true) {
					nr += dr[di];
					nc += dc[di];

					if (nr < 0 || nr >= N || nc < 0 || nc >= M || tempRoom[nr][nc] == 6)
						break;

					if (tempRoom[nr][nc] == 0)
						tempRoom[nr][nc] = 7;

				}
			}

			findMin(camNum + 1, tempRoom);
		}

	}

	public static int cntRoom(int[][] newroom) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (newroom[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}
}
