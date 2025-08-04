import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		PriorityQueue<Long> queue = new PriorityQueue<Long>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			long num = Long.parseLong(st.nextToken());
			queue.add(num);
		}

		for (int i = 0; i < m; i++) {
			long x1 = queue.poll();
			long x2 = queue.poll();
			long y = x1 + x2;
			queue.add(y);
			queue.add(y);
		}

		long result = 0;
		for (int i = 0; i < n; i++) {
			result += queue.poll();
		}

		System.out.println(result);

	}

}
