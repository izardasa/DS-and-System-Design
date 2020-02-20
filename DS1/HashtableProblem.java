
public class HashtableProblem {

	public static void main(String[] args) {
		printFirstDuplicate("sanjay".toCharArray());

	}
	
	public static void printFirstDuplicate(char[] str)
	{
		int[] charArray = new int[256];
		
		for(int i =0;i<256;i++)
		{
			if(charArray[str[i]]==1)
			{
				System.out.println(str[i]);
				break;
			}
			charArray[str[i]]++;
		}
	}

}
