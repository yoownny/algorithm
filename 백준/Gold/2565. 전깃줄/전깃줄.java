import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			queue.add(new int[] { start, end });
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			int[] cur = queue.poll();
			num[i] = cur[1];
		}

		for (int i = 0; i < n; i++) {
			if (list.isEmpty() || list.get(list.size() - 1) < num[i]) {
				list.add(num[i]);
			} else {
				int pos = Collections.binarySearch(list, num[i]);
				if (pos < 0) {
					list.set(-(pos + 1), num[i]);
				}
			}
		}
		System.out.println(n - list.size());
	}
}
