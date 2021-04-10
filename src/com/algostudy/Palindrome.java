package com.algostudy;

import java.io.*;

public class Palindrome {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 0; test < T; test++) {
			char[] str = in.readLine().toCharArray();
			int temp = 0;
			boolean flag = false;
			int l = str.length - 1;
			int i = 0;
			while (true) {
				if (i >= l) {
					flag = true;
					break;
				}
				if (str[i] == str[l]) {
					i++;
					l--;
					continue;
				} else if (str[i] != str[l] && temp == 0) {
					if (str[i + 1] == str[l])
						i++;
					else if (str[i] == str[l - 1])
						l--;
					temp = 1;
				} else if (str[i] != str[l] && temp == 1) {
					break;
				}
			}
			if (!flag) {
				l = str.length - 1;
				i = 0;
				temp = 0;
				while (true) {
					if (i >= l) {
						flag = true;
						break;
					}
					if (str[i] == str[l]) {
						i++;
						l--;
						continue;
					} else if (str[i] != str[l] && temp == 0) {
						if (str[i] == str[l - 1])
							l--;
						else if (str[i + 1] == str[l])
							i++;
						temp = 1;
					} else if (str[i] != str[l] && temp == 1) {
						break;
					}
				}
			}
			if (flag) {
				if (temp == 0)
					System.out.println(0);
				else
					System.out.println(1);
			} else
				System.out.println(2);
		}
	}
}
