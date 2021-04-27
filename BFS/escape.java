package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Beads{
	int rx;
	int ry;
	int bx;
	int by;
	public Beads(int rx, int ry, int bx, int by) {
		super();
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
	}
	
}
public class escape {
	public static int N,M;//세로, 가로
	public static char[][] map;
	public static boolean[][][][] visit;
	public static int[] dx= {0,0,1,-1};
	public static int[] dy= {1,-1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new char[N][M];
		visit=new boolean[N][M][N][M];
		Queue<Beads> q=new LinkedList<Beads>();
		int init_rx=0;
		int init_ry=0;
		int init_bx=0;
		int init_by=0;
		for(int i=0; i<N; i++) {
			String s=br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='R') {
					map[i][j]='.';
					init_rx=i; init_ry=j;
				}
				if(map[i][j]=='B') {
					map[i][j]='.';
					init_bx=i; init_by=j;
				}
			}
		}//입력끝
		visit[init_rx][init_ry][init_bx][init_by]=true;
		q.offer(new Beads(init_rx,init_ry,init_bx,init_by));
		int cnt=1;
		loop:
		while(!q.isEmpty()) {
			int qSize=q.size();
			while(qSize-->0) {
				Beads bead=q.poll();
				for(int i=0; i<4; i++) {
					//빨간구슬
					int rCnt=0, bCnt=0;
					int rx=bead.rx;
					int ry=bead.ry;
					int bx=bead.bx;
					int by=bead.by;
					while(true) {
						int r_nx=rx+dx[i];
						int r_ny=ry+dy[i];
						if(i==2) {
						}
						if(map[r_nx][r_ny]=='#')break;
						rx=r_nx;
						ry=r_ny;
						rCnt++;
						if(map[rx][ry]=='O') break;
					}
					while(true) {
						int b_nx=bx+dx[i];
						int b_ny=by+dy[i];
						if(map[b_nx][b_ny]=='#')break;
						bx=b_nx;
						by=b_ny;
						bCnt++;
						if(map[bx][by]=='O') break;
					}
					//구슬 이동 끝
					if(map[bx][by]=='O') {
						//파란 구슬이 구멍에 빠지면
						continue;
					}
					if(map[rx][ry]=='O') {
						//빨간 구슬이 구멍에 빠지면
						System.out.println(cnt);
						System.exit(0);
					}
					if((rx==bead.rx && ry==bead.ry) && (bx==bead.bx && by==bead.by))continue;
					if(rx==bx && ry==by) {
						//둘이 같은 곳에 멈췄으면
						int dir=0;
						if(i==0) dir=1;
						else if(i==1) dir=0;
						else if(i==2) dir=3;
						else if(i==3) dir=2;
						if(rCnt>bCnt) {
							rx+=dx[dir];
							ry+=dy[dir];
						}else if(bCnt>rCnt) {
							bx+=dx[dir];
							by+=dy[dir];
						}
					}
					
					if(visit[rx][ry][bx][by]==true)continue;
					visit[rx][ry][bx][by]=true;
					q.offer(new Beads(rx,ry,bx,by));
				}
			}
			cnt++;
			if(cnt>10) break loop;
		}
		System.out.println(-1);
	}

}

/*
5 5
#####
#...#
##O.#
#RB.#
#####

*/