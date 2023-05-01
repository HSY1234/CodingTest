import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class BOJ10773_제로 {

//	static String str = "10\r\n" + 
//			"0\r\n" + 
//			"3\r\n" + 
//			"5\r\n" + 
//			"4\r\n" + 
//			"0\r\n" + 
//			"0\r\n" + 
//			"7\r\n" + 
//			"0\r\n" + 
//			"0\r\n" + 
//			"6";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		int k = Integer.parseInt(in.readLine());
		
		Stack<Long> st = new Stack<>();
		
		for (int i = 0; i < k; i++) {
			long x = Long.parseLong(in.readLine());
			if(x == 0 && !st.isEmpty()) {
				long temp = st.pop();
			}
			else {
				st.push(x);
			}
		}
		
		long result = 0;
		
		int size = st.size();
		
		for (int i = 0; i < size; i++) {
			long temp = st.pop();
			result += temp;
		}
		
		System.out.println(result);
	}

}
