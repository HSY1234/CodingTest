import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputOutput {
	static String str = "10\r\n" + "1\r\n" + "2\r\n" + "3\r\n" + "4\r\n" + "5\r\n" + "6\r\n" + "7\r\n" + "8\r\n"
			+ "9\r\n" + "10";
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Input 1. 스캐너를 쓰는 방법
		Scanner sc = new Scanner(System.in);
		System.out.println();
		int a =sc.nextInt();
		double b =sc.nextDouble();
		String s =sc.next();
		
		// Input 2. BufferedReader를 쓰는 방법 => 추천
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// Input 3. StringReader로 직접 테스트 케이스 하나만 해보기
		in = new BufferedReader(new StringReader(str));
		
		// String은 형변환이 필요하다!
		int T = Integer.parseInt(in.readLine());
		
		// OutPut은 한번에 진행되는게 좋기때문에 
		StringBuilder sb = new StringBuilder();
		// 줄 단위로 읽어온 String을 토큰화 시킴
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			// OutPut에 추가
			sb.append("#").append(tc).append(" ");
//			int N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			// int A = Integer.parseInt(st.nextToken());
		}
		
		// Output은 한번에 하는게 빠르다
		System.out.println(sb);
	}
}
