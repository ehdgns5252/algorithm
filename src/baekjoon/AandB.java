package baekjoon;

import java.io.*;

public class AandB {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String S = in.readLine();
		String T = in.readLine();
		String temp = T.substring(0, T.length());
		while (S.length() < temp.length()) {
			if (temp.charAt(temp.length() - 1) == 'A') {
				temp = temp.substring(0, temp.length() - 1);
			} else if (temp.charAt(temp.length() - 1) == 'B') {
				String t = temp.substring(0, temp.length() - 1);
				StringBuffer sb = new StringBuffer(t);
				temp = sb.reverse().toString();
			}
		}
		if (temp.equals(S))
			System.out.println(1);
		else
			System.out.println(0);
	}
}
