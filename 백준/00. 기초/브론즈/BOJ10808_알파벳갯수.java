import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

	static String str = "";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));
		
		StringBuilder sb = new StringBuilder();
		
		int[] counter = new int[26];
		
		String S = in.readLine();
		
		for (int i = 0; i < S.length(); i++) {
			counter[S.charAt(i)-'a']++;
		}
		
		for (int i = 0; i < counter.length; i++) {
			sb.append(counter[i]).append(" ");
		}
		
		System.out.println(sb);
		
	}

}

