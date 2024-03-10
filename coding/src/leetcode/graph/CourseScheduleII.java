package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj= new List[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] indegree = new int[numCourses];
        for(int[] i: prerequisites) {
            indegree[i[0]]++;
            adj[i[1]].add(i[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] ans = new int[numCourses];
        int k = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                ans[k++] = i;
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int i: adj[curr]) {
                indegree[i]--;

                if (indegree[i] == 0) {
                    queue.add(i);
                    ans[k++] = i;
                }
            }
        }

        if (k != numCourses) {
            return new int[numCourses];
        } else {
            return ans;
        }
    }
}
