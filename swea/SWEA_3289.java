package swea;

import java.util.Scanner;

public class SWEA_3289 {
	static int[] parents;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		int N;
		int M;
		

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			N = sc.nextInt();
			M = sc.nextInt();
			parents = new int[N];
			for (int n = 0; n < N; n++) {
				parents[n] = n;
			}

			for (int j = 0; j < M; j++) {
				int type = sc.nextInt();
				if (type == 0)
					union(sc.nextInt()-1, sc.nextInt()-1);
				else
					sb.append(isSameGroup(sc.nextInt()-1, sc.nextInt()-1));
			}

			sb.append("\n");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.print(sb);
	}

	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot != bRoot) parents[bRoot]=aRoot;
	}
	
	// 
	static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a]=find(parents[a]);
	}
	static int isSameGroup(int a, int b) {
		return find(a)==find(b) ? 1:0;
	}

}
