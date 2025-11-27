import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		if (first == 1) {
			int num = first;
			for (int i = 0; i < 7; i++) {
				int now = Integer.parseInt(st.nextToken());
				if (now != num + 1) {
					System.out.println("mixed");
					return;
				}
				num = now;
			}
			System.out.println("ascending");
		} else if (first == 8) {
			int num = first;
			for (int i = 0; i < 7; i++) {
				int now = Integer.parseInt(st.nextToken());
				if (now != num - 1) {
					System.out.println("mixed");
					return;
				}
				num = now;
			}
			System.out.println("descending");
		} else {
			System.out.println("mixed");
			return;
		}

		// System.out.println(sb);
	}

}
