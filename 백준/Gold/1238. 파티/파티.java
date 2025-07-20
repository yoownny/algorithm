import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[][] road = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(road[i], 100001);
			road[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			road[start - 1][end - 1] = time;
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (road[i][j] > road[i][k] + road[k][j])
						road[i][j] = road[i][k] + road[k][j];
				}
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			int round = road[i][X - 1] + road[X - 1][i];
			if (max < round)
				max = round;
		}

		System.out.println(max);
	}
}
