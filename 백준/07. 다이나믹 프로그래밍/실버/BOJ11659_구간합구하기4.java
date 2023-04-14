import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ11659_구간합구하기4 {

//	static String str = "1 1\r\n" + 
//			"5\r\n" + 
//			"1 1\r\n";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		
		int[] arr = new int[100001];
		
		for (int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[100001];
		
		for (int i = 1; i < dp.length; i++) {
			dp[i] = dp[i-1] + arr[i];
		}
		
		for (int t = 0; t < M; t++) {
			st = new StringTokenizer(in.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			sb.append(dp[j]-dp[i-1]).append("\n");
		}
		System.out.println(sb);
		
	}

}
