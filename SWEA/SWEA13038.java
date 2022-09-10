import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW13038 {
//	static String str =
//			"3\r\n" + 
//			"2\r\n" + 
//			"0 1 0 0 0 0 0\r\n" + 
//			"100000\r\n" + 
//			"1 0 0 0 1 0 1\r\n" + 
//			"1\r\n" + 
//			"1 0 0 0 0 0 0"; 
	public static void main(String args[]) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T  = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T;tc++) {
			int n = Integer.parseInt(in.readLine());
			int[] week = new int[7];
			st = new StringTokenizer(in.readLine());
			
			for (int i = 0; i < week.length; i++) {
				week[i] = Integer.parseInt(st.nextToken());
				
			}
			
			int min = Integer.MAX_VALUE;
			
			for (int start = 0; start < 7; start++) {
				if(week[start]==0) continue;
				
				int day =start, cnt=0;
				while(true) {
					if(week[day% 7] ==1 ) cnt++;
					
					++day;
					if(cnt == n) {
						min = Math.min(min,day-start);
		
						break;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
