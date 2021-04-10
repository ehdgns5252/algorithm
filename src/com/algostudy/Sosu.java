package com.algostudy;

import java.io.*;
import java.util.*;

public class Sosu {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		List<Integer> sosu = new ArrayList<Integer>();
		boolean[] s = new boolean[1001];
		for (int i = 2; i < 1000; i++) {
			if (sosu.isEmpty()) {
				sosu.add(i);
				s[i] = true;
			}
			boolean isSosu = true;
			for (int j = 0; j < sosu.size(); j++) {
				if (i % sosu.get(j) == 0) {
					isSosu = false;
					break;
				}
			}
			if (isSosu) {
				sosu.add(i);
				s[i] = true;
			}
		}
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (s[n]) cnt++;
		}
		System.out.println(cnt);
	}
}
