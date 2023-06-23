import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ10828_스택 {

//	static String str = "14\r\n" + 
//			"push 1\r\n" + 
//			"push 2\r\n" + 
//			"top\r\n" + 
//			"size\r\n" + 
//			"empty\r\n" + 
//			"pop\r\n" + 
//			"pop\r\n" + 
//			"pop\r\n" + 
//			"size\r\n" + 
//			"empty\r\n" + 
//			"pop\r\n" + 
//			"push 3\r\n" + 
//			"empty\r\n" + 
//			"top";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		Stack<Integer> s = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			String keyword = st.nextToken();
			if(keyword.equals("push")) {
				s.push(Integer.parseInt(st.nextToken()));
			}
			else if(keyword.equals("pop")) {
				if(s.isEmpty()) sb.append("-1\n");
				else {
					sb.append(s.pop()).append('\n');
				}
			}
			else if(keyword.equals("size")) {
				sb.append(s.size()).append('\n');
			}
			else if(keyword.equals("empty")) {
				if(s.isEmpty()) sb.append("1\n");
				else {
					sb.append('0').append('\n');
				}
			}
			else if(keyword.equals("top")) {
				if(s.isEmpty()) sb.append("-1\n");
				else {
					sb.append(s.peek()).append('\n');
				}
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
