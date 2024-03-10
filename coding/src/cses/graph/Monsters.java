//package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Monsters {
    static int[][] move = {{1,0}, {-1, 0}, {0,1}, {0,-1}};
    static char[] track = {'D', 'U', 'R', 'L'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        char[][] ch = new char[n][m];

        boolean[][] vis = new boolean[n][m];
        int[][] path = new int[n][m];
        char[][] res = new char[n][m];

        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> monstors = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            ch[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (ch[i][j] == 'A') {
                    queue.add(new int[]{i, j, 0});
                } else if (ch[i][j] == 'M') {
                    monstors.add(new int[]{i, j, 0});
                }
            }
        }

        initialize(path);
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();

            vis[pair[0]][pair[1]] = true;
            path[pair[0]][pair[1]] = Math.min(pair[2]+1, path[pair[0]][pair[1]]);

            for (int i = 0; i < move.length; i++) {
                int x = pair[0]+move[i][0], y = pair[1]+move[i][1];
                boolean possible = isPossible(x, y, vis, ch);

                if (possible) {
                    queue.add(new int[]{x, y, pair[2]+1});
                    res[x][y] = track[i];
                }
            }
        }
        int[][] mpath = new int[n][m];
        initialize(mpath);
        boolean[][] vis2 = new boolean[n][m];

        while (!monstors.isEmpty()) {
            int[] pair = monstors.poll();
            Queue<int[]> monstor = new LinkedList<>();
            monstor.add(pair);
            while (!monstor.isEmpty()) {
                int[] pair2 = monstor.poll();
                vis2[pair2[0]][pair2[1]] = true;
                mpath[pair2[0]][pair2[1]] = Math.min(pair2[2]+1, mpath[pair2[0]][pair2[1]]);

                for (int i = 0; i < move.length; i++) {
                    int x = pair2[0]+move[i][0], y = pair2[1]+move[i][1];
                    boolean possible = isPossible(x, y, vis2, ch);

                    if (possible) {
                        monstor.add(new int[]{x, y, pair2[2]+1});
                    }
                }
            }
        }

        int max = n*m;
        int x = -1, y = -1;
        for (int i = 0; i < n; i++) {
            if ((path[i][0] < mpath[i][0] && path[i][0] != max) || (path[i][0] != max && mpath[i][0] == max)) {
                x = i;
                y = 0;
            }
            if (path[i][m-1] < mpath[i][m-1] && path[i][m-1] != max || (path[i][m-1] != max && mpath[i][m-1] == max)) {
                x = i;
                y = m-1;
            }
        }
        for (int i = 0; i < m; i++) {
            if (path[0][i] < mpath[0][i] && path[0][i] != max || (path[0][i] != max && mpath[0][i] == max)) {
                x = 0;
                y = i;
            }
            if (path[n-1][i] < mpath[n-1][i] && path[n-1][i] != max || (path[n-1][i] != max && mpath[n-1][i] == max)) {
                x = n-1;
                y = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (x == -1 && y == -1) {
            System.out.println("NO");
            return;
        }
//        disp(path);
//        System.out.println("DAKU");
//        disp(mpath);

        while (ch[x][y] != 'A') {
            sb.append(res[x][y]);

            if (res[x][y] == 'R') {
                y--;
            } else if (res[x][y] == 'D') {
                x--;
            } else if (res[x][y] == 'L') {
                y++;
            } else {
                x++;
            }
        }
        System.out.println("YES\n" + sb.length());
        System.out.println(sb.reverse());
    }

    private static void display(char[][] path) {
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[0].length; j++) {
                System.out.printf(path[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void initialize(int[][] mpath) {
        for (int i = 0; i < mpath.length; i++) {
            for (int j = 0; j < mpath[0].length; j++) {
                mpath[i][j] = mpath.length*mpath[0].length;
            }
        }
    }

    private static void disp(int[][] path) {
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[0].length; j++) {
                System.out.printf(path[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean isPossible(int x, int y, boolean[][] vis, char[][] ch) {
        return x>=0 && y>=0 && x<ch.length && y<ch[0].length && !vis[x][y] && ch[x][y] == '.';
    }


}
