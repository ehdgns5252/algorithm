package com.algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MakePassword {
	static int L;
	static int C;
	static char[] word;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		word = new char[C];
		for (int i = 0; i < C; i++)
			word[i] = st.nextToken().charAt(0);
		Arrays.sort(word);
		com(0, new char[L], 0);
		System.out.println(sb.toString());
	}
	static void com(int cnt, char[] arr, int start) {
		if (cnt == L) {
			int mo =  0;
			int ja = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u')
					mo++;
				else ja++;
			}
			if (mo < 1 || ja < 2) return ;
			else {
				sb.append(new String(arr));
				sb.append("\n");
				return ;
			}
		}
		for (int i = start; i < C; i++) {
			arr[cnt] = word[i];
			com(cnt + 1, arr, i + 1);
		}
	}
}
