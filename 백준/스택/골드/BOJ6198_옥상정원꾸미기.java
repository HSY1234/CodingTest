import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ6198_옥상정원꾸미기 {

	static String str = "10\r\n" + 
			"5\r\n" + 
			"1\r\n" + 
			"4\r\n" + 
			"1\r\n" + 
			"3\r\n" + 
			"1\r\n" + 
			"2\r\n" + 
			"1\r\n" + 
			"1\r\n" + 
			"1";

	public static void main(String[] args) throws Exception {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new StringReader(str));
		
		int N = Integer.parseInt(in.readLine());
		
		long result = 0;
		
		Stack<Integer> s = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(in.readLine());
			while(!s.isEmpty()&&s.peek()<=height) {
				s.pop();
			}

			result+=s.size();
			
			s.push(height);

		}
		
		System.out.println(result);
		
	}

}
