import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		sb.append(a+b).append("\n");
		sb.append(a-b).append("\n");
		sb.append(a*b).append("\n");
		sb.append(a/b).append("\n");
		sb.append(a%b).append("\n");
		System.out.println(sb);
	}

}
