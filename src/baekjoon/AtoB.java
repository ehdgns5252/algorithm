package baekjoon;

import java.io.*;
import java.util.*;

public class AtoB {
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		dfs(A, B, 0);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min + 1);
	}
	static void dfs(long num, int B, int count) {
		if (num > B) {
			return ;
		}
		if (num == B) {
			min = Math.min(count, min);
			return;
		}
		dfs(num * 2, B, count + 1);
		dfs(num * 10 + 1, B, count + 1);
	}
}
