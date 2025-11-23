import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		if (m >= 45) {
			sb.append(h + " " + (m - 45));
		} else {
			if (h == 0) {
				sb.append("23 " + (m + 60 - 45));
			} else {
				sb.append((h - 1) + " " + (m + 60 - 45));
			}
		}

		System.out.println(sb);
	}

}
