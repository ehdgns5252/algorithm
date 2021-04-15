package com.algorithm;

import java.io.*;
import java.util.*;

public class Sushi {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] sushiNum = new int[d + 1];
		Queue<Integer> sushi = new LinkedList<Integer>();
		int max = 0;
		int[] eat = new int[N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(in.readLine());
			eat[i] = temp;
			if (i < k) {
				sushi.offer(temp);
				if (sushiNum[temp] == 0)
					count++;
				sushiNum[temp]++;
			} else {
				int tempCount = count;
				if (sushiNum[c] == 0)
					tempCount++;
				max = Math.max(max, tempCount);
				if (--sushiNum[sushi.poll()] == 0)
					count--;
				if (sushiNum[temp] == 0)
					count++;
				sushiNum[temp]++;
				sushi.offer(temp);
			}
		}
		for (int i = N - k; i < N; i++) {
			int tempCount = count;
			if (sushiNum[c] == 0)
				tempCount++;
			max = Math.max(max, tempCount);
			if (--sushiNum[sushi.poll()] == 0)
				count--;
			if (sushiNum[eat[i + k - N]] == 0)
				count++;
			sushiNum[eat[i + k - N]]++;
			sushi.offer(eat[i + k - N]);
		}
		System.out.println(max);
	}
}
