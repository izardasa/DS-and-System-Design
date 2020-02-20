package recursive;

public class PalindromePartition {

	private int findMPPCut(String str) {
		return findMPPCut(str, 0, str.length() - 1);

	}

	private int findMPPCut(String str, int start, int end) {
		if (start > end || isPalindrome(str, start, end))
			return 0;

		if (start == end)
			return 1;

		int minCuts = end-start;
		for (int i = start; i <= end; i++) {

			if (isPalindrome(str, start, i)) {
				minCuts = Math.min(minCuts, 1 + findMPPCut(str, i + 1, end));
			}

		}
		return minCuts;
	}

	private boolean isPalindrome(String str, int start, int end) {
		if (start > end)
			return false;

		while (start < end) {
			if (str.charAt(start++) != str.charAt(end--))
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		PalindromePartition palindromePartition = new PalindromePartition();
		System.out.println(palindromePartition.findMPPCut("abdbca"));
		System.out.println(palindromePartition.findMPPCut("cddpd"));
		System.out.println(palindromePartition.findMPPCut("pqr"));
		System.out.println(palindromePartition.findMPPCut("pp"));
	}

}
