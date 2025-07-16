import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i <= N - 1; i++) {
			if (list.isEmpty() || list.get(list.size() - 1) < num[i]) {
				list.add(num[i]);
			} else {
				int pos = Collections.binarySearch(list, num[i]);
				if (pos < 0) {
					pos = -(pos + 1);
				}
				list.set(pos, num[i]);
			}
		}
		System.out.println(list.size());

	}

}
