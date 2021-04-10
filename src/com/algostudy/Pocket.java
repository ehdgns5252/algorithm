package com.algostudy;

import java.io.*;
import java.util.*;

public class Pocket {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringBuilder sb = new StringBuilder();
		ArrayList<String>[] name = new ArrayList[26];
		ArrayList<Integer>[] num = new ArrayList[26];
		for (int i = 0; i < 26; i++) {
			name[i] = new ArrayList<String>();
			num[i] = new ArrayList<Integer>();
		}
		ArrayList<String> dic = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0 ; i < N ; i++) {
			str = in.readLine();
			char c = str.charAt(0);
			name[c - 'A'].add(str);
			num[c - 'A'].add(i);
			dic.add(str);
		}
		for (int i = 0; i < M; i++) {
			str = in.readLine();
			if (str.charAt(0) - '0' >= 0 && str.charAt(0) - '0' <= 9) {
				int index = Integer.parseInt(str);
				sb.append(dic.get(index - 1));
				sb.append("\n");
			} else {
				for (int e = 0; e < name[str.charAt(0) - 'A'].size(); e++) {
					if (name[str.charAt(0) - 'A'].get(e).equals(str)) {
						sb.append((num[str.charAt(0) - 'A'].get(e) + 1));
						sb.append("\n");
					}
				}
			}
		}
		System.out.print(sb.toString());
	}
}
