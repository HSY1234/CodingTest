import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ14696_딱지놀이 {
	
//	static String str ="4\r\n" + 
//			"4 4 3 2 1\r\n" + 
//			"4 1 4 3 2\r\n" + 
//			"4 3 3 2 1\r\n" + 
//			"4 4 3 3 3\r\n" + 
//			"4 4 3 3 3\r\n" + 
//			"4 3 4 3 2\r\n" + 
//			"4 3 2 1 1\r\n" + 
//			"3 3 2 1";
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());	
		
		for (int round = 0; round < N; round++) {
			
			int [] A = new int[5];
			int [] B = new int[5];
			
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < a; i++) {
				int value = Integer.parseInt(st.nextToken());
				A[value]++;
			}
			
			st = new StringTokenizer(in.readLine());
			int b = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < b; i++) {
				int value = Integer.parseInt(st.nextToken());
				B[value]++;
			}
			
			sb.append(fight(A,B)).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	public static String fight(int [] A, int [] B) {
		for (int i = 4; i >0 ; i--) {
			if(A[i]>B[i]) return "A";
			if(A[i]<B[i]) return "B";
		}
		
		return "D";
	}
	
}
