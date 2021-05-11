package programmers;

import java.util.HashMap;
import java.util.Map;

public class Shopping {
	public static void main(String[] args) {
		Shopping s = new Shopping();
		String[] gems = { "ZZZ", "YYY", "NNNN", "YYY", "BBB" };
		System.out.println(s.solution(gems)[0] + " " + s.solution(gems)[1]);
	}

	public int[] solution(String[] gems) {
		int[] answer = new int[2];
		Map<String, Integer> map = new HashMap<String, Integer>();
		int gemSize = 0;
		for (int i = 0; i < gems.length; i++) {
			if (map.containsKey(gems[i])) {
				map.put(gems[i], map.get(gems[i]) + 1);
			} else {
				map.put(gems[i], 1);
				gemSize++;
			}
		}
		Map<String, Integer> temp = new HashMap<String, Integer>();
		int now = 0;
		int start = 0;
		int min = gems.length;
		int minStart = 0;
		for (int i = 0; i < gems.length; i++) {
			if (now < gemSize) {
				if (temp.containsKey(gems[i])) {
					temp.put(gems[i], temp.get(gems[i]) + 1);
				} else {
					temp.put(gems[i], 1);
					now++;
				}
			}
			if (now == gemSize) {
				while (true) {
					if (min > i - start) {
						min = i - start;
						minStart = start;
					}
					if (temp.get(gems[start]) == 1) {
						temp.remove(gems[start]);
						now--;
					} else {
						temp.put(gems[start], temp.get(gems[start]) - 1);
					}
					start++;
					if (now < gemSize)
						break;
				}
			}
		}
		answer[0] = minStart + 1;
		answer[1] = minStart + min + 1;
//        for (int j = gemSize; j <= gems.length; j++) {
//        	Map<String, Integer> temp = new HashMap<String, Integer>();
//        	int now = 0;
//        	boolean flag = false;
//        	for (int i = 0; i < gems.length; i++) {
//        		if (i < j) {
//        			if (temp.containsKey(gems[i])) {
//        				temp.put(gems[i], temp.get(gems[i]) + 1);
//        			} else {
//        				temp.put(gems[i], 1);
//        				now++;
//        			}
//        		} else {
//        			if (temp.get(gems[i - j]) == 1) {
//        				temp.remove(gems[i - j]);
//        				now--;
//        			} else {
//        				temp.put(gems[i - j], temp.get(gems[i - j]) - 1);
//        			}
//        			if (temp.containsKey(gems[i])) {
//        				temp.put(gems[i], temp.get(gems[i]) + 1);
//        			} else {
//        				temp.put(gems[i], 1);
//        				now++;
//        			}
//        		}
//        		if (now == gemSize) {
//        			flag = true;
//        			answer[0] = i - j + 2;
//        			answer[1] = i + 1;
//        			break;
//        		}
//        	}
//        	if (flag)
//        		break;
//        }
		return answer;
	}
}
