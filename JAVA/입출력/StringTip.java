import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class StringTip {
	static String str = "10\r\n" + "1\r\n" + "2\r\n" + "3\r\n" + "4\r\n" + "5\r\n" + "6\r\n" + "7\r\n" + "8\r\n"
			+ "9\r\n" + "10";

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(str));

//		int T = Integer.parseInt(in.readLine());

//		1. 한번에 배열로 바꾸기
		char charList[] = in.readLine().toCharArray();

//		2. StringTokenizer 처리
		StringTokenizer st;
		st = new StringTokenizer(in.readLine(), "구분자");

		int a = Integer.parseInt(st.nextToken()); // nextToken으로 하나씩 다음 문자열 받기

//		3. StringBuilder
		// Output은 한번에 하는게 빠르다
//		StringBuilder는 자바에서 상수취급되는 String을 생성하지 않는다.
		StringBuilder sb = new StringBuilder();
		
//		3-1 StringBuilder는 append()후 자기자신 반환해서 계속사용가능 
		sb.append("1").append("2").append("\n");

//		3-2 toString()
		System.out.println(sb.toString());
		
//		3-3 setLength() 함수
		sb.setLength(sb.length()-2);// 뒤에 두글자 지우기
	}
}
