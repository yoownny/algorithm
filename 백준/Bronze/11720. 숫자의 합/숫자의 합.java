import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String num = sc.next();

		int result = 0;
		for (int i = 0; i < n; i++) {
			int plus = num.charAt(i) - '0';
			result += plus;
		}
		
		System.out.println(result);

	}

}
