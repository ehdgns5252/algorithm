package com.algorithm;

import java.io.*;

public class Algo0201 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int c = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < c; i++) {
			String s = in.readLine();
			int sLength = s.length();
			int[] now = new int[sLength];
			for (int j = 0; j < sLength; j++)
				now[j] = s.charAt(j) - '0';
			int count = 0;
			if (now[0] == 1) count = 1;
			for (int j = 0; j < sLength - 1; j++) {
				if (now[j] == now[j + 1]) continue;
				count++;
			}
			System.out.println("#" + (i + 1) + " " + count);
		}
		
		
	}
}
