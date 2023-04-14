import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ2156_포도주시식 {

	static String str = "6\r\n" + 
			"6\r\n" + 
			"10\r\n" + 
			"13\r\n" + 
			"9\r\n" + 
			"8\r\n" + 
			"1";

	public static void main(String[] args) throws Exception {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st;

		int n = Integer.parseInt(in.readLine());

		int[] wines = new int[10001];
		for (int i = 1; i < n+1; i++) {
			wines[i] = Integer.parseInt(in.readLine());
		}

		int[] dp = new int[n+1];
		
		if(n==1) {
			System.out.println(wines[1]);
			return;
		}
		if(n==2) {
			System.out.println(wines[1]+wines[2]);
			return;
		}
		
		dp[0] = 0;
		dp[1] = wines[1];
		dp[2] = wines[1]+ wines[2];
		
		for (int i = 3; i < n+1; i++) {
			dp[i] = Math.max(dp[i-3]+ wines[i]+ wines[i-1], Math.max(dp[i-1], dp[i-2]+wines[i]));
		}

		System.out.println(dp[n]);
	}

}
