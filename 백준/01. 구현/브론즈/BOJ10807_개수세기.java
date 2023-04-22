import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

//	static String str = "11\r\n" + 
//			"1 4 1 2 4 2 4 2 3 4 4\r\n" + 
//			"2";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		
		int[] arr = new int[201];
		
		
		st = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[Integer.parseInt(st.nextToken())+100]++;
		}
		
		int v = Integer.parseInt(in.readLine());
		
		System.out.println(arr[v+100]);
		
	}

}
