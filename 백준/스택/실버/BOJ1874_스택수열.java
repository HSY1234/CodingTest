import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1874_스택수열 {

//	static String str = "8\r\n" + 
//			"4\r\n" + 
//			"3\r\n" + 
//			"6\r\n" + 
//			"8\r\n" + 
//			"7\r\n" + 
//			"5\r\n" + 
//			"2\r\n" + 
//			"1";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> s = new Stack<>();
		
		s.push(1);
		
		int now = 1;
		
		int n = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(in.readLine());

			if(a>=now) {
				while(a>=now) {
					s.push(now++);
					sb.append("+").append('\n');
				}
			}
			
			if(s.peek()!=a) {
				System.out.println("NO");
				return;
			}
			s.pop();
			sb.append("-").append('\n');
			
//			if(!s.isEmpty() && a==s.peek()) {
//				sb.append("-").append('\n');
//				s.pop();
//				continue;
//			}
//			
//			if(!s.isEmpty() && a<s.peek()) {
//				if(s.pop()!=a) {
//					System.out.println("NO");
//					return;
//				}
//				sb.append("-").append('\n');
//			}
		}
		System.out.println(sb.toString());
		
	}

}
