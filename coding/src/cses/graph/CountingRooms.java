package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class CountingRooms {

    static int[][] move = {{0,1}, {0,-1}, {1,0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        char[][] ch = new char[n][m];

        for (int i = 0; i < n; i++) {
            ch[i] = br.readLine().toCharArray();
        }

        boolean[][] vis = new boolean[n][m];
        int count = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ch[i][j] == '.' && !vis[i][j]) {
                    vis[i][j] = true;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] pair = queue.poll();
                        for (int[] ints : move) {
                            if (possible(pair[0] + ints[0], pair[1] + ints[1], ch, vis)) {
                                vis[pair[0] + ints[0]][pair[1] + ints[1]] = true;
                                queue.add(new int[]{pair[0] + ints[0], pair[1] + ints[1]});
                            }
                        }
                    }
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void displayVis(boolean[][] vis) {
        for(boolean b[]: vis) {
            for(boolean i: b) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    private static boolean possible(int i, int j, char[][] ch, boolean[][] vis) {
        return i>=0 && j>=0 && i<ch.length && j<ch[0].length && !vis[i][j] && ch[i][j] == '.';
    }
}
