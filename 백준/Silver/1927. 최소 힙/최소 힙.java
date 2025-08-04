import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (queue.isEmpty()) {
					sb.append("0" + "\n");
				} else {
					sb.append(queue.poll() + "\n");
				}
			} else {
				queue.add(x);
			}
		}

		System.out.println(sb);
	}

}
