import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] person = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(person[i], 51);
			person[i][i] = 0;
		}

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			if (a == -2 && b == -2) {
				break;
			}
			person[a][b] = 1;
			person[b][a] = 1;
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (person[i][j] > person[i][k] + person[k][j])
						person[i][j] = person[i][k] + person[k][j];
				}
			}
		}

		int min = 51;
		for (int i = 0; i < N; i++) {
			int max = 0;
			for (int j = 0; j < N; j++) {
				if (person[i][j] != 51) {
					max = Math.max(max, person[i][j]);
				}
			}
			if (max < min)
				min = max;
		}

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int max = 0;
			for (int j = 0; j < N; j++) {
				if (person[i][j] != 51) {
					max = Math.max(max, person[i][j]);
				}
			}
			if (max == min)
				list.add(i + 1);
		}

		Collections.sort(list);

		System.out.println(min + " " + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}