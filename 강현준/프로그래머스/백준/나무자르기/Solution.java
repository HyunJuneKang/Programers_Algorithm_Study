package backjun;

import java.util.Arrays;

/*
 *N개의 랜선 
 * K개의 랜선을 보유 , but 길이가 제각각 모두 같은 길이로 만들고 싶다
 * 300cm (140cm) -> 140 140 20(버리기)
 */
public class Solution {

	public static void main(String[] args) {
		int k = 4;  // 가지고있는 랜선
		int n = 11; // 필요한 랜선
		int []length = {802,743,457,539}; //랜선의 길이
		//필요한 랜선을 가지되 최대길이로 나누어 쪼개기
		System.out.println(sol(k,n,length)); //200이 나와야함
	}

	private static long sol(int k, int n, int[] length) {
		Arrays.sort(length);
		//150 200 250 150
		// length[i] / targetLength = sum(3 4 5 3)
		// count(*) 이 n보다 크다? midlength를 높여
		// 작아? midlength를 낮추어
		long maxLength = length[length.length-1];
		long minLength = 1;
		while(minLength <= maxLength) {
			long midLength = (long)((maxLength + minLength) / 2);
			long sum = 0;
			for(int i = 0 ; i < length.length; i++) {
				sum += (long)(length[i] / midLength);
			}
			if (sum >= n) {
				minLength = midLength + 1;
			} else {
				maxLength = midLength - 1;
			}
		}
		return maxLength;
	}

}
