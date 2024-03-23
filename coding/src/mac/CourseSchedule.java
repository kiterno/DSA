package mac;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        List<Integer>[] adj = new List[numCourses];
        for (int i=0;i<numCourses;i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] pre: prerequisites) {
            adj[pre[0]].add(pre[1]);
            indegree[pre[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.add(i);
        }


        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;

            for(int neigh: adj[curr]) {
                indegree[neigh]--;

                if (indegree[neigh] == 0) queue.add(neigh);
            }
        }

        return count == numCourses;
    }
}
