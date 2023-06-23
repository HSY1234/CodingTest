import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.ListIterator;


public class BOJ5397_키로거 {

//	static String str = "2\r\n" + 
//			"<<BP<A>>Cd-\r\n" + 
//			"ThIsIsS3Cr3t";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));
		
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(in.readLine());
		for (int t = 0; t < tc; t++) {
			String log = in.readLine();
			LinkedList<Character> password = new LinkedList<>();
			ListIterator<Character> iter = password.listIterator();
			
			for (int i = 0; i < log.length(); i++) {
				char temp = log.charAt(i);
				if(temp == '<') {
					if(iter.hasPrevious()) iter.previous();
				}
				else if(temp == '>') {
					if(iter.hasNext()) iter.next();
				}
				else if(temp == '-') {
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
				}
				else {
					iter.add(temp);
				}
			}

			for(char c : password) {
				sb.append(c);
			}
			
			sb.append('\n');
			
			
		}
		System.out.println(sb.toString());
	}

}
