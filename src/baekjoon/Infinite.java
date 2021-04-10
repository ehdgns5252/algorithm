package baekjoon;

import java.io.*;

public class Infinite {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		String t = in.readLine();
		if (find(s).equals(find(t))) System.out.println(1);
		else System.out.println(0);
	}
	static String find(String str) {
		for (int i = 1; i <= str.length() / 2; i++) {
			String temp = str.substring(0, i);
			if (str.length() % i == 0) {
				boolean flag = true;
				int num = str.length() / temp.length();
				for (int e = 0; e < num; e++) {
					String t = str.substring(e * temp.length(), e * temp.length() + temp.length());
					if (!temp.equals(t)) 
						flag = false;
				}
				if (flag) return temp;
			}
		}
		return str;
	}
}
