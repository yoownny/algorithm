import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] num = new int[N];
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			if (map.containsKey(num[i])) {
				map.replace(num[i], map.get(num[i]) + 1);
			} else {
				map.put(num[i], 1);
			}
		}

		List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
		entryList.sort((a, b) -> b.getValue() - a.getValue());

		for (Map.Entry<Integer, Integer> entry : entryList) {
			for (int i = 0; i < entry.getValue(); i++) {
				System.out.print(entry.getKey() + " ");
			}
		}
	}

}
