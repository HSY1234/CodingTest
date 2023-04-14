import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ12852_1로만들기2 {

//	static String str = "10";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringBuilder sb = new StringBuilder();
		
		int x = Integer.parseInt(in.readLine());
		
		int dp[] = new int [x+1];
		int from[] = new int [x+1];
		dp[1] = 0;
		from[1] = 0;
		
		
		for (int i = 2; i < x+1; i++) {
			dp[i] = dp[i - 1] + 1;
			from[i] = i-1;
			if(i%2==0 && dp[i]>dp[i/2]+1) {
				dp[i] = dp[i/2]+1;
				from[i] = i/2;
			}
			if(i%3==0 && dp[i]>dp[i/3]+1) {
				dp[i] = dp[i/3]+1;
				from[i] = i/3;
			}
		}
		sb.append(dp[x]).append("\n");
		int result = x;
		sb.append(x).append(" ");
		while(result!=1) {
			result = from[result];
			sb.append(result).append(" ");
		}
		System.out.println(sb);
	}

}

