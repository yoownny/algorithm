import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			String height;
			String weight;

			if (N % H == 0) {
				height = String.valueOf(H);
				weight = String.valueOf(N / H);
			} else {
				height = String.valueOf(N % H);
				weight = String.valueOf(N / H + 1);
			}

			if (weight.length() == 1) {
				weight = "0" + weight;
			}

			String result = height + weight;
			sb.append(result + "\n");
		}

		System.out.println(sb);
	}

}
