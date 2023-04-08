import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ13300_방배정 {
	
//	static String str = "3 3\r\n" + 
//			"0 3\r\n" + 
//			"1 5\r\n" + 
//			"0 6";
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int [][] student = new int[2][7];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			student[gender][year]++;
		}
		
		int result = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 7; j++) {
				result+=calRoom(student[i][j], K);
			}
		}
		
		System.out.println(result);
		
		
		
	}
	
	public static int calRoom(int num, int K) {
		if(num%K==0) return num/K;
		else {
			return num/K+1;
		}
	}
}
