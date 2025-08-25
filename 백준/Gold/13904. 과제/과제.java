import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<int[]> num = new ArrayList<int[]>();

		int maxDay = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			num.add(new int[] { d, w });
			if (maxDay < d)
				maxDay = d;
		}

		int result = 0;
		for (int i = maxDay; i > 0; i--) {
			int max = 0;
			int maxI = -1;

			for (int j = 0; j < num.size(); j++) {

				if (num.get(j)[0] >= i) {
					if (max < num.get(j)[1]) {
						max = num.get(j)[1];
						maxI = j;
					}
				}
			}

			if (maxI != -1) {
				result += max;
				num.remove(maxI);
			}
		}

		System.out.println(result);

	}

}
