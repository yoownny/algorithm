import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int n = Integer.parseInt(br.readLine());

		int layer = 1;
		int max = 1;

		while (n > max) {
			max += 6 * layer;
			layer++;
		}

		sb.append(layer);

		System.out.println(sb);
	}
}