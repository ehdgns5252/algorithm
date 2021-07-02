package com.algostudy;

import java.io.*;
import java.util.*;

public class BJ17503 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (map.containsKey(c)) {
				PriorityQueue<Integer> pq = map.get(c);
				pq.offer(v);
				map.replace(c, pq);
			} else {
				PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
				pq.offer(v);
				map.put(c, pq);
				q.offer(c);
			}
		}
		boolean flag = false;
		int sum = 0;
		int level = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		while (!q.isEmpty()) {
			level = q.poll();
			PriorityQueue<Integer> temp = map.get(level);
			if(pq.size() + temp.size() <= N) {
				while(!temp.isEmpty()) {
					int num = temp.poll();
					sum += num;
					pq.offer(num);
				}
			} else {
				while (!temp.isEmpty()) {
					int num = temp.poll();
					sum += num;
					pq.offer(num);
					int minus = pq.poll();
					sum -= minus;
					if (sum >= M) {
						flag = true;
						break;
					}
				}
			}
			if (sum >= M && pq.size() == N || flag) {
				flag = true;
				break;
			}
		}
		if (flag)
			System.out.println(level);
		else
			System.out.println(-1);
	}
}
