package solution;

public class Solution {

	public static void main(String[] args) {
		long n = 5;
		long m = 20;
		long [] trees = {4,42,40,27,46};
		long result = solution(n,m,trees);
		System.out.println(result);
	}

	private static long solution(long n, long m, long[] trees) {
		long result = 0 ;
		long minLength = 1;
		long maxLength = 0;
		for (long length : trees) {
			maxLength = Math.max(maxLength, length);
		}
		
		while(minLength <= maxLength) {
			long midLength = (minLength + maxLength) / 2;
			long sumLength = 0;

			for(long length : trees) {
				if (midLength > length)
					continue;
				sumLength += (length - midLength);
			}
			
			if (sumLength >= m) {
				result = midLength;
				minLength = midLength + 1;
			} else {
				maxLength = midLength - 1;
			}
			
		}
		
		return result;
	}

}
