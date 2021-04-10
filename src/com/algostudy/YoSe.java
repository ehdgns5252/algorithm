package com.algostudy;

import java.io.*;
import java.util.*;

public class YoSe {
	static List<Integer> result = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int[] info = new int[2];
		int i = 0;
		while (st.hasMoreTokens())
			info[i++] = Integer.parseInt(st.nextToken());
		int num = 0;
		while (true) {
			int e = 0;
			while (true) {
				num++;
				if (num > info[0])
					num %= info[0];
				if (!result.isEmpty())
					if (result.contains(num))
						continue;
				e++;
				if (e == info[1]) {
					result.add(num);
					break;
				}
			}
			if (result.size() == info[0]) break;
		}
		System.out.print("<");
		for (i = 0; i < result.size() - 1; i++) 
			System.out.print(result.get(i) + ", ");
		System.out.println(result.get(result.size() - 1) +">");
	}
}
