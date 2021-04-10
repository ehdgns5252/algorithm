package com.algorithm;

import java.io.*;

public class Zegop {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		char[] ze = str.toCharArray();
		if (ze.length % 2 == 0) {
			int m = ze.length / 2;
			char[] answer = new char[m];
			int s1 = ze[0] - '0';
			int s2 = ze[1] - '0';
			int temp = s1 * 01 + s2;
			int index = 0;
			if (temp < 16)
				;
		} else {
			int m = ze.length + 1 /2;
			char[] answer = new char[m];
		}
	}
}
