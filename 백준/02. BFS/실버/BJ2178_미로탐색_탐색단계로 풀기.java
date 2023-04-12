import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

//	static String str = "7 7\r\n" + 
//			"1011111\r\n" + 
//			"1110001\r\n" + 
//			"1000001\r\n" + 
//			"1000001\r\n" + 
//			"1000001\r\n" + 
//			"1000001\r\n" + 
//			"1111111";

	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] =  s.charAt(j)-'0';
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		
		visited[0][0] = true;
		q.add(new int[] {0,0});
		
		int result = 1; 
		
		while(!q.isEmpty()) {
			result++;

			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] now = q.poll();
				
				int x = now[0];
				int y= now[1];
				
				for (int j = 0; j < 4; j++) {
					int nx = x+ dx[j];
					int ny = y+ dy[j];
					
					if(nx<0||nx>=N||ny<0||ny>=M) continue;
					if(visited[nx][ny]||map[nx][ny]==0) continue;
					
					visited[nx][ny] = true;
					q.offer(new int[] {nx,ny});	
					
					
					if(nx==N-1&&ny==M-1) {
						System.out.println(result);
						return;
					}
				}
				
			}
			
		}
		
	}

}

