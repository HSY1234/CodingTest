import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	// 거리 dist 배열로 풀기
	// dfs 단계가 아니고 그냥 큐가 빌때까지

//	static String str = "7 7\r\n" + "1011111\r\n" + "1110001\r\n" + "1000001\r\n" + "1000001\r\n" + "1000001\r\n"
//			+ "1000001\r\n" + "1111111";

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int[][] dist = new int[N][M];

		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], -1);
		}

		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		Queue<int[]> q = new LinkedList<>();

		dist[0][0] = 0;
		q.add(new int[] { 0, 0 });

		while (!q.isEmpty()) {

			int[] now = q.poll();

			int x = now[0];
			int y = now[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (dist[nx][ny]>=0 || map[nx][ny] == 0)
					continue;

				dist[nx][ny] = dist[x][y]+1;
				q.offer(new int[] { nx, ny });

			}
			

		}
		
		System.out.println(dist[N-1][M-1]+1);

	}

}
