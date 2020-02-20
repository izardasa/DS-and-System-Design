import java.util.Arrays;
import java.util.List;

public class ReverseWord {

	private static void reverseWords(String statement)
	{
		List<String> words = Arrays.asList(statement.split(" "));
		
		
		for (int i = words.size()-1; i >= 0; i--) {
			System.out.println(words.get(i));
		}
	}
	public static void main(String[] args) {
		reverseWords("I work in Microsoft");

	}

}
