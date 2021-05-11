package programmers;

public class KeyPad {
	public static void main(String[] args) {
		
	}
	class Solution {
	    public String solution(int[] numbers, String hand) {
	        int[][] key = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {3, 0}, {3, 2}};
	        int l = numbers.length;
	        char[] ans = new char[l];
	        int[] nowL = new int[2];
	        int[] nowR = new int[2];
	        for (int i = 0; i < 2; i++) {
	            nowL[i] = key[10][i];
	            nowR[i] = key[11][i];
	        }
	        for (int i = 0; i < l; i++) {
	            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
	                for (int j = 0; j < 2; j++)
	                    nowL[j] = key[numbers[i]][j];
	                ans[i] = 'L';
	            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
	                for (int j = 0; j < 2; j++)
	                    nowR[j] = key[numbers[i]][j];
	                ans[i] = 'R';
	            } else {
	                int now = numbers[i];
	                int[] nowKey = key[now];
	                int dL = Math.abs(nowL[0] - nowKey[0]) + Math.abs(nowL[1] - nowKey[1]);
	                int dR = Math.abs(nowR[0] - nowKey[0]) + Math.abs(nowR[1] - nowKey[1]);
	                if (dL < dR) {
	                    for (int j = 0; j < 2; j++)
	                            nowL[j] = nowKey[j];
	                        ans[i] = 'L';
	                } else if (dL > dR) {
	                    for (int j = 0; j < 2; j++)
	                            nowR[j] = nowKey[j];
	                        ans[i] = 'R';
	                } else {
	                    if ("right".equals(hand)) {
	                        for (int j = 0; j < 2; j++)
	                            nowR[j] = nowKey[j];
	                        ans[i] = 'R';
	                    } else {
	                        for (int j = 0; j < 2; j++)
	                            nowL[j] = nowKey[j];
	                        ans[i] = 'L';
	                    }
	                }
	            }
	        }
	        return new String(ans);
	    }
	}
}
