import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (map.containsKey(str)) {
				int num = map.get(str);
				map.put(str, num + 1);
			} else {
				map.put(str, 1);
			}
		}

		ArrayList<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list);

		int max = 0;
		String best = "";

		for (String book : list) {
			if (map.get(book) > max) {
				max = map.get(book);
				best = book;
			}
		}

		System.out.println(best);
	}
}
