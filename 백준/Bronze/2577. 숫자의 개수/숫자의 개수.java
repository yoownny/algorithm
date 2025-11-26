import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());

		String result = String.valueOf(A * B * C);

		int[] num = new int[10];
		for (int i = 0; i < result.length(); i++) {
			num[result.charAt(i) - '0']++;
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(num[i]);
		}

		// System.out.println(sb);
	}

}
