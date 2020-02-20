
public class CaesarCipjerEnctrypor {

	private static String ceasorCipherEncryption(String S, int k)
	{
		char[] schar = S.toCharArray();
		for (int i = 0; i < schar.length; i++) {
			int ascii = ((int)schar[i]+k)%123;
			schar[i]  = ascii<97?(char)(ascii+97):(char)ascii;
		}
		
		return new String(schar);
	}
	
	public static void main(String[] args) {
System.out.println(ceasorCipherEncryption("axy", 2));
	}

}
