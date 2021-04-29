package programmers;
import java.util.*;

public class FindPrimeNumber {
	class Solution {
	    boolean[] numbers = new boolean[10000000];
	    int length;
	    int[] number;
	    int answer;
	    public int solution(String numbers) {
	        answer = 0;
	        length = numbers.length();
	        number = new int[length];
	        for (int i = 0; i < length; i++)
	            number[i] = numbers.charAt(i) - '0';
	        bin(0, new boolean[length]);
	        return answer;
	    }
	    
	    void per(int idx, int[] num, boolean[] isVisit, int[] now) {
	        if (idx == num.length) {
	            int n = 0;
	            for (int i = 0; i < num.length; i++) {
	                n *= 10;
	                n += now[num[i]];
	            }
	            if (n > 1 && isPrime(n) && !numbers[n]) {
	                numbers[n] = true;
	                answer++;
	            }
	            return ;
	        }
	        for (int i = 0; i < num.length; i++) {
	            if (!isVisit[i]) {
	                isVisit[i] = true;
	                num[idx] = i;
	                per(idx + 1, num, isVisit, now);
	                isVisit[i] = false;
	            }
	        }
	    }
	    
	    void bin(int idx, boolean[] isVisit) {
	        if (idx == length) {
	            ArrayList<Integer> temp = new ArrayList<Integer>();
	            for (int i = 0; i < length; i++) {
	                if (isVisit[i]) {
	                    temp.add(number[i]);
	                }
	            }
	            int[] num = new int[temp.size()];
	            for (int i = 0; i < num.length; i++)
	                num[i] = temp.get(i);
	            per(0, new int[num.length], new boolean[num.length], num);
	            return;
	        }
	        isVisit[idx] = true;
	        bin(idx + 1, isVisit);
	        isVisit[idx] = false;
	        bin(idx + 1, isVisit);
	        
	    }
	    boolean isPrime(int n) {
	        int c = (int) Math.sqrt(n);
	        boolean flag = true;
	        for (int i = 2; i <= c; i++) {
	            if (n % i == 0)
	                flag = false;
	        }
	        return flag;
	    }
	}
}
