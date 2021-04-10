package com.algostudy;

import java.util.*;

class Solution {
	static public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<Integer> truck = new LinkedList<Integer>();
		Queue<Integer> bridge = new LinkedList<Integer>();
		for (int i = 0; i < truck_weights.length; i++) 
			truck.offer(truck_weights[i]);
		int w = 0;
		while (!truck.isEmpty()) {
			if (bridge.isEmpty()) {
				int temp = truck.poll();
				w += temp;
				bridge.offer(temp);
				answer++;
			}
			if (truck.isEmpty()) break;
			if (bridge.size() == bridge_length) {
				if (bridge.peek() == 0) {
						bridge.poll();
				} else {
					w -= bridge.poll();
				}
			} else {
				if (truck.peek() + w <= weight) {
					answer++;
					int temp = truck.poll();
					w += temp;
					bridge.offer(temp);
				} else {
					answer++;
					bridge.offer(0);
				}
			}

		}
		return answer + bridge_length;
	}

	public static void main(String[] args) {
		int[] truck_weights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		int bridge_length = 100;
		int weight = 100;
		System.out.println(solution(bridge_length, weight, truck_weights));
	}
}