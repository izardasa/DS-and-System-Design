
public class Anagram {
	public static boolean anagram(String str1, String str2)
	{
		int[] arr1 = new int[26];
		int[] arr2 = new int[26];
		
		if(str1.length() != str2.length())
			return false;
		
		for (int i = 0; i < str1.length(); i++) {
			arr1[str1.charAt(i)-'a']++;
			arr2[str2.charAt(i)-'a']++;
		}
		
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i]!=arr2[i])
				return false;
		}
		return true;
		
	}
	public static void main(String[] args)
	{
		int a[] = null;
		for(int num : a)
			System.out.println(num);
				
		System.out.println(anagram("abcdefa","defbcaa"));
	}

}
