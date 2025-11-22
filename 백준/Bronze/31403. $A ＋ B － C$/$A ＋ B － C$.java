import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());

		// 정수 취급
		int result = a + b - c;
		sb.append(result + "\n");

		// 문자열 취급
		String str = String.valueOf(a) + String.valueOf(b);
		int result2 = Integer.parseInt(str)- c;
		sb.append(result2);

		System.out.println(sb);
	}

}
