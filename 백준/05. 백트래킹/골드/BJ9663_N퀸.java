import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

//	static String str = "4";
	
	static boolean [] column;// 세로줄 체크
	static boolean [] dia1;// 왼쪽위에서 오른쪽아래로 대각선
	static boolean [] dia2;// 오른쪽위에서 왼쪽아래로 대각선
	static int count = 0;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		N = Integer.parseInt(in.readLine());
		
		column = new boolean[N];
		dia1 = new boolean[2*N-1];
		dia2 = new boolean[2*N-1];
		func(0);
		System.out.println(count);
	}

	static void func(int now) {
		if(now == N) {
			count++;
			return;
		}
		
		for (int i = 0; i <N ; i++) {
			if(column[i]) continue;
			if(dia1[now+i]) continue;
			if(dia2[N-now+i-1]) continue;
			column[i] = true;
			dia1[now+i] = true;
			dia2[N-now+i-1] = true;
			func(now+1);
			column[i] = false;
			dia1[now+i] = false;
			dia2[N-now+i-1] = false;
		}
	}
}
