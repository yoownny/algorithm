import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashSet<String> set1 = new HashSet<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			set1.add(str);
		}

		HashSet<String> set2 = new HashSet<>();
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			set2.add(str);
		}

		ArrayList<String> list = new ArrayList<>();
		for (String string : set1) {
			if (set2.contains(string)) {
				list.add(string);
			}
		}

		Collections.sort(list);

		System.out.println(list.size());
		for (String string : list) {
			System.out.println(string);
		}
	}
}
