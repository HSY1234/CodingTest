import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main {

//	static String str = "aabbcc\r\n" + 
//			"xxyybb";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		String a = in.readLine();
		String b = in.readLine();
		
		int[] arrA = new int[26];
		int[] arrB = new int[26];
		
		for (int i = 0; i < a.length(); i++) {
			arrA[a.charAt(i)-'a']++;
		}
		
		for (int i = 0; i < b.length(); i++) {
			arrB[b.charAt(i)-'a']++;
		}
		
		int result = 0;
		for (int i = 0; i < 26; i++) {
			result += Math.abs(arrA[i]-arrB[i]);
		}
		
		System.out.println(result);
	}

}
