import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

	static String str = "3";
	static StringBuilder sb = new StringBuilder(); 
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		int N = Integer.parseInt(in.readLine());
		sb.append(((1<<N)-1)).append("\n");
		move(N,1,3);
		System.out.println(sb);
	}
	
	static void move(int n, int start, int end) {
		if(n==1) {
			sb.append(start).append(" ").append(end).append("\n");
			return;
		}
		
		move(n-1, start, 6-start-end);
		
		sb.append(start).append(" ").append(end).append("\n");
		
		move(n-1, 6-start-end, end);
	}
}
