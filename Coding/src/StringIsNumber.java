import javax.swing.text.ChangedCharSetException;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class StringIsNumber {

	private static boolean isDigit(char c)
	{
		int d = (int)c-(int)'0';
		if(d>=0 && d<=9)
			return true;
		
		return false;
	}
	
	private static boolean checkStringIsNumber(String str)
	{
		for (int i = 0; i < str.length(); i++) {
			if(!isDigit(str.charAt(i)))
				return false;
				
		}
		
		return true;
	}
	public static void main(String[] args) {
		System.out.println(checkStringIsNumber("123423"));
	}

}
