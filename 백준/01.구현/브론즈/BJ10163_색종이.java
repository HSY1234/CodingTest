import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ10163_색종이 {

//	static String str = "4\r\n" + 
//	"0 2 10 10\r\n" + 
//	"7 9 8 4\r\n" + 
//	"8 4 10 6\r\n" + 
//	"6 0 12 10";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		int[][] cor = new int[1001][1001];

		int[] area = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(in.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			for (int x = startX; x < startX + w; x++) {
				for (int y = startY; y < startY + h; y++) {
					cor[x][y] = i;
				}
			}
		}

		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				area[cor[i][j]] += 1;
			}
		}

		for (int i = 1; i < N + 1; i++) {
			sb.append(area[i]).append("\n");
		}

		System.out.println(sb);
	}
}
