package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Labyrinth {
    static int[][] move = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
    static char[] dir = {'L', 'R', 'U', 'D'};
    static char[] rev_dir = {'R', 'L', 'D', 'U'};
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        char[][] ch = new char[n][m];
        int x=0, y=0, bx = -1, by=-1;
        for (int i = 0; i < n; i++) {
            ch[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (ch[i][j] == 'A') {
                    x = i;
                    y = j;
                }
                if (ch[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        boolean[][] vis = new boolean[n][m];
        vis[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        char[][] sh = new char[n][m];

        outerloop:
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();

            for (int i = 0; i < move.length; i++) {
                int nx = pair[0]+move[i][0];
                int ny = pair[1]+move[i][1];

                boolean possible = isPossible(nx, ny, ch, vis);
                if (possible) {
                    vis[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                    sh[nx][ny] = dir[i];
                }

                if (possible && ch[pair[0]+move[i][0]][pair[1]+move[i][1]] == 'B') {
                    break outerloop;
                }
            }
        }

        if (vis[bx][by]) {
            StringBuilder sb = new StringBuilder();

            while (ch[bx][by] != 'A') {
                switch (sh[bx][by]) {
                    case 'L': {
                        sb.append(rev_dir[0]);
                        by -= 1;
                    }break;
                    case 'R': {
                        sb.append(rev_dir[1]);
                        by += 1;
                    }break;
                    case 'U': {
                        sb.append(rev_dir[2]);
                        bx -= 1;
                    }break;
                    default: {
                        sb.append(rev_dir[3]);
                        bx += 1;
                    }
                }
            }
            System.out.println("YES");
            System.out.println(sb.length());
            System.out.println(sb.reverse());
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isPossible(int i, int j, char[][] ch, boolean[][] vis) {
        return i>=0 && j>=0 && i<ch.length && j<ch[0].length && !vis[i][j] && (ch[i][j] == '.' || ch[i][j] == 'B');
    }
}
