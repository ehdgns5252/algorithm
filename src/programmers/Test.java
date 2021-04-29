package programmers;

import java.util.ArrayList;


public class Test {
	class Solution {
	    public int[] solution(int[] answers) {
	        int size = answers.length;
	        int[] answer = new int[3];
	        int[] B = {1, 3, 4, 5};
	        int[] C = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
	        for (int i = 0; i < size; i++) {
	            if (answers[i] == (i % 5) + 1)
	                answer[0]++;
	            if (answers[i] == (i % 2 == 0 ? 2 : B[(i / 2) % 4]))
	                answer[1]++;
	            if (answers[i] == C[i % 10])
	                answer[2]++;
	        }
	        int max = 0;
	        for (int i = 0; i < 3; i++)
	            max = Math.max(max, answer[i]);
	        ArrayList<Integer> isMax = new ArrayList<Integer>();
	        for (int i = 0; i < 3; i++)
	            if (max == answer[i])
	                isMax.add(i);
	        int[] ans = new int[isMax.size()];
	        for (int i = 0; i < ans.length; i++)
	            ans[i] = isMax.get(i) + 1;
	        return ans;
	    }
	}
}
