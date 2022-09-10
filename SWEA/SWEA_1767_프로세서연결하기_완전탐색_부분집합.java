import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
//	static String str = "1\r\n" + 
//			"5\r\n" + 
//			"0 0 0 0 0\r\n" + 
//			"0 0 0 0 0\r\n" + 
//			"0 0 0 0 0\r\n" + 
//			"0 0 0 0 0\r\n" + 
//			"0 0 0 0 0";
	
	public static int[] dx= {-1,1,0,0};
	public static int[] dy= {0,0,-1,1};
	
	public static int min = Integer.MAX_VALUE;
	public static int maxConnect = 0;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));

		int T = Integer.parseInt(in.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			min = Integer.MAX_VALUE;
			maxConnect = 0;
			
			int N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Core[] cList = new Core[13];// 0번째 인덱스는 안씀
			int CoreNum =0;
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < N-1; j++) {
					if(map[i][j]==1) {
						cList[++CoreNum] = new Core(i,j);
					}
				}
			}
			
			dfs(map,N,cList,CoreNum,1,0,0);
			sb.append(min).append('\n');
			
			
		}
		System.out.println(sb);
	}
	
	public static void dfs(int[][] map, int N, Core[] cList, int CoreNum, int cnt, int connectCore, int wire) {
		
		if(cnt>CoreNum) {
			if(maxConnect<connectCore) {
				min =wire;
				maxConnect = connectCore;
			}
			else if(maxConnect == connectCore) {
				if(min>wire) {
					min = wire;
				}
			}
			return;
		}
		
		Core now = cList[cnt];
		int x = now.x;
		int y = now.y;
		
		for (int i = 0; i < 4; i++) {// 4방향 연결
			boolean canConnect= true;
			int addwire = 0;
			int nx = x+dx[i];
			int ny = y+dy[i];
			while(true) {
				if(map[nx][ny]==1) {
					canConnect = false;
					break;
				}
				
				addwire++;
				
				if(nx==0||ny==0||nx==N-1||ny==N-1) {
					break;
				}
				
				nx = nx+dx[i];
				ny = ny+dy[i];
			}
			
			if(canConnect) {
				nx = x+dx[i];
				ny = y+dy[i];
				while(true) {
					map[nx][ny] = 1;
					if(nx==0||ny==0||nx==N-1||ny==N-1) {
						break;
					}
					nx = nx+dx[i];
					ny = ny+dy[i];
				}
				
				dfs(map,N,cList,CoreNum,cnt+1,connectCore+1,wire+addwire);
				
				nx = x+dx[i];
				ny = y+dy[i];
				
				while(true) {
					map[nx][ny] = 0;
					if(nx==0||ny==0||nx==N-1||ny==N-1) {
						break;
					}
					nx = nx+dx[i];
					ny = ny+dy[i];
				}
			}
		}
		
		dfs(map,N,cList,CoreNum,cnt+1,connectCore,wire);
		
		
	}
	
	public static class Core{
		int x;
		int y;
		
		public Core(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	
}
