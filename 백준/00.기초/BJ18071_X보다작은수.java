import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	
//	static String str = "10 5\r\n" + 
//			"1 10 4 9 2 3 8 5 7 6";
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));
		
		StringTokenizer st= new StringTokenizer(in.readLine()); 
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(a<X) sb.append(a).append(" ");
		}
		
		System.out.println(sb);
	
	}
}
