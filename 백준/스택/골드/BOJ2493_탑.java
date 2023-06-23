import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493_탑 {

//	static String str = "5\r\n" + 
//			"6 9 5 7 4";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		
		Stack<Integer> height = new Stack<>();
		height.push(Integer.MAX_VALUE);
		Stack<Integer> index = new Stack<>();
		index.push(0);
		
		st = new StringTokenizer(in.readLine());
		
		for (int i = 1; i <= N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			while(temp> height.peek()) {
				height.pop();
				index.pop();
			}
			sb.append(index.peek()).append(' ');
			height.push(temp);
			index.push(i);
		}
		System.out.println(sb.toString());
	}

}
