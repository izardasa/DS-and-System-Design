import java.util.HashMap;

public class DP {

	public static void main(String[] args) {

//		int[][] A = new int[][] { { 4, 7, 1, 6 }, { 5, 7, 3, 9 }, { 3, 2, 1, 2 }, { 7, 1, 6, 3 } };
//		HashMap<String, Integer> map = new HashMap<String, Integer>();
//		System.out.println(maxProfitInKBuySalesOrderKN(new int[]{2,18,10,22,5,75,65,80},4));
		System.out.println(findTotalWaterWithLinearSpace(new int[]{3,0,0,0,2,0}));
	}

	public static int findTotalWaterWithLinearSpace(int[] water)
	{
		int n = water.length;
		int totalWater=0;
		if(n<3)
			return totalWater;

		int low = 0;
		int high = n-1;
		

		int leftMax = 0;
		int rightMax = 0;
		
		while(low<=high)
		{
			if(water[low]<water[high])
			{
				if(water[low]>leftMax)
				{
					leftMax = water[low];
				}
				else
				{
					totalWater+=(leftMax-water[low++]);
				}
			}
			else
			{
				if(water[high]>rightMax)
				{
					rightMax = water[high];
				}
				else
				{
					totalWater+=(rightMax-water[high--]);
				}
			}
		}
		
		return totalWater;
	}
	
	public static int findTotalWater(int[] water)
	{
		int n = water.length;
		int totalWater=0;
		if(n<3)
			return totalWater;
		
		int[] leftMax = new int[n];
		int[] rightMax = new int[n];
		leftMax[0] = water[0];
		
		for(int i=1;i<n;i++)
			leftMax[i] = Integer.max(leftMax[i-1], water[i]);
		
		rightMax[n-1] = water[n-1];
		for(int i=n-2;i>=0;i--)
			rightMax[i] = Integer.max(rightMax[i+1], water[i]);
		
		for(int i=1;i<=n-2;i++)
			totalWater+=(Integer.min(leftMax[i], rightMax[i])-water[i]);
		
		return totalWater;
	}
	public static int maxProfitInKBuySalesOrderKN(int[] price, int K)
	{
		int N = price.length;
		int[][] profit = new int[K+1][N];
		
		for(int i=1;i<=K;i++)
		{
			int max_diff=Integer.MIN_VALUE;
			for(int j=1;j<N;j++)
			{
				
					max_diff = Math.max(max_diff,profit[i-1][j-1]-price[j-1]);
					profit[i][j]= Math.max(max_diff+price[j], profit[i][j-1]);
			}
		}
		return profit[K][N-1];
	}
	
	public static int maxProfitInKBuySales(int[] price, int K)
	{
		int N = price.length;
		int[][] profit = new int[K+1][N];
		
		for(int i=1;i<=K;i++)
		{
			for(int j=1;j<N;j++)
			{
				int max_so_far=0;
				for(int m=0;m<j;m++)
				{
					max_so_far = Math.max(max_so_far, price[j]-price[m]+profit[i-1][m]);
					profit[i][j]= Math.max(max_so_far, profit[i][j-1]);
				}
			}
		}
		return profit[K][N-1];
	}
	
	public static int findMinCoinsDP(int[] A, int N)
	{
		int n = A.length;
		int[] table = new int[N+1];

		for(int i =1;i<=N;i++)
		{
			table[i] = Integer.MAX_VALUE;
			int res = Integer.MAX_VALUE;
			for(int c=0;c<n;c++)
			{
				if(i-A[c]>=0)
					res = table[i-A[c]];
				
				if(res!=Integer.MAX_VALUE)
					table[i] = Integer.min(table[i], res+1);
					
			}
		}
		return table[N];
	}

	public static int findMinCoins(int[] A, int S)
	{
		if(S<0)
			return Integer.MAX_VALUE;
		
		if(S==0)
			return 0;
		
		int res = 0;
		int coins = Integer.MAX_VALUE;
		
		for(int i=0;i<A.length;i++)
		{
			res = findMinCoins(A, S-A[i]);
			
			if(res != Integer.MAX_VALUE)
			{
				coins = Integer.min(coins, res+1);
			}
		}
		return coins;
	}
	public static int countSumIsNDistinctDP(int A[],int n, int S, HashMap<String, Integer> map) {
		if (S < 0 || n<0)
			return 0;
		if (S == 0 )
			return 1;

		String key =n+"|"+S;
		if(!map.containsKey(key))
		{
		map.put(key,countSumIsNDistinctDP(A, n,S-A[n],map)+countSumIsNDistinctDP(A, n-1,S,map));
		}
		
		return map.get(key);
				
	}



	public static int countSumIsNDistinct(int A[],int n, int S) {
		if (S < 0 || n<0)
			return 0;
		if (S == 0 )
			return 1;

		int include = countSumIsNDistinct(A, n,S-A[n]);
		int exclude = countSumIsNDistinct(A, n-1,S);
		
		return include +exclude;
	}

	
	public static int countSumIsN(int A[], int S) {
		if (S < 0)
			return 0;
		if (S == 0)
			return 1;

		int res = 0;

		for (int i = 0; i < A.length; i++)
			res += countSumIsN(A, S - A[i]);
		
		return res;
	}

	public static int countPathsToReachDestinationCellDP(int[][] A, int m, int n, int cost,
			HashMap<String, Integer> map) {

		if (cost < 0)
			return 0;

		if (m == 0 && n == 0)
			return (A[0][0] - cost) == 0 ? 1 : 0;
		String key = m + "|" + n + "|" + cost;
		if (!map.containsKey(key)) {
			if (m == 0)
				map.put(key, countPathsToReachDestinationCellDP(A, 0, n - 1, cost - A[m][n], map));
			else if (n == 0)
				map.put(key, countPathsToReachDestinationCellDP(A, m - 1, 0, cost - A[m][n], map));
			else
				map.put(key, countPathsToReachDestinationCellDP(A, m - 1, n, cost - A[m][n], map)
						+ countPathsToReachDestinationCellDP(A, m, n - 1, cost - A[m][n], map));
		}
		return map.get(key);

	}

	public static int countPathsToReachDestinationCell(int[][] A, int m, int n, int cost) {
		if (cost < 0)
			return 0;
		if (m == 0 && n == 0) {
			if (A[0][0] - cost == 0)
				return 1;
			return 0;
		}
		int noOfPaths = 0;
		if (m == 0)
			noOfPaths = countPathsToReachDestinationCell(A, m, n - 1, cost - A[m][n]);
		else if (n == 0)
			noOfPaths = countPathsToReachDestinationCell(A, m - 1, n, cost - A[m][n]);
		else
			noOfPaths = countPathsToReachDestinationCell(A, m, n - 1, cost - A[m][n])
					+ countPathsToReachDestinationCell(A, m - 1, n, cost - A[m][n]);

		return noOfPaths;

	}

	public static int countStringWithoutConsecutiveONEsDP(int n) {
		int[][] A = new int[n + 1][2];
		A[0][0] = 0;
		A[0][1] = 0;
		A[1][0] = 2;
		A[1][1] = 1;

		for (int i = 2; i <= n; i++) {
			A[i][0] = A[i - 1][0] + A[i - 1][1];
			A[i][1] = A[i - 1][0];
		}
		return A[n][0];
	}

	public static int countStringWithoutConsecutiveONEs(int n, int lastDigit) {
		if (n == 0)
			return 0;

		if (n == 1) {
			return lastDigit == 1 ? 1 : 2;
		}
		if (lastDigit == 0) {
			return countStringWithoutConsecutiveONEs(n - 1, 0) + countStringWithoutConsecutiveONEs(n - 1, 1);
		}

		return countStringWithoutConsecutiveONEs(n - 1, 0);

	}

	public static void printStringWithoutConsecutiveONEs(int n, String out, int lastDigit) {
		if (n == 0) {
			System.out.println(out);
			return;
		}

		printStringWithoutConsecutiveONEs(n - 1, out + "0", 0);

		if (lastDigit == 0) {
			printStringWithoutConsecutiveONEs(n - 1, out + "1", 1);
		}

	}

	public static int findLargesetSquareDP(int[][] M) {
		int max = 0;
		int m = M.length;
		int n = M[0].length;
		int[][] A = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				A[i][j] = M[i][j];

				if (i > 0 && j > 0 && M[i][j] == 1) {
					A[i][j] = 1 + Integer.min(Integer.min(A[i][j - 1], A[i - 1][j - 1]), A[i - 1][j]);
				}

				if (max < A[i][j])
					max = A[i][j];
			}
		}

		return max;
	}

	public static int findLargesetSquareRec(int[][] M, int m, int n, Size s) {
		if (m == 0 || n == 0)
			return M[m][n];

		int left = findLargesetSquareRec(M, m, n - 1, s);
		int top = findLargesetSquareRec(M, m - 1, n, s);
		int diag = findLargesetSquareRec(M, m - 1, n - 1, s);
		int size = 0;
		if (M[m][n] != 0) {
			size = 1 + Integer.min(Integer.min(left, top), diag);
			s.setMaxSize(Integer.max(s.getMaxSize(), size));
		}
		return size;
	}

	public static int maxRodCutValue(int[] value, int n) {
		if (n <= 0)
			return 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++)
			max = Integer.max(max, maxRodCutValue(value, n - i - 1) + value[i]);

		return max;
	}

	public static int maxRodCutValueDP(int[] value) {
		int n = value.length;
		int[] table = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				max = Integer.max(max, table[i - j - 1] + value[j]);

				table[i] = max;
			}
		}
		return table[n];

	}

	public static int maxRodCutProductValueDP(int n) {

		int[] value = new int[n];
		for (int i = 0; i < n; i++)
			value[i] = i + 1;
		int[] table = new int[n + 1];
		table[0] = 1;

		for (int i = 1; i <= n; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				max = Integer.max(max, table[i - j - 1] * value[j]);

				table[i] = max;
			}
		}
		return table[n];

	}

	public static int maxRodCutProductValueDP(int[] value) {
		int n = value.length;
		int[] table = new int[n + 1];
		table[0] = 1;

		for (int i = 1; i <= n; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				max = Integer.max(max, table[i - j - 1] * value[j]);

				table[i] = max;
			}
		}
		return table[n];

	}

	public static int KnapSackDPBottomUpOrderNW(int[] weight, int[] value, int W, int n) {
		int[][] table = new int[n + 1][W + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= W; j++) {
				if (j < weight[i - 1])
					table[i][j] = table[i - 1][j];
				else
					table[i][j] = Integer.max(table[i - 1][j - weight[i - 1]] + value[i - 1], table[i - 1][j]);
			}
		}
		return table[n][W];

	}

	public static int KnapSackDPTopDownApproachOrderNW(int[] weight, int[] value, int W, int n,
			HashMap<String, Integer> map) {
		if (n == 0 || W == 0)
			return 0;

		if (weight[n - 1] > W)
			return KnapSackRecursion(weight, value, W, n - 1);

		String key = n + "|" + W;
		if (!map.containsKey(key)) {

			int include = value[n - 1] + KnapSackRecursion(weight, value, W - weight[n - 1], n - 1);
			int exclude = KnapSackRecursion(weight, value, W, n - 1);
			map.put(key, Integer.max(include, exclude));
		}
		return map.get(key);
	}

	public static int KnapSackRecursion(int[] weight, int[] value, int W, int n) {
		if (n == 0 || W == 0)
			return 0;

		if (weight[n - 1] > W)
			return KnapSackRecursion(weight, value, W, n - 1);

		return Integer.max(value[n - 1] + KnapSackRecursion(weight, value, W - weight[n - 1], n - 1),
				KnapSackRecursion(weight, value, W, n - 1));
	}

	public static void longestPalindromeSubstring(String X) {
		int n = X.length();
		boolean[][] table = new boolean[n][n];
		int start = 0;
		int maxLength = 0;
		for (int i = 0; i < n; i++)
			table[i][i] = true;

		for (int i = 0; i < n - 1; i++) {
			if (X.charAt(i) == X.charAt(i + 1)) {
				table[i][i + 1] = true;
				start = i;
				maxLength = 2;
			}
		}

		for (int k = 3; k <= n; k++) {
			for (int i = 0; i < n - k + 1; i++) {
				int j = i + k - 1;
				if (table[i + 1][j - 1] && X.charAt(i) == X.charAt(j)) {
					table[i][j] = true;
					if (k > maxLength) {
						maxLength = k;
						start = i;
					}
				}
			}
		}

		System.out.println("Length of the substring is :" + maxLength);
		System.out.println(X.substring(start, maxLength - 1));

	}

	public static int longestPalindromeSequenceLengthDP(String X, HashMap<String, Integer> lookup, int i, int j) {
		if (i > j)
			return 0;

		if (i == j)
			return 1;

		String key = 1 + "|" + j;

		if (!lookup.containsKey(key)) {
			if (X.charAt(i) == X.charAt(j)) {
				lookup.put(key, longestPalindromeSequenceLengthDP(X, lookup, i + 1, j - 1) + 2);
			} else {
				lookup.put(key, Integer.max(longestPalindromeSequenceLengthDP(X, lookup, i, j - 1),
						longestPalindromeSequenceLengthDP(X, lookup, i + 1, j)));
			}

		}
		return lookup.get(key);
	}

	public static int longestPalindromeSequenceLength(String X, int i, int j) {
		if (i > j)
			return 0;

		if (i == j)
			return 1;

		if (X.charAt(i) == X.charAt(j)) {
			return longestPalindromeSequenceLength(X, i + 1, j - 1) + 2;
		}

		return Math.max(longestPalindromeSequenceLength(X, i + 1, j), longestPalindromeSequenceLength(X, i, j - 1));
	}

	public static int maxContigousSumDP_OrderN(int[] A) {
		int n = A.length;
		int[] res = new int[n];

		res[0] = A[0] > 0 ? A[0] : 0;

		for (int i = 1; i < n; i++) {
			res[i] = A[i] + res[i - 1] > 0 ? A[i] + res[i - 1] : 0;

		}

		int maxSum = 0;
		for (int i = 0; i < n; i++) {
			if (maxSum < res[i])
				maxSum = res[i];

		}
		return maxSum;
	}

	public static int maxContigousSumOrderN2(int[] A) {
		int n = A.length;

		int maxSum = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {

				sum += A[j];
				if (sum > maxSum)
					maxSum = sum;
			}
		}
		return maxSum;
	}

	public static int maxContigousSumOrderN3(int[] A) {
		int n = A.length;

		int maxSum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += A[k];
					if (sum > maxSum)
						maxSum = sum;
				}
			}
		}
		return maxSum;
	}

	public static void countPairs(int[] A, boolean[] v) {
		int n = A.length;
		int countPairs = 0;
		int minSum = Integer.MAX_VALUE;
		if (n == 0)
			System.out.println("0 0");
		else if (n == 1)
			System.out.println("0 1");
		else {

			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					if (A[j] >= 2 * A[i] && v[i] && v[j]) {
						int sum = A[i] + A[j];
						if (minSum < sum) {
							System.out.println("(" + A[i] + "," + A[j] + ")");
							v[i] = false;
							v[j] = false;
							countPairs++;
						}
					}
				}
			}
		}
		System.out.println(countPairs);
	}

	static int fact[] = new int[100];

	public static int getMaximumApples(int[][] A) {
		int m = A.length;
		int n = A[0].length;

		int[][] S = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				S[i][j] = A[i][j];

				if (i > 0 && j == 0 && S[i][j] < S[i][j] + S[i - 1][j])
					S[i][j] = S[i][j] + S[i - 1][j];

				else if (j > 0 && i == 0 && S[i][j] < S[i][j] + S[i][j - 1])
					S[i][j] = S[i][j] + S[i][j - 1];

				else if (i > 0 && j > 0)
					S[i][j] = Math.max(S[i][j] + S[i - 1][j], S[i][j] + S[i][j - 1]);
			}
		}
		return S[m - 1][n - 1];
	}

	public static int lenLCSub(char[] X, char[] Y) {
		int m = X.length;
		int n = Y.length;
		int[][] resArray = new int[m + 1][n + 1];
		int res = 0;
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					resArray[i][j] = 0;

				else if (X[i - 1] == Y[j - 1]) {
					resArray[i][j] = 1 + resArray[i - 1][j - 1];
					res = Math.max(res, resArray[i][j]);
				}
			}
		}
		return res;
	}

	public static String LCSub(char[] X, char[] Y) {
		int m = X.length;
		int n = Y.length;
		int[][] resArray = new int[m + 1][n + 1];
		int maxLength = 0;
		int endIndex = 0;
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					resArray[i][j] = 0;

				else if (X[i - 1] == Y[j - 1]) {
					resArray[i][j] = 1 + resArray[i - 1][j - 1];
					if (maxLength < resArray[i][j]) {
						maxLength = Math.max(maxLength, resArray[i][j]);
						endIndex = i;
					}
				}
			}
		}

		String s = new String(X);
		return s.substring(endIndex - maxLength, endIndex);
	}

	public static int lenLCS_DP(char[] X, char[] Y) {
		int m = X.length;
		int n = Y.length;
		int[][] LCS = new int[m + 1][n + 1];

		for (int i = 0; i < m; i++)
			LCS[i][0] = 0;
		for (int j = 0; j < n; j++)
			LCS[0][j] = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				LCS[i][j] = LCS[i - 1][j - 1];

				if (X[i - 1] == Y[j - 1])
					LCS[i][j] = 1 + LCS[i - 1][j - 1];

				if (LCS[i][j] < LCS[i - 1][j])
					LCS[i][j] = LCS[i - 1][j];

				if (LCS[i][j] < LCS[i][j - 1])
					LCS[i][j] = LCS[i][j - 1];

			}
		}

		return LCS[m][n];

	}

	public static int lenLCSRecursion(char[] X, int i, int m, char[] Y, int j, int n) {
		if (i == m || j == n)
			return 0;

		else if (X[i] == Y[j])
			return 1 + lenLCSRecursion(X, i + 1, m, Y, j + 1, n);

		else
			return Math.max(lenLCSRecursion(X, i + 1, m, Y, j, n), lenLCSRecursion(X, i, m, Y, j + 1, n));

	}

	public static int getFact(int n) {
		if (n == 0 || n == 1)
			return 1;
		if (fact[n] != 0)
			return fact[n];

		fact[n] = n * getFact(n - 1);
		return fact[n];
	}

	public static int getNthFibonacciNumber(int n) {
		int a = 0;
		int b = 1;
		int index = 2;
		int sum = a + b;
		while (index <= (n - 2)) {
			a = b;
			b = sum;
			sum = a + b;
			index++;
		}
		return sum;
	}

	static int[] fib = new int[100];

	public static int getNthFiboTopDown(int n) {

		if (n == 1 || n == 2)
			return 1;

		if (fib[n] != 0)
			return fib[n];

		fib[n] = getNthFiboTopDown(n - 1) + getNthFiboTopDown(n - 2);
		return fib[n];
	}

	public static int getNthFiboBottomUp(int n) {
		int[] fib = new int[n + 1];
		fib[0] = 0;
		fib[1] = 1;
		int index = 2;
		while (index <= n) {
			fib[index] = fib[index - 1] + fib[index - 2];
			index++;
		}
		return fib[n];
	}
}

class Size {
	int maxSize;

	public Size(int size) {
		this.maxSize = size;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

}
