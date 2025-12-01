import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		String str = br.readLine();
		for (int i = 0; i <= 'z' - 'a'; i++) {
			char ch = (char) (i + 'a');
			sb.append(str.indexOf(ch)).append(" ");
		}

		System.out.println(sb);
	}

}
