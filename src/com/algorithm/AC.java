package com.algorithm;

import java.io.*;
import java.util.*;

public class AC {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 0; test < T; test++) {
			String str = in.readLine();
			StringBuilder sb = new StringBuilder();
			char[] p = str.toCharArray();
			int n = Integer.parseInt(in.readLine());
			int[] num = new int[n];
			str = in.readLine();
			char[] temp = str.toCharArray();
			char[] now = new char[temp.length - 2];
			for (int i = 0; i < now.length; i++) {
				now[i] = temp[i + 1];
			}
			int first = 0;
			int last = n;
			str = new String(now);
			StringTokenizer st = new StringTokenizer(str, ",");
			int index = 0;
			boolean reverse = false;
			while (st.hasMoreTokens())
				num[index++] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < p.length; i++) {
				if (p[i] == 'R') {
					if (!reverse)
						reverse = true;
					else
						reverse = false;
				} else {
					if (reverse)
						last--;
					else
						first++;
				}
			}
			if (first > last) {
				System.out.println("error");
				continue;
			} else if (first == last) {
				System.out.println("[]");
				continue;
			}
			if (!reverse) {
				sb.append("[");
				for (int i = first; i < last; i++) 
					sb.append(num[i] + ",");
				sb.deleteCharAt(sb.length() - 1);
				sb.append("]");
			} else {
				sb.append("[");
				for (int i = last - 1; i >= first; i--)
					sb.append(num[i] + ",");
				sb.deleteCharAt(sb.length() - 1);
				sb.append("]");
			}
			System.out.println(sb.toString());
		}
	}
}
