import java.io.*;
import java.util.*;

public class Main {
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int[] target = num.clone();
		Arrays.sort(target);

		if (Arrays.equals(num, target)) {
			System.out.println(0);
			return;
		}

		// bfs 사용하기
		ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
		// 배열을 키로 사용하면 안됨 (참조값으로 비교하기 때문)
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		queue.add(num);
		map.put(Arrays.toString(num), 0);

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curStep = map.get(Arrays.toString(cur));
			// 한번씩 플립해보기
			for (int i = 0; i <= N - K; i++) {
				int[] next = flip(cur, i);
				if (Arrays.equals(next, target)) {
					System.out.println(curStep + 1);
					return;
				}
				// 큐에 넣기
				if (!map.containsKey(Arrays.toString(next))) {
					queue.add(next);
					map.put(Arrays.toString(next), curStep + 1);
				}
			}
		}
		System.out.println(-1);
	}

	public static int[] flip(int[] num, int start) {
		int[] result = num.clone();
		for (int i = 0; i < K / 2; i++) {
			int temp = result[start + i];
			result[start + i] = result[start + K - 1 - i];
			result[start + K - 1 - i] = temp;
		}
		return result;
	}
}
