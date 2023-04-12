import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	static String str = "5 4\r\n" + 
			"####\r\n" + 
			"#...\r\n" + 
			"#.##\r\n" + 
			"#.J#\r\n" + 
			"####" ;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(str));

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int [][] map = new int [R][C];
		Queue<int[]> J = new LinkedList<int[]>();
		Queue<int[]> F = new LinkedList<int[]>();
		boolean[][] visited  = new boolean[R][C];
		for (int i = 0; i < R; i++) {
				String line = in.readLine();
			for (int j = 0; j < C; j++) {
				if(line.charAt(j) == '#') map[i][j] = -1;
				if(line.charAt(j) == '.') map[i][j] = 0;
				if(line.charAt(j) == 'F') {
					F.offer(new int[] {i,j});
					map[i][j] = -1;
				}
				if(line.charAt(j) == 'J') {
					J.offer(new int[] {i,j});
					visited[i][j] = true;
				}
				
			}
			
		}
		boolean status = false; // 탈출 여부 
		int time = 0;// 걸린 시간
		
		int[] check = J.peek();
		if(check[0]==R-1 || check[0]==0 || check[1]== C-1 || check[1] == 0) status =true;
		while(!J.isEmpty()) {
			time++;
			if(status) break;
			int fsize = F.size();
			int jsize = J.size();
			for (int i = 0; i < fsize; i++) {
				int[] n = F.poll();
				
				for (int j = 0; j < 4; j++) {
					int nx = n[0]+dx[j];
					int ny = n[1]+dy[j];
					
					if(nx<0 || nx>=R || ny<0 || ny>=C) continue;
					if(map[nx][ny] == -1) continue;
					map[nx][ny] = -1;
					F.offer(new int [] {nx,ny});
					
				}
			}
			
			for (int i = 0; i < jsize; i++) {
				int[] n = J.poll();
				
				for (int j = 0; j < 4; j++) {
					int nx = n[0]+dx[j];
					int ny = n[1]+dy[j];
					
					if(nx<0 || nx>=R || ny<0 || ny>=C) continue;
					if(visited[nx][ny] || map[nx][ny]==-1) continue;
					visited[nx][ny] = true;
					J.offer(new int [] {nx,ny});
					if(nx==R-1 || nx==0 || ny== C-1 || ny == 0) status =true;
				}
				
			}
			
		}
		
		if(status) System.out.println(time);
		else System.out.println("IMPOSSIBLE");
		
		
	}

}