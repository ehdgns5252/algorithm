package com.algorithm;

import java.io.*;
import java.util.*;

public class Refrigerator {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] info = new int[N][2];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		Comparator<int[]> comparator = new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] - o2[0] == 0)
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}

		};
		Arrays.sort(info, comparator);
		List<int[]> refr = new ArrayList<int[]>();
		refr.add(info[0]);
		for (int i = 1; i < N; i++) {
			if (refr.get(refr.size() - 1)[1] > info[i][1]) {
				if (refr.get(refr.size() - 1)[0] < info[i][0]) {
					refr.set(refr.size() - 1, info[i]);
				} 
				continue;
			}
			
			if (refr.get(refr.size() - 1)[1] < info[i][0]) {
				refr.add(info[i]);
			} else if (refr.get(refr.size() - 1)[0] > info[i][1]) {
				refr.add(info[i]);
			}
		}
		System.out.println(refr.size());
	}
}
