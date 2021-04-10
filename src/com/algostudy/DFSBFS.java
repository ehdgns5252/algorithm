package com.algostudy;

import java.io.*;
import java.util.*;

public class DFSBFS {
	static Queue<Integer>[] dfsIndex;
	static Queue<Integer>[] bfsIndex;
	static List<Integer>[] sorted;
	static Queue<Integer> bfs = new LinkedList<Integer>();
	static StringBuilder sbdfs = new StringBuilder();
	static StringBuilder sbbfs = new StringBuilder();
	static boolean[] isVisitdfs;
	static boolean[] isVisitbfs;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		dfsIndex = new Queue[N + 1];
		bfsIndex = new Queue[N + 1];
		sorted = new ArrayList[N + 1];
		isVisitdfs = new boolean[N + 1];
		isVisitbfs = new boolean[N + 1];
		for (int i = 0; i < N + 1; i++) {
			sorted[i] = new ArrayList<Integer>();
			dfsIndex[i] = new LinkedList<Integer>();
			bfsIndex[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			int pre = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			sorted[pre].add(next);
			sorted[next].add(pre);
		}
		for (int  i = 0 ; i <= N; i++) {
			Collections.sort(sorted[i]);
		}
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < sorted[i].size(); j++) {
				dfsIndex[i].offer(sorted[i].get(j));
				bfsIndex[i].offer(sorted[i].get(j));
			}
		}
		sbdfs.append(V + " ");
		isVisitdfs[V] = true;
		DFS(dfsIndex[V]);
		sbbfs.append(V + " ");
		isVisitbfs[V] = true;
		while (!bfsIndex[V].isEmpty()) {
			bfs.offer(bfsIndex[V].poll());
		}
		while (!bfs.isEmpty()) {
			int temp = bfs.poll();
			if (!isVisitbfs[temp]) {
				sbbfs.append(temp + " ");
				isVisitbfs[temp] = true;
				while (!bfsIndex[temp].isEmpty()) 
					bfs.offer(bfsIndex[temp].poll());
			}
		}
		System.out.println(sbdfs.toString());
		System.out.println(sbbfs.toString());
	}
	static void DFS(Queue<Integer> q) {
		if (q.isEmpty()) {
			return ;
		}
		while (!q.isEmpty()) {
			int temp = q.poll();
			if (!isVisitdfs[temp]) {
				sbdfs.append(temp + " ");
				isVisitdfs[temp] = true;
				DFS(dfsIndex[temp]);
			}
		}
	}
	
}
