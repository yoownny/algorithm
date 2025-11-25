import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine().trim();
		if (str.length() == 0) {
			System.out.println(0);
			return;
		}

		String[] arr = str.split(" ");
		int result = arr.length;
		
		sb.append(result);

		System.out.println(sb);
	}

}
