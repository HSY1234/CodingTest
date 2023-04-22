import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

//	static String str = "4\r\n" + 
//			"a a\r\n" + 
//			"ab ba\r\n" + 
//			"ring gnir\r\n" + 
//			"newt twan";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		
		for (int t = 0; t < n; t++) {
			st = new StringTokenizer(in.readLine());
			String before = st.nextToken();
			String after = st.nextToken();
			
			int[] beforeArr = new int[26]; 
			int[] afterArr = new int[26];
			
			if(before.length() != after.length()) {
				sb.append("Impossible").append("\n");
				continue;
			}
			
			for (int i = 0; i < before.length() ; i++) {
				beforeArr[before.charAt(i)-'a']++;
				afterArr[after.charAt(i)-'a']++;
			}
			
			boolean check = false;
			
			for (int i = 0; i < 26; i++) {
				if(beforeArr[i] != afterArr[i]) {
					sb.append("Impossible").append("\n");
					check = true;
					break;
				}
				if(check) break;
			}
			
			if(!check) sb.append("Possible").append("\n");
		}
		
		System.out.println(sb);
	}

}
