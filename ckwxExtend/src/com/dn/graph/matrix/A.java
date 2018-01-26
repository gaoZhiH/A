package com.dn.graph.matrix;

import java.util.Scanner;

public class A {
	private static final int MAXN = 100;
	private static final int INF = 1000000;
	private static int[][] map = new int[MAXN][MAXN];
	private static int[] lowcost = new int[MAXN];
	private static int[] nearvex = new int[MAXN];
	private static int n, m;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			n = scan.nextInt();
			m = scan.nextInt();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j) {
						map[i][j] = 0;
					} else {
						map[i][j] = INF;
						map[j][i] = INF;
					}
				}
			}

			for (int i = 0; i < m; i++) {
				int u = scan.nextInt();
				int v = scan.nextInt();
				int w = scan.nextInt();
				map[u - 1][v - 1] = w;
				map[v - 1][u - 1] = w;
			}
			prim(0);
		}

	}

	static void prim(int u) {
		int sum = 0;
		int min = 0;
		for (int i = 0; i < n; i++) {
			lowcost[i] = map[u][i];
			nearvex[i] = u;
		}
		nearvex[u] = -1;
		for (int i = 0; i < n - 1; i++) {
			int u0 = -1;
			min = 1000000;
			for (int j = 0; j < n; j++) {
				if (lowcost[j] < min && nearvex[j] != -1) {
					u0 = j;
					min = lowcost[j];
				}
			}

			if (u0 != -1) {
				sum += lowcost[u0];
				nearvex[u0] = -1;
				for (int k = 0; k < n; k++) {
					if (nearvex[k] != -1 && map[u0][k] < lowcost[k]) {
						lowcost[k] = map[u0][k];
						nearvex[k] = u0;
					}
				}
			}
		}
		System.out.println("the length of MST is " + sum);
	}
}