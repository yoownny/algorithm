import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for (int i : arr) {
			max = Math.max(max, i);
		}
		double[] arrn = new double[num];
		for (int i = 0; i < arrn.length; i++) {
			arrn[i] = (double) arr[i] / max * 100;
		}

		double sum = 0;
		for (double d : arrn) {
			sum += d;
		}
		System.out.println(sum / num);
	}
}