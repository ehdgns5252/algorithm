package programmers;

import java.util.ArrayList;

public class MaxNumber {
	public static void main(String[] args) {
		MaxNumber max = new MaxNumber();
		System.out.println(max.solution("100-200*300-500+20"));
	}

	long answer;
	ArrayList<Long> arr = new ArrayList<Long>();
	ArrayList<Character> exp = new ArrayList<Character>();
	char[] e = { '+', '-', '*' };

	public long solution(String expression) {
		answer = 0;
		int l = expression.length();
		long num = 0;
		for (int i = 0; i < l; i++) {
			char temp = expression.charAt(i);
			if (temp >= '0' && temp <= '9') {
				num *= 10;
				num += (temp - '0');
			} else {
				arr.add(num);
				num = 0;
				exp.add(temp);
			}
		}
		arr.add(num);
		per(0, new int[3], new boolean[3]);
		return answer;
	}

	public void per(int index, int[] num, boolean[] isVisit) {
		if (index == 3) {
			ArrayList<Long> temp = new ArrayList<Long>();
			ArrayList<Character> tempExp = new ArrayList<Character>();
			for (int i = 0; i < arr.size(); i++)
				temp.add(arr.get(i));
			for (int i = 0; i < exp.size(); i++)
				tempExp.add(exp.get(i));
			for (int cnt = 0; cnt < 3; cnt++) {
				char now = e[num[cnt]];
				for (int i = 0; i < tempExp.size(); i++) {
					if (tempExp.get(i) == now) {
						if (now == '+') {
							long t = temp.get(i) + temp.get(i + 1);
							temp.remove(i + 1);
							temp.remove(i);
							temp.add(i, t);
							tempExp.remove(i);
						} else if (now == '-') {
							long t = temp.get(i) - temp.get(i + 1);
							temp.remove(i + 1);
							temp.remove(i);
							temp.add(i, t);
							tempExp.remove(i);
						} else {
							long t = temp.get(i) * temp.get(i + 1);
							temp.remove(i + 1);
							temp.remove(i);
							temp.add(i, t);
							tempExp.remove(i);
						}
						i--;
					}
				}
			}
			long n = Math.abs(temp.get(0));
			answer = Math.max(n, answer);
		}
		for (int i = 0; i < 3; i++) {
			if (!isVisit[i]) {
				isVisit[i] = true;
				num[index] = i;
				per(index + 1, num, isVisit);
				isVisit[i] = false;
			}
		}
	}
}
