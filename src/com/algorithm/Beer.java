package com.algorithm;

import java.io.*;
import java.util.*;

class Node {
	int start;
	int end;
	int value;

	Node(int start, int end, int value) {
		this.start = start;
		this.end = end;
		this.value = value;
	}

}

public class Beer {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test = 0; test < T; test++) {
			Queue<Node> q = new LinkedList<Node>();
			int N = Integer.parseInt(in.readLine());
			int[][] xy = new int[N + 2][2];
			for (int i = 0; i < N + 2; i++) {
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				xy[i][0] = Integer.parseInt(st.nextToken());
				xy[i][1] = Integer.parseInt(st.nextToken());
			}
			boolean[] isVisit = new boolean[N + 2];
			isVisit[0] = true;
			boolean flag = false;
			for (int j = 0; j < N + 2; j++) {
				if (0 == j)
					continue;
				int range = Math.abs(xy[0][0] - xy[j][0]) + Math.abs(xy[0][1] - xy[j][1]);
				if (range <= 1000) {
					if (j == N + 1)
						flag = true;
					Node n = new Node(0, j, range);
					
					q.offer(n);
				}
			}
			if (flag)
				System.out.println("happy");
			else {
				while (!q.isEmpty()) {
					Node n = q.poll();
					int end = n.end;
					for (int j = 0; j < N + 2; j++) {
						if (end == j)
							continue;
						int range = Math.abs(xy[end][0] - xy[j][0]) + Math.abs(xy[end][1] - xy[j][1]);
						if (range <= 1000 && !isVisit[j]) {
							Node temp = new Node(end, j, range);
							q.offer(temp);
							isVisit[j] = true;
						}
					}
				}

				if (isVisit[N + 1])
					System.out.println("happy");
				else
					System.out.println("sad");
			}
		}
	}

}
