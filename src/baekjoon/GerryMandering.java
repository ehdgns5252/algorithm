package baekjoon;

import java.io.*;
import java.util.*;

public class GerryMandering {
	static int[] area;
	static HashSet<Integer>[] map;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		area = new int[N + 1];
		map = new HashSet[N + 1];
		for (int i = 1; i <= N; i++)
			map[i] = new HashSet<Integer>();
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		for (int i = 1; i < N + 1; i++)
			area[i] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N + 1; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			int count = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int temp = Integer.parseInt(st.nextToken());
				map[i].add(temp);
				map[temp].add(i);
			}
		}
		make(1, new boolean[N + 1]);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	static void make(int index, boolean[] flag) {
		if (index == area.length) {
			ArrayList<Integer> A = new ArrayList<Integer>();
			ArrayList<Integer> B = new ArrayList<Integer>();
			for (int i = 1; i < index; i++) {
				if (flag[i]) {
					A.add(i);
				} else {
					B.add(i);
				}
			}
			if (A.size() == 0 || B.size() == 0)
				return;
			int sumA = 0;
			int sumB = 0;
			for (int i = 0; i < A.size(); i++) {
				sumA += area[A.get(i)];
			}
			for (int i = 0; i < B.size(); i++) {
				sumB += area[B.get(i)];
			}
			if (gerryMandering(A, index) && gerryMandering(B, index)) {
				min = Math.min(Math.abs(sumA - sumB), min);
			}
			return;
		}
		flag[index] = true;
		make(index + 1, flag);
		flag[index] = false;
		make(index + 1, flag);
	}

	static boolean gerryMandering(ArrayList<Integer> arr, int index) {
		int n = arr.size();
		int count = 0;
		boolean[] can = new boolean[index];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(arr.get(0));
		can[arr.get(0)] = true;
		count++;
		while (!q.isEmpty()) {
			int t = q.poll();
			for (Integer num: map[t]) {
				if (!can[num] && arr.contains(num)) {
					can[num] = true;
					q.offer(num);
					count++;
				}
			}
		}
		if (count == n)
			return true;
		else
			return false;
	}


}
