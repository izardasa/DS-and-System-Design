
public class ReverseStringRecursive {
	public static String reverse(String str)
	{
		if(str.length()<2)
			return str;
		
		return str.substring(1)+str.charAt(0);
	}
	public static void main(String[] args)
	{
		System.out.println(reverse("sanjay"));
	}

}
